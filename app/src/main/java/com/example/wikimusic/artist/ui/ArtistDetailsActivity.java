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
import com.example.wikimusic.album.adapters.AlbumListAdapter;
import com.example.wikimusic.album.models.Album;
import com.example.wikimusic.album.ui.AlbumDetailsActivity;
import com.example.wikimusic.album.ui.AlbumListListener;
import com.example.wikimusic.album.viewmodels.AlbumListViewModel;
import com.example.wikimusic.album.viewmodels.ArtistAlbumViewModel;
import com.example.wikimusic.artist.models.Artist;
import com.example.wikimusic.artist.viewmodels.ArtistDetailsViewModel;
import com.example.wikimusic.databinding.ActivityArtistDetailsBinding;
import com.example.wikimusic.genre.adapters.GenreListAdapter;
import com.example.wikimusic.genre.models.Genre;
import com.example.wikimusic.genre.ui.GenreDetailsActivity;
import com.example.wikimusic.genre.ui.GenreListListener;
import com.example.wikimusic.genre.viewmodels.GenreListViewModel;
import com.example.wikimusic.track.adapters.TrackListAdapter;
import com.example.wikimusic.track.models.Track;
import com.example.wikimusic.track.ui.TrackListListener;
import com.example.wikimusic.track.viewmodels.ArtistTrackViewModel;
import com.example.wikimusic.track.viewmodels.TrackListViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArtistDetailsActivity extends AppCompatActivity implements GenreListListener, TrackListListener, AlbumListListener {

    private ActivityArtistDetailsBinding activityArtistDetailsBinding;
    private ArtistDetailsViewModel artistDetailsViewModel;
    private ArtistTrackViewModel artistTrackViewModel;
    private ArtistAlbumViewModel artistAlbumViewModel;
    private String artistName;
    RecyclerView genreChips, topAlbums, topTracks;
    private ImageView artistImage;
    private List<Genre> genreList;
    private List<Track> trackList;
    private List<Album> albumList;
    private GenreListAdapter genreListAdapter;
    private TrackListAdapter trackListAdapter;
    private AlbumListAdapter albumListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityArtistDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_artist_details);

        artistName = getIntent().getStringExtra("artistName");

        artistImage = findViewById(R.id.artistImage);
        genreChips = findViewById(R.id.genreChips);
        topTracks = findViewById(R.id.topTrackList);
        topAlbums = findViewById(R.id.topAlbumsList);

        genreList = new ArrayList<>();
        trackList = new ArrayList<>();
        albumList = new ArrayList<>();

        artistDetailsViewModel = ViewModelProviders.of(this).get(ArtistDetailsViewModel.class);
        artistDetailsViewModel.init(artistName);
        artistDetailsViewModel.getArtist().observe(this, new Observer<Artist>() {
            @Override
            public void onChanged(Artist artist) {

                String url = artist.getImageList().get(3).getUrl();
                Picasso.get().load(url).into(artistImage);
                activityArtistDetailsBinding.setArtistDetails(artist);
                genreList.addAll(artist.getGenreList().getGenreList());
                genreListAdapter.notifyDataSetChanged();
            }
        });

        artistTrackViewModel = ViewModelProviders.of(this).get(ArtistTrackViewModel.class);
        artistTrackViewModel.init(artistName);
        artistTrackViewModel.setTrackListListener(this);
        artistTrackViewModel.getTrackList().observe(this, new Observer<List<Track>>() {
            @Override
            public void onChanged(List<Track> tracks) {
                trackList.addAll(tracks);
                trackListAdapter.notifyDataSetChanged();
            }
        });

        artistAlbumViewModel = ViewModelProviders.of(this).get(ArtistAlbumViewModel.class);
        artistAlbumViewModel.init(artistName);
        artistAlbumViewModel.setAlbumListListener(this);
        artistAlbumViewModel.getAlbumList().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albums) {
                albumList.addAll(albums);
                albumListAdapter.notifyDataSetChanged();
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

        LinearLayoutManager linearLayoutManagerVertical = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        trackListAdapter = new TrackListAdapter(trackList,new TrackListViewModel(),this);
        topTracks.setLayoutManager(linearLayoutManagerVertical);
        topTracks.setAdapter(trackListAdapter);

        AlbumListViewModel albumListViewModel = new AlbumListViewModel();
        albumListViewModel.setAlbumListListener(this);
        linearLayoutManagerHorizontal = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        albumListAdapter = new AlbumListAdapter(albumList,albumListViewModel,this);
        topAlbums.setLayoutManager(linearLayoutManagerHorizontal);
        topAlbums.setAdapter(albumListAdapter);

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

    @Override
    public void onAlbumSelected(Album album) {
        Intent i = new Intent(this, AlbumDetailsActivity.class);
        i.putExtra("artistName",album.getName());
        startActivity(i);
    }

    @Override
    public void onTrackSelected(Track track) {

    }
}