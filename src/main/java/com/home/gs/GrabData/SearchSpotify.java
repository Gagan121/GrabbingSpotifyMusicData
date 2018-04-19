package com.home.gs.GrabData;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SearchSpotify {



    public static List<Track> searchTracks_Async(SpotifyApi spotifyApi, String q, int numOfSongs) {

        //list to hold all of the tracks
        List<Track> trackList = null;
        try {

            trackList = new ArrayList<>();
            //as only 50 tracks per request can be obtained multiple requests are made until the maximum is reached
            //denoted by numOfSongs
            for (int i = 0; i < numOfSongs; i+=50) {
                SearchTracksRequest searchTracksRequest= spotifyApi.searchTracks(q)
                        .market(CountryCode.SE)
                        .limit(50)
                        .offset(i)
                        .build();
                //lamda expression used to thread getting the data
                final Future<Paging<Track>> pagingFuture = searchTracksRequest.executeAsync();

                trackList.addAll( Arrays.asList(pagingFuture.get().getItems()) );

            }

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        }
        return trackList;
    }


}
