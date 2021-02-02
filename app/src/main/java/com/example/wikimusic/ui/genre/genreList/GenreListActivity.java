package com.example.wikimusic.ui.genre.genreList;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.wikimusic.R;
import com.example.wikimusic.adapters.GenreListAdapter;
import com.example.wikimusic.databinding.ActivityGenreListBinding;
import com.example.wikimusic.models.genre.Genre;
import com.example.wikimusic.ui.genre.genreDetails.GenreDetailsActivity;
import com.example.wikimusic.viewmodels.GenreListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GenreListActivity extends AppCompatActivity implements GenreListListener {

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
        genreListViewModel.setGenreListListener(GenreListActivity.this);
        genreListViewModel.getGenreList().observe(this, new Observer<List<Genre>>() {
            @Override
            public void onChanged(List<Genre> genres) {
                genreListAdapter = new GenreListAdapter(genres, genreListViewModel, getApplicationContext());
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2,GridLayoutManager.VERTICAL,false);
                binding.setAdapter(genreListAdapter);
                binding.setLayoutManager(gridLayoutManager);
            }
        });
    }

    @Override
    public void onStarted() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onGenreSelected(Genre genre) {
        Intent i = new Intent(this, GenreDetailsActivity.class);
        i.putExtra("genreName",genre.getName());
        startActivity(i);
    }
}