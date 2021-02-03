package com.example.wikimusic.album.ui;

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
import android.widget.LinearLayout;

import com.example.wikimusic.R;
import com.example.wikimusic.album.models.Album;
import com.example.wikimusic.album.models.AlbumDetails;
import com.example.wikimusic.album.viewmodels.AlbumDetailsViewModel;
import com.example.wikimusic.databinding.ActivityAlbumDetailsBinding;
import com.example.wikimusic.genre.adapters.GenreListAdapter;
import com.example.wikimusic.genre.models.Genre;
import com.example.wikimusic.genre.ui.GenreDetailsActivity;
import com.example.wikimusic.genre.ui.GenreListListener;
import com.example.wikimusic.genre.viewmodels.GenreListViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AlbumDetailsActivity extends AppCompatActivity implements GenreListListener {

    private ActivityAlbumDetailsBinding activityAlbumDetailsBinding;
    private AlbumDetailsViewModel albumDetailsViewModel;
    private List<Genre> genreList;
    private GenreListAdapter genreListAdapter;
    private String albumName,artistName;
    private ImageView albumImage;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAlbumDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_album_details);

        albumImage = findViewById(R.id.albumImage);
        recyclerView = findViewById(R.id.genreChips);

        albumName = getIntent().getStringExtra("albumName");
        artistName = getIntent().getStringExtra("artistName");

        genreList = new ArrayList<>();

        albumDetailsViewModel = ViewModelProviders.of(this).get(AlbumDetailsViewModel.class);
        albumDetailsViewModel.init(albumName,artistName);
        albumDetailsViewModel.getAlbum().observe(this, new Observer<AlbumDetails>() {
            @Override
            public void onChanged(AlbumDetails album) {
                activityAlbumDetailsBinding.setAlbum(album);
                Picasso.get().load(album.getImageList().get(3).getUrl()).into(albumImage);
                genreList.addAll(album.getGenreList().getGenreList());
                genreListAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();
    }

    private void initRecyclerView(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        GenreListViewModel genreListViewModel = new GenreListViewModel();
        genreListViewModel.setGenreListListener(this);
        genreListAdapter = new GenreListAdapter(genreList,genreListViewModel,this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(genreListAdapter);
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