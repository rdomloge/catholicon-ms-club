package com.domloge.catholiconmsclub;

import javax.inject.Singleton;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.context.annotation.Factory;


@Factory
public class MyFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClubConfiguration.class);

    private final ClubConfiguration config;
    
    public MyFactory(ClubConfiguration configuration) {
        this.config = configuration;
    }

    @Singleton
    public MongoClient mongoClient() {
        String connectionUri = config.getConnectionUri();
        LOGGER.info("Connection URI: {}", connectionUri);
        return MongoClients.create(connectionUri);
    }
}
