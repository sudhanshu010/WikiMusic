package com.example.wikimusic.ui.album;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wikimusic.R;

public class TracksFragment extends Fragment {

    String genreName;

    public TracksFragment(String genreName) {

        this.genreName = genreName;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("Sudhanshu","tracksFragment");
        return inflater.inflate(R.layout.fragment_tracks, container, false);
    }
}