package com.domloge.catholiconmsclub;

import javax.inject.Singleton;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;

@Factory
public class MyFactory {

    @Value("${mongoHost:defaultNotSpecified}")
    private String host;
    
    @Singleton
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://admin:password@"+host+":27017");
    }
}
