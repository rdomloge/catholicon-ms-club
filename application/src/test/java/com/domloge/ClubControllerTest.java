package com.domloge;

import java.util.List;

import javax.inject.Inject;

import com.domloge.catholiconmsclublibrary.Club;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
public class ClubControllerTest {

    @Inject 
    ClubClient client;

    public ClubClient getClient() {
        return client;
    }

    public void setClient(ClubClient client) {
        this.client = client;
    }

    @Test
    public void testListClubs() {
        Assertions.assertNotNull(client);
        Assertions.assertEquals(2, client.list().size());
    }

    @Client
    interface ClubClient {
        @Get("/clubs")
        List<Club> list();
    }
}
