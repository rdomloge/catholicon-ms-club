package com.domloge.catholiconmsclub;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;

import java.util.List;

import javax.inject.Singleton;
import javax.validation.Valid;

import com.domloge.catholiconmsclublibrary.Club;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;

import org.bson.conversions.Bson;
import org.reactivestreams.Publisher;

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

    public Publisher<UpdateResult> update(@Valid Club c) {
        Bson filter = and(eq("clubId", c.getClubId()), eq("seasonId", c.getSeasonId()));
        return getCollection().replaceOne(filter, c);
    }

    public Publisher<DeleteResult> delete(int clubId, int season) {
        Bson filter = and(eq("clubId", clubId), eq("seasonId", season));
        return getCollection().deleteOne(filter);
    }

    private MongoCollection<Club> getCollection() {
        return mongoClient
                .getDatabase(configuration.getDatabaseName())
                .getCollection(configuration.getCollectionName(), Club.class);
    }
}
