package com.example.wikimusic.adapters;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.wikimusic.ui.album.albumList.AlbumFragment;
import com.example.wikimusic.ui.album.ArtistFragment;
import com.example.wikimusic.ui.album.TracksFragment;

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
                AlbumFragment albumFragment = new AlbumFragment(genreName);
                Bundle args = new Bundle();
                args.putString("genreName",genreName);
                albumFragment.setArguments(args);
                return albumFragment;

            case 1:
                return new ArtistFragment(genreName);
            case 2:
                return new TracksFragment(genreName);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
