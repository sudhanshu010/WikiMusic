package com.example.wikimusic.genre.adapters;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.wikimusic.album.ui.AlbumListFragment;
import com.example.wikimusic.artist.ui.ArtistListFragment;
import com.example.wikimusic.track.ui.TrackListFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private int totalTabs;
    private String genreName;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public ViewPagerAdapter(Context context, FragmentManager fragmentManager, int totalTabs, String genreName){
        super(fragmentManager);
        this.context = context;
        this.totalTabs = totalTabs;
        this.genreName = genreName;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                AlbumListFragment albumListFragment = new AlbumListFragment(genreName);
                Bundle args = new Bundle();
                args.putString("genreName",genreName);
                albumListFragment.setArguments(args);
                return albumListFragment;

            case 1:
                ArtistListFragment artistListFragment = new ArtistListFragment(genreName);
                args = new Bundle();
                args.putString("genreName",genreName);
                artistListFragment.setArguments(args);
                return artistListFragment;

            case 2:
                TrackListFragment trackListFragment = new TrackListFragment(genreName);
                args = new Bundle();
                args.putString("genreName",genreName);
                trackListFragment.setArguments(args);
                return trackListFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
