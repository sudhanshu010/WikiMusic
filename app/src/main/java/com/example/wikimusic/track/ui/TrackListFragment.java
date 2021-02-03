package com.example.wikimusic.track.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wikimusic.R;
import com.example.wikimusic.databinding.FragmentTracksBinding;
import com.example.wikimusic.track.adapters.TrackListAdapter;
import com.example.wikimusic.track.models.Track;
import com.example.wikimusic.track.viewmodels.TrackListViewModel;

import java.util.ArrayList;
import java.util.List;

public class TrackListFragment extends Fragment implements TrackListListener{

    private FragmentTracksBinding fragmentTracksBinding;
    private TrackListViewModel trackListViewModel;
    private String genreName;
    private List<Track> trackList;
    private TrackListAdapter trackListAdapter;
    LinearLayoutManager linearLayoutManager;

    public TrackListFragment(String genreName) {

        this.genreName = genreName;
    }

    public TrackListFragment(){

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
        trackList = new ArrayList<>();
        trackListViewModel = ViewModelProviders.of(this).get(TrackListViewModel.class);
        trackListViewModel.init(genreName);
        trackListViewModel.setTrackListListener(this);

        trackListViewModel.getTrackList().observe(this, new Observer<List<Track>>() {
            @Override
            public void onChanged(List<Track> tracks) {
                Log.i("Sudhanshu",tracks.get(1).getName());

                trackList.addAll(tracks);
                trackListAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
        return fragmentTracksBinding.getRoot();
    }

    @Override
    public void onTrackSelected(Track track) {

    }

    public void initRecyclerView(){

        linearLayoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL,false);
        trackListAdapter = new TrackListAdapter(trackList,trackListViewModel,this.getContext());
        fragmentTracksBinding.setAdapter(trackListAdapter);
        fragmentTracksBinding.setLayoutManager(linearLayoutManager);

    }
}