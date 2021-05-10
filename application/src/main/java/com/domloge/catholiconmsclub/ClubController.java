package com.domloge.catholiconmsclub;

import java.util.List;

import javax.validation.Valid;

import com.domloge.catholiconmsclublibrary.Club;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Controller("/clubs")
public class ClubController<T extends Club> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClubController.class);

    private final ClubRepository clubRepository;

    
    public ClubController(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Get("/")
    Single<List<Club>> list() {
        LOGGER.trace("list()");
        return clubRepository.list();
    }

    @Get("/search/findClubByClubIdAndSeasonId")
    Maybe<Club> findClubByClubIdAndSeasonId(@QueryValue int clubId, @QueryValue int season) {
        LOGGER.trace("findClubByClubIdAndSeasonId");
        return clubRepository.find(clubId, season);
    }

    @Get("/search/findClubBySeason")
    Single<List<Club>> findClubBySeason(@QueryValue int season) {
        LOGGER.trace("findClubBySeason");
        return clubRepository.find(season);
    }

    @Get("/search/countClubBySeason")
    Single<Long> countClubBySeason(@QueryValue int season) {
        LOGGER.trace("countClubBySeason");
        return clubRepository.count(season);
    }

    @Patch("/")
    Publisher<UpdateResult> updateClub(@Valid @Body T club) {
        LOGGER.trace("updateClub");
        return clubRepository.update(club);
    }

    @Post("/")
    Single<Club> save(@Valid @Body T club) {
        LOGGER.trace("save");
        return clubRepository.save(club);
    }

    @Delete("/")
    Publisher<DeleteResult> delete(@QueryValue int clubId, @QueryValue int season) {
        LOGGER.trace("delete");
        return clubRepository.delete(clubId, season);
    }
}
