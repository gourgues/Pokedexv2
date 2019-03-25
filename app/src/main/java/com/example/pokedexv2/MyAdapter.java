package com.example.pokedexv2;

import com.example.pokedexv2.PokemonDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CelluleJava> {

    public interface OnItemClickListener {
        void onItemClick(PokemonDetails item);
    }

    private List<PokemonDetails> pokemons;
    private final OnItemClickListener listener;


    // construsteur //
    public MyAdapter(List<PokemonDetails> items, OnItemClickListener listener) {
        this.pokemons = items;
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        View vbis = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    public class CelluleJava extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtpokemonName;
        public TextView txtpokemonId;
        public ImageView imgpokemonImage;
        public View layout;


        //Constructeur
        public CelluleJava(View v) {
            super(v);
            layout = v;
            txtpokemonName = (TextView) v.findViewById(R.id.pokemon_name);
            txtpokemonId = (TextView) v.findViewById(R.id.pokemon_id);
            imgpokemonImage = (ImageView) v.findViewById(R.id.pokemon_image);

        }

    }

    public void add(int position, PokemonDetails item) {
        pokemons.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        pokemons.remove(position);
        notifyItemRemoved(position);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CelluleJava holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final PokemonDetails currentPokemon = pokemons.get(position);

        holder.txtpokemonName.setText(currentPokemon.getName());
        holder.txtpokemonId.setText(currentPokemon.getId());
        Picasso.get().load(currentPokemon.getImage()).into(holder.imgpokemonImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(currentPokemon);
            }


        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return pokemons.size();
    }
}