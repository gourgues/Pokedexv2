package com.example.pokedexv2;

import com.example.pokedexv2.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface PokemonRestApi {

    @GET("pokedex.json")
    Call<PokemonResponse> getListPokemon();
}
