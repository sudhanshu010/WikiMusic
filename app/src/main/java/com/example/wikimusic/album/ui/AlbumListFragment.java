package com.example.wikimusic.album.ui;

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
import com.example.wikimusic.databinding.FragmentAlbumBinding;
import com.example.wikimusic.album.models.Album;
import com.example.wikimusic.album.viewmodels.AlbumListViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AlbumListFragment extends Fragment implements AlbumListListener{

    private FragmentAlbumBinding fragmentAlbumBinding;
    private AlbumListViewModel albumListViewModel;
    private List<Album> albumList;
    private String genreName;
    private AlbumListAdapter albumListAdapter;
    GridLayoutManager gridLayoutManager;

    public AlbumListFragment(String genreName) {
        this.genreName = genreName;
    }

    public AlbumListFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentAlbumBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_album,container,false);
        genreName = getArguments().getString("genreName");

        albumList = new ArrayList<>();

        albumListViewModel = ViewModelProviders.of(this).get(AlbumListViewModel.class);
        albumListViewModel.init(genreName);
        albumListViewModel.setAlbumListListener(this);
        albumListViewModel.getAlbumList().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albums) {

                albumList.addAll(albums);
                albumListAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();

        return fragmentAlbumBinding.getRoot();
    }

    @Override
    public void onAlbumSelected(Album album) {

        Intent i = new Intent(getContext(),AlbumDetailsActivity.class);
        i.putExtra("artistName",album.getArtist().getName());
        i.putExtra("albumName",album.getName());
        Objects.requireNonNull(getActivity()).startActivity(i);
    }

    public void initRecyclerView(){

        gridLayoutManager = new GridLayoutManager(this.getContext(),2);
        albumListAdapter = new AlbumListAdapter(albumList,albumListViewModel,this.getContext());
        fragmentAlbumBinding.setAdapter(albumListAdapter);
        fragmentAlbumBinding.setLayoutManager(gridLayoutManager);
    }
}