package com.example.retrofitapiproject;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapiproject.recycler.ItemsMe;
import com.example.retrofitapiproject.recycler.adapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL ="https://www.thesportsdb.com/api/v1/json/3/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfaceService service = retrofit.create(InterfaceService.class);
        Call<TeamResponse> call = service.getTeams();

        RecyclerView recyclerView = findViewById(R.id.recycl);
        List<ItemsMe> team = new ArrayList<>();

        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful()){
                    TeamResponse teamResponse = response.body();

                    if (teamResponse != null) {
                        List<Teams> teams = teamResponse.getTeams();
                        for (int i = 0; i < teams.size(); i++) {
                            team.add(new ItemsMe(teams.get(i).getStrTeam(), teams.get(i).getStrTeamBadge()));
                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recyclerView.setAdapter(new adapter(MainActivity.this, team));
                    }

                    } else {
                    Toast.makeText(MainActivity.this, "Oops, something happened!", Toast.LENGTH_SHORT).show();
                    }
                }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Oops, something happened!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}