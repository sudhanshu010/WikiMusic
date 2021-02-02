package com.example.wikimusic.ui.genre.genreDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.example.wikimusic.R;
import com.example.wikimusic.databinding.ActivityGenreDetailsBinding;
import com.example.wikimusic.models.genre.Genre;
import com.example.wikimusic.viewmodels.GenreDetailsViewModel;

public class GenreDetailsActivity extends AppCompatActivity {

    private ActivityGenreDetailsBinding activityGenreDetailsBinding;
    private GenreDetailsViewModel genreDetailsViewModel;
    String genreName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityGenreDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_genre_details);

        genreName = getIntent().getStringExtra("genreName");

        genreDetailsViewModel = ViewModelProviders.of(this).get(GenreDetailsViewModel.class);
        genreDetailsViewModel.init(genreName);
        genreDetailsViewModel.getGenre().observe(this, new Observer<Genre>() {
            @Override
            public void onChanged(Genre genre) {
                activityGenreDetailsBinding.setDescription(genre.getDescriptionWrapper().getGenreDesrciption());
            }
        });
    }
}