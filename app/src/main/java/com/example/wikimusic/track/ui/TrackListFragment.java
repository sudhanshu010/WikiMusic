package com.example.wikimusic.track.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wikimusic.R;
import com.example.wikimusic.databinding.FragmentTracksBinding;
import com.example.wikimusic.track.models.Track;
import com.example.wikimusic.track.viewmodels.TrackListViewModel;

import java.util.List;

public class TrackListFragment extends Fragment implements TrackListListener{

    private FragmentTracksBinding fragmentTracksBinding;
    private TrackListViewModel trackListViewModel;
    private String genreName;

    public TrackListFragment(String genreName) {

        this.genreName = genreName;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentTracksBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_tracks,container,false);
        genreName = getArguments().getString("genreName");
        trackListViewModel = ViewModelProviders.of(this).get(TrackListViewModel.class);
        trackListViewModel.init(genreName);
        trackListViewModel.setTrackListListener(this);
        trackListViewModel.getTrackList().observe(this, new Observer<List<Track>>() {
            @Override
            public void onChanged(List<Track> tracks) {
                Log.i("Sudhanshu_Track",tracks.get(0).getName());
            }
        });
        return fragmentTracksBinding.getRoot();
    }

    @Override
    public void onTrackSelected(Track track) {

    }
}