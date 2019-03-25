package com.example.pokedexv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;


public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MainController myController;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        myController = new MainController(this);
        myController.onStart();

    }

    private void doYourUpdate(){
        swipeRefreshLayout.setRefreshing(false);
    }

    public void showList(List<PokemonDetails> input){

        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAdapter(input, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(PokemonDetails item) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name",item.getName());
                //intent.putExtra("description", item.getDescription());
                intent.putExtra("artwork", item.getArtwork());
                MainActivity.this.startActivity(intent);
            }
        });



        recyclerView.setAdapter(mAdapter);
    }

}
