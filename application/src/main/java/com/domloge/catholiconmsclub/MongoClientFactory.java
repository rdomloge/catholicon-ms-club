package com.domloge.catholiconmsclub;

import javax.inject.Singleton;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import io.micronaut.context.annotation.Factory;

@Factory
public class MongoClientFactory {
    
    @Singleton 
    MongoClient mongoClient() {
        return MongoClients.create();
    }
}
