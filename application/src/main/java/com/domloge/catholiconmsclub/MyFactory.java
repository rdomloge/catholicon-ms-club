package com.domloge.catholiconmsclub;

import javax.inject.Singleton;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import io.micronaut.context.annotation.Factory;


@Factory
public class MyFactory {

    private final ClubConfiguration config;
    
    public MyFactory(ClubConfiguration configuration) {
        this.config = configuration;
    }

    @Singleton
    public MongoClient mongoClient() {
        return MongoClients.create(config.getConnectionUri());
    }
}
