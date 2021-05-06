package com.domloge.catholiconmsclub;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;

import com.domloge.catholiconmsclublibrary.Club;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;

import org.bson.conversions.Bson;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Singleton
public class ClubRepository {
    
    private final MongoClient mongoClient;

    private final ClubConfiguration configuration;

    public ClubRepository(MongoClient mongoClient, ClubConfiguration configuration) {
        this.mongoClient = mongoClient;
        this.configuration = configuration;
    }

    public Single<List<Club>> list() {
        return Flowable.fromPublisher(getCollection().find()).toList();
    }

    public Single<List<Club>> byId(int id) {
        return Flowable.fromPublisher(getCollection().find(eq("id", id))).toList();
    }

    public Maybe<Club> find(int clubId, int season) {
        return Flowable.fromPublisher(getCollection().find(
            and(eq("clubId", clubId), eq("seasonId", season)))
            .limit(1)).firstElement();
    }

    public Single<List<Club>> find(int season) {
        return Flowable.fromPublisher(getCollection().find(
            eq("seasonId", season))
            ).toList();
    }

    public Single<Long> count(int season) {
        return Flowable.fromPublisher(getCollection().find(
            eq("seasonId", season))
            ).count();
    }

    public Single<Club> save(@Valid Club c) {
        return find(c.getClubId(), c.getSeasonId())
                .switchIfEmpty(
                    Single.fromPublisher(getCollection().insertOne(c))
                        .map(success -> c)
                );
    }

    public void update(@Valid Club c) {
        Bson filter = and(eq("clubId", c.getClubId()), eq("seasonId", c.getSeasonId()));
        Publisher<UpdateResult> replaceOne = getCollection().replaceOne(filter, c);
        replaceOne.subscribe(new Subscriber<UpdateResult>(){

            @Override
            public void onSubscribe(Subscription s) {
                s.request(1);
            }

            @Override
            public void onNext(UpdateResult t) {
                
            }

            @Override
            public void onError(Throwable t) {
                
            }

            @Override
            public void onComplete() {
                
            }});
    }

    public void delete(int clubId, int season) {
        Bson filter = and(eq("clubId", clubId), eq("seasonId", season));
        getCollection().deleteOne(filter).subscribe(new Subscriber<DeleteResult>(){

            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe");
                s.request(1);
            }

            @Override
            public void onNext(DeleteResult t) {
                System.out.println("onNext");
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }});
    }

    private MongoCollection<Club> getCollection() {
        return mongoClient
                .getDatabase(configuration.getDatabaseName())
                .getCollection(configuration.getCollectionName(), Club.class);
    }
}
