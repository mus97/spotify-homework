package com.spotify.mus97.ui.steps;

import com.spotify.mus97.ui.entity.Track;
import com.spotify.mus97.ui.pages.AuthorizedHomepage;
import com.spotify.mus97.ui.pages.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultStep extends SearchResultPage {

    List<Track> trackList;

    public SearchResultStep openSearchResultByRequest(String searchQuery) {
        new AuthorizedHomepage().clickSearchButton()
                .writeSearchQuery(searchQuery);
        logger.info("You searched for: " + searchQuery);
        return this;
    }

    public List<Track> createSearchResultList() {
        String artistName;
        trackList = new ArrayList<>();
        waitForVisibilityOfElements(artistTracks);
        logger.info("Most popular songs:");
        for (WebElement artistTrack : artistTracks) {
            String trackName = waitForVisibilityOfElement(artistTrack).findElement(By.xpath(".//*[@class='Type__TypeElement-goli3j-0 fCtMzo t_yrXoUO3qGsJS4Y6iXX standalone-ellipsis-one-line']")).getText();
            try {
                artistName = waitForVisibilityOfElement(artistTrack).findElement(By.xpath(".//*[@class='Type__TypeElement-goli3j-0 hHrtFe rq2VQ5mb9SDAFWbBIUIn standalone-ellipsis-one-line']/a")).getText();
            } catch (Exception e) {
                artistName = "no name";
            }
            trackList.add(new Track(trackName, artistName));
        }
        logger.info(trackList);
        return trackList;
    }

    public boolean doesSearchResultListContainArtist(String artist) {
        if (trackList == null) {
            trackList = createSearchResultList();
        }
        return trackList.stream().anyMatch(s -> s.getArtist().contains(artist));
    }
}

