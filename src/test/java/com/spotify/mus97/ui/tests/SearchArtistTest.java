package com.spotify.mus97.ui.tests;

import com.spotify.mus97.ui.steps.SearchResultStep;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchArtistTest extends AbstractTest{

    @DataProvider (name = "artistNames")
    public  Object[] artistNamesProvider(){
        return new Object[]{"fgdv"};
    }

    @Test(dataProvider = "artistNames")
    public void testArtistHasTracks(String artist){
        SearchResultStep searchResultStep=new SearchResultStep().openSearchResultByRequest(artist);
        Assert.assertTrue(searchResultStep.doesSearchResultListContainArtist(artist));

    }
}
