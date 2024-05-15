package com.example.retrofitapiproject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceService {
    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<TeamResponse> getTeams();
}
