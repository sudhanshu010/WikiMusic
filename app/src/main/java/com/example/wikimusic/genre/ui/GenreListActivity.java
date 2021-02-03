package com.example.wikimusic.genre.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.wikimusic.R;
import com.example.wikimusic.genre.adapters.GenreListAdapter;
import com.example.wikimusic.databinding.ActivityGenreListBinding;
import com.example.wikimusic.genre.models.Genre;
import com.example.wikimusic.genre.models.GenreList;
import com.example.wikimusic.genre.viewmodels.GenreListViewModel;

import java.util.List;

public class GenreListActivity extends AppCompatActivity implements GenreListListener {

    private ActivityGenreListBinding binding;
    private GenreListViewModel genreListViewModel;
    private GenreListAdapter genreListAdapter;

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
                genreListViewModel.getExpand().observe(GenreListActivity.this, new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean aBoolean) {

                        if(aBoolean)
                            genreListAdapter = new GenreListAdapter(genres, genreListViewModel, getApplicationContext());
                        else
                            genreListAdapter = new GenreListAdapter(genres.subList(10,genres.size()),genreListViewModel,getApplicationContext());
                        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
                        binding.setAdapter(genreListAdapter);
                        binding.setLayoutManager(gridLayoutManager);
                    }
                });
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