package com.example.wikimusic.artist.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wikimusic.R;
import com.example.wikimusic.databinding.FragmentArtistBinding;
import com.example.wikimusic.artist.models.Artist;
import com.example.wikimusic.artist.viewmodels.ArtistListViewModel;

import java.util.List;

public class ArtistListFragment extends Fragment implements ArtistListListener{

    private FragmentArtistBinding fragmentArtistBinding;
    private ArtistListViewModel artistListViewModel;
    private String genreName;
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
        artistListViewModel = ViewModelProviders.of(this).get(ArtistListViewModel.class);
        artistListViewModel.init(genreName);
        artistListViewModel.setArtistListListener(this);
        artistListViewModel.getArtistList().observe(this, new Observer<List<Artist>>() {
            @Override
            public void onChanged(List<Artist> artists) {

            }
        });

        return fragmentArtistBinding.getRoot();
    }

    @Override
    public void onArtistSelected(Artist artist) {

    }
}