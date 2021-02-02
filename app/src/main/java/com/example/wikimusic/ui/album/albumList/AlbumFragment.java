package com.example.wikimusic.ui.album.albumList;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wikimusic.R;
import com.example.wikimusic.databinding.FragmentAlbumBinding;
import com.example.wikimusic.models.Album.Album;
import com.example.wikimusic.models.Album.AlbumList;
import com.example.wikimusic.viewmodels.album.AlbumListViewModel;

import java.util.List;

public class AlbumFragment extends Fragment implements AlbumListListener{

    private FragmentAlbumBinding fragmentAlbumBinding;
    private AlbumListViewModel albumListViewModel;
    private String genreName;

    public AlbumFragment(String genreName) {
        this.genreName = genreName;
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
        albumListViewModel = ViewModelProviders.of(this).get(AlbumListViewModel.class);
        albumListViewModel.init(genreName);
        albumListViewModel.setAlbumListListener(this);
        albumListViewModel.getAlbumList().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albums) {
                Log.i("Sudhanshu",albums.get(0).getName());
            }
        });

        return fragmentAlbumBinding.getRoot();
    }

    @Override
    public void onAlbumSelected(Album album) {
        Log.i("Sudhanshu","hey");
    }
}