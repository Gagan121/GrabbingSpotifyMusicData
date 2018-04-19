package com.home.gs.Controller;


import com.home.gs.CustomDataTypeForSpotify.CustomMadeTrack;
import com.home.gs.GrabData.SearchSpotify;
import com.home.gs.Input.DataInput;
import com.home.gs.Output.DataOutput;
import com.home.gs.Tokens.AuthorizationCodeRefresh;
import com.home.gs.Tree.BinaryTreeEngine;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.specification.Track;


import java.util.List;

public class MainController implements ControllerInterface {
    public MainController(){

    }


    private String trackNameFromUser;
    private int numberOfTracks = 200;


    private void gatherUserInput(){
        //prompt the user to enter in details
        trackNameFromUser = DataInput.Input("Please enter a name or part of a name of a track/album/artist (e.g. you): ");
    }

    private List<Track> getSpotifyData(){
        //acquire the necessary data from the api
        SpotifyApi spotifyApi = AuthorizationCodeRefresh.authorizationCodeRefresh_Sync();
        return SearchSpotify.searchTracks_Async(spotifyApi,trackNameFromUser, numberOfTracks);
    }

    private List<CustomMadeTrack> storeIntoDataStructures(List<Track> trackList){
        //put the data into a data structure
        BinaryTreeEngine binaryTreeEngine = new BinaryTreeEngine();

        CustomMadeTrack[] customMadeTracks = new CustomMadeTrack[trackList.size()];

        for (int i =0; i< trackList.size(); i++){
            customMadeTracks[i] = new CustomMadeTrack(trackList.get(i));
        }

        binaryTreeEngine.settingNodes(customMadeTracks);
        //sort the tree
        return ((List<CustomMadeTrack>) binaryTreeEngine.getSortedTreeAsc());
    }



    public void run(){

        gatherUserInput();

        List<Track> trackList = getSpotifyData();
        //if its empty then no track of that name exist
        if(trackList.isEmpty()){
            DataOutput.printOutError("No Tracks found.");
            System.exit(0);
        }

        List<CustomMadeTrack> customMadeTracksList = storeIntoDataStructures(trackList);

        //print the list of sorted values out to see their popularity
        DataOutput.output(customMadeTracksList);

        System.exit(0);


    }
}
