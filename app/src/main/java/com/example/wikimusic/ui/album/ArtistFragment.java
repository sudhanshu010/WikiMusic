package com.example.wikimusic.ui.album;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wikimusic.R;

public class ArtistFragment extends Fragment {

    private String genreName;
    public ArtistFragment(String genreName) {

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
        Log.i("Sudhanshu","artistFragment");
        return inflater.inflate(R.layout.fragment_artist, container, false);
    }
}