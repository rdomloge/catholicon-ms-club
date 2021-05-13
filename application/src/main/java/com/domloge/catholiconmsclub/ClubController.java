package com.domloge.catholiconmsclub;

import java.util.List;

import javax.validation.Valid;

import com.domloge.catholiconmsclublibrary.Club;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import org.reactivestreams.Publisher;

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

    private final ClubRepository clubRepository;

    
    public ClubController(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Get("/")
    Single<List<Club>> list() {
        return clubRepository.list();
    }

    @Get("/search/findClubByClubIdAndSeasonId")
    Maybe<Club> findClubByClubIdAndSeasonId(@QueryValue int clubId, @QueryValue int season) {
        return clubRepository.find(clubId, season);
    }

    @Get("/search/findClubBySeason")
    Maybe<Club> findClubByTeamId(@QueryValue int teamId) {
        return clubRepository.findClubByTeamId(teamId);
    }

    @Get("/search/findClubByTeamId")
    Single<List<Club>> findClubBySeason(@QueryValue int teamId) {
        return clubRepository.find(teamId);
    }

    @Get("/search/countClubBySeason")
    Single<Long> countClubBySeason(@QueryValue int season) {
        return clubRepository.count(season);
    }

    @Patch("/")
    void updateClub(@Valid @Body T club) {
        clubRepository.update(club);
    }

    @Post("/")
    Single<Club> save(@Valid @Body T club) {
        return clubRepository.save(club);
    }

    @Delete("/")
    void delete(@QueryValue int clubId, @QueryValue int season) {
        clubRepository.delete(clubId, season);
    }
}
