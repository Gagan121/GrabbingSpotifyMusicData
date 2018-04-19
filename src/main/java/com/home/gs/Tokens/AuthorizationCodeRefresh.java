package com.home.gs.Tokens;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRefreshRequest;

import java.io.IOException;


public class AuthorizationCodeRefresh {
    private static final String clientId = "2945f422c327442cad2e0ee7f4223162";
    private static final String clientSecret = "d73762cb966c424aad54014969b090bc";
    private static final String refreshToken = "AQCgFiTPzOy4Vk2PTnGl93JYYHWRaRdQGERx1TMC2H-yd4-kr6Y0pnfML2jmL65N5o0TaYQOtUZwmb7tyNUbLtKHrhmi5PbacsxXfNK2q_Whx-le_U3uySedJYSP-oFy6aw";




    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .setRefreshToken(refreshToken)
            .build();



    private static final AuthorizationCodeRefreshRequest authorizationCodeRefreshRequest = spotifyApi.authorizationCodeRefresh()
            .build();

    public static SpotifyApi authorizationCodeRefresh_Sync() {
        try {
            final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRefreshRequest.execute();

            // Set access and refresh token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
            spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());

        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return spotifyApi;
    }

}