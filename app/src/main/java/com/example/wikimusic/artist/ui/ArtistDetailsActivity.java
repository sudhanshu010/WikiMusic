package com.example.wikimusic.artist.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.wikimusic.R;
import com.example.wikimusic.artist.models.Artist;
import com.example.wikimusic.artist.viewmodels.ArtistDetailsViewModel;
import com.example.wikimusic.databinding.ActivityArtistDetailsBinding;
import com.example.wikimusic.genre.adapters.GenreListAdapter;
import com.example.wikimusic.genre.models.Genre;
import com.example.wikimusic.genre.ui.GenreDetailsActivity;
import com.example.wikimusic.genre.ui.GenreListListener;
import com.example.wikimusic.genre.viewmodels.GenreListViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ArtistDetailsActivity extends AppCompatActivity implements GenreListListener {

    private ActivityArtistDetailsBinding activityArtistDetailsBinding;
    private ArtistDetailsViewModel artistDetailsViewModel;
    private String artistName;
    RecyclerView genreChips, topAlbums, topTracks;
    private ImageView artistImage;
    private List<Genre> genreList;
    private GenreListAdapter genreListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityArtistDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_artist_details);

        artistName = getIntent().getStringExtra("artistName");

        artistImage = findViewById(R.id.artistImage);
        genreChips = findViewById(R.id.genreChips);

        genreList = new ArrayList<>();

        artistDetailsViewModel = ViewModelProviders.of(this).get(ArtistDetailsViewModel.class);
        artistDetailsViewModel.init(artistName);
        artistDetailsViewModel.getArtist().observe(this, new Observer<Artist>() {
            @Override
            public void onChanged(Artist artist) {

                String url = artist.getImageList().get(3).getUrl();
                Picasso.get().load(url).into(artistImage);
                genreList.addAll(artist.getGenreList().getGenreList());
                genreListAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }

    public void initRecyclerView(){

        LinearLayoutManager linearLayoutManagerHorizontal = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        GenreListViewModel genreListViewModel = new GenreListViewModel();
        genreListViewModel.setGenreListListener(this);
        genreListAdapter = new GenreListAdapter(genreList, genreListViewModel,this);
        genreChips.setAdapter(genreListAdapter);
        genreChips.setLayoutManager(linearLayoutManagerHorizontal);
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