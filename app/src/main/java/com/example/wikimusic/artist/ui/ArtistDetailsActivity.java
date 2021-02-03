package com.example.wikimusic.artist.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.wikimusic.R;
import com.example.wikimusic.artist.models.Artist;
import com.example.wikimusic.artist.viewmodels.ArtistDetailsViewModel;
import com.example.wikimusic.databinding.ActivityArtistDetailsBinding;

public class ArtistDetailsActivity extends AppCompatActivity {

    private ActivityArtistDetailsBinding activityArtistDetailsBinding;
    private ArtistDetailsViewModel artistDetailsViewModel;
    private String artistName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityArtistDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_artist_details);

        artistName = getIntent().getStringExtra("artistName");

        artistDetailsViewModel = ViewModelProviders.of(this).get(ArtistDetailsViewModel.class);
        artistDetailsViewModel.init(artistName);
        artistDetailsViewModel.getArtist().observe(this, new Observer<Artist>() {
            @Override
            public void onChanged(Artist artist) {
                Log.i("Sudhanshu_Data_fetch",artist.getName());
            }
        });
    }
}