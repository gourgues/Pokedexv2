package com.example.pokedexv2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.example.pokedexv2.PokemonDetails;
import com.example.pokedexv2.PokemonResponse;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private MainActivity myActivity;

    public MainController(MainActivity mainActivity) {
        this.myActivity = mainActivity;
    }

    public void onStart(){

        //Pour ceux qui veulent aller plus loin
        //Singleton
        //Pour ceux qui veulent aller encore plus loin
        // Injection de dépendances

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/gourgues/pokedex/master/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PokemonRestApi pokemonRestApi = retrofit.create(PokemonRestApi.class);

        Call<PokemonResponse> call = pokemonRestApi.getListPokemon();
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call,
                                   Response<PokemonResponse> response) {
                PokemonResponse pokemonResponse = response.body();
                List<PokemonDetails> listPokemon = pokemonResponse.getPokemon();
                myActivity.showList(listPokemon);
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });
    }

}