package com.example.pokedexv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getDetails();
    }

    private void getDetails(){

        // if(getIntent().hasExtra("nom")&& getIntent().hasExtra("détails")){
        Intent intent = getIntent();
        String pokemonName = intent.getStringExtra("name");
        String pokemonArtwork = intent.getStringExtra("artwork");

        recupDetails(pokemonName, pokemonArtwork);
        // }
    }

    private void recupDetails(String pokemonName, String pokemonArtwork){

        TextView Name = findViewById(R.id.details_pokemon_name);
        Name.setText(pokemonName);

        ImageView Artwork = findViewById(R.id.details_pokemon_artwork);
        Picasso.get().load(pokemonArtwork).into(Artwork);
    }
}