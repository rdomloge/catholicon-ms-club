package com.domloge.catholiconmsclub;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("application.properties")
public class ClubConfiguration {

    private String databaseName = "club";
    private String collectionName = "clubs";
    private String connectionUri;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getConnectionUri() {
        return connectionUri;
    }

    public void setConnectionUri(String connectionUri) {
        this.connectionUri = connectionUri;
    }
}