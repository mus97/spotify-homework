package com.spotify.mus97.ui.tests;

import com.spotify.mus97.ui.steps.SearchResultStep;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchArtistTest extends AbstractTest{

    @DataProvider (name = "Valid artist names")
    public  Object[] validArtistNamesProvider(){
        return new Object[]{"Linkin Park", "Sum 41", "Manowar"};
    }
    @DataProvider (name = "Invalid artist names")
    public  Object[] invalidArtistNamesProvider(){
        return new Object[]{"xcgv", "Zebrahead", "plk"};
    }

    @Test(dataProvider = "Valid artist names", description = "testing of searching with valid request")
    public void testArtistHasTracks(String artist){
        SearchResultStep searchResultStep=new SearchResultStep().openSearchResultByRequest(artist);
        Assert.assertTrue(searchResultStep.doesSearchResultListContainArtist(artist));
    }
    @Test(dataProvider = "Invalid artist names", description = "testing of searching with invalid request")
    public void testArtistHasTracksInvalid(String artist){
        SearchResultStep searchResultStep=new SearchResultStep().openSearchResultByRequest(artist);
        Assert.assertFalse(searchResultStep.doesSearchResultListContainArtist(artist));
    }
}
