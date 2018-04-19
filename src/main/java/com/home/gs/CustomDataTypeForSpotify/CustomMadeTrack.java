package com.home.gs.CustomDataTypeForSpotify;

import com.wrapper.spotify.model_objects.specification.Track;

public class CustomMadeTrack implements Comparable<CustomMadeTrack>{
    private Track track;

    //storing the track into another object like a wrapper and implementing the Comparable interface
    public CustomMadeTrack(Track track){
        this.track = track;
    }

    public Track getTrack() {
        return track;
    }

    //sorts based on Popularity of track most popular at the bottom
    @Override
    public int compareTo(CustomMadeTrack o) {
        if(track.getPopularity() > o.getTrack().getPopularity()){
            return 1;
        }else if(track.getPopularity() < o.getTrack().getPopularity()){
            return -1;
        }else {
            return 0;
        }

    }
}
