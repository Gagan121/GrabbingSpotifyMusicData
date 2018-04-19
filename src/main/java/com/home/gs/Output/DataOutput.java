package com.home.gs.Output;

import com.home.gs.CustomDataTypeForSpotify.CustomMadeTrack;
import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import com.wrapper.spotify.model_objects.specification.Track;

import java.util.List;

public class DataOutput implements OutputInterface {

    public static void output(List<CustomMadeTrack> customMadeTracks){
        StringBuilder stringBuilder =new StringBuilder();
        int counter = 0 ;
        for (CustomMadeTrack customTrack: customMadeTracks) {
            //gets the Track from each CustomMadeTrack
            Track track = customTrack.getTrack();
            //forms it into a long StringBuilder
            stringBuilder.append("Item number: " + ++counter +" -Track:  " +track.getName() + "  -from album: \t{" + track.getAlbum().getName()+ "}\t -the popularity is: "+"  <-" + track.getPopularity() +  " ->   artists are: \t{");
            for (ArtistSimplified artistSimplified:track.getArtists()) {
                stringBuilder.append(artistSimplified.getName() + ", ");
            }
            //remove the last space and comma
            stringBuilder.replace(stringBuilder.length()-2,stringBuilder.length(),"");
            stringBuilder.append("}");
            stringBuilder.append("\n");
        }
        printOutString( stringBuilder);

    }



    private static void printOutString(StringBuilder stringBuilder){
        System.out.println(stringBuilder.toString());
    }


    public static void printOutError(String str){
        System.out.println(str);
    }

}


