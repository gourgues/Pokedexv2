package com.example.pokedexv2;

import java.util.List;

public class PokemonResponse {
    private List<PokemonDetails> pokemon;

    public List<PokemonDetails> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<PokemonDetails> pokemon) {
        this.pokemon = pokemon;
    }
}
