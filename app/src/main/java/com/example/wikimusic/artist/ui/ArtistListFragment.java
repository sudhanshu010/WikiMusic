package com.example.wikimusic.artist.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wikimusic.R;
import com.example.wikimusic.album.adapters.AlbumListAdapter;
import com.example.wikimusic.artist.adapters.ArtistListAdapter;
import com.example.wikimusic.databinding.FragmentArtistBinding;
import com.example.wikimusic.artist.models.Artist;
import com.example.wikimusic.artist.viewmodels.ArtistListViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArtistListFragment extends Fragment implements ArtistListListener{

    private FragmentArtistBinding fragmentArtistBinding;
    private ArtistListViewModel artistListViewModel;
    private String genreName;
    private List<Artist> artistList;
    private ArtistListAdapter artistListAdapter;
    private GridLayoutManager gridLayoutManager;
    public ArtistListFragment(String genreName) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentArtistBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_artist,container,false);
        genreName = getArguments().getString("genreName");

        artistList = new ArrayList<>();

        artistListViewModel = ViewModelProviders.of(this).get(ArtistListViewModel.class);
        artistListViewModel.init(genreName);
        artistListViewModel.setArtistListListener(this);
        artistListViewModel.getArtistList().observe(this, new Observer<List<Artist>>() {
            @Override
            public void onChanged(List<Artist> artists) {

                artistList.addAll(artists);
                artistListAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();

        return fragmentArtistBinding.getRoot();
    }

    @Override
    public void onArtistSelected(Artist artist) {

       Intent i = new Intent(getContext(),ArtistDetailsActivity.class);
       i.putExtra("artistName",artist.getName());
       Objects.requireNonNull(getActivity()).startActivity(i);

    }

    public void initRecyclerView(){

        gridLayoutManager = new GridLayoutManager(this.getContext(),2);
        artistListAdapter = new ArtistListAdapter(artistList,artistListViewModel,this.getContext());
        fragmentArtistBinding.setAdapter(artistListAdapter);
        fragmentArtistBinding.setLayoutManager(gridLayoutManager);

    }
}