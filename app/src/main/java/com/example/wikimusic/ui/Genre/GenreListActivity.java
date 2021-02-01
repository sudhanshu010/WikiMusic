package com.example.wikimusic.ui.Genre;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.wikimusic.R;
import com.example.wikimusic.adapters.GenreListAdapter;
import com.example.wikimusic.databinding.ActivityGenreListBinding;
import com.example.wikimusic.models.genre.Genre;
import com.example.wikimusic.models.genre.GenreList;
import com.example.wikimusic.viewmodels.GenreListViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenreListActivity extends AppCompatActivity {

    private ActivityGenreListBinding binding;
    private GenreListViewModel genreListViewModel;
    private GenreListAdapter genreListAdapter;
    private List<Genre> genres = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_genre_list);

        genreListViewModel = ViewModelProviders.of(this).get(GenreListViewModel.class);
        genreListViewModel.init();


        genreListViewModel.getGenreList().observe(this, new Observer<List<Genre>>() {
            @Override
            public void onChanged(List<Genre> genres) {
                genreListAdapter = new GenreListAdapter(genres,getApplicationContext());
                binding.setAdapter(genreListAdapter);
            }
        });



    }
}