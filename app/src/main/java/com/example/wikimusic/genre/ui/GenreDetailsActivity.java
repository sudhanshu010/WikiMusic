package com.example.wikimusic.genre.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.wikimusic.R;
import com.example.wikimusic.genre.adapters.ViewPagerAdapter;
import com.example.wikimusic.databinding.ActivityGenreDetailsBinding;
import com.example.wikimusic.genre.models.Genre;
import com.example.wikimusic.genre.viewmodels.GenreDetailsViewModel;
import com.google.android.material.tabs.TabLayout;

public class GenreDetailsActivity extends AppCompatActivity {

    private ActivityGenreDetailsBinding activityGenreDetailsBinding;
    private GenreDetailsViewModel genreDetailsViewModel;
    private String genreName;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        activityGenreDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_genre_details);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        genreName = getIntent().getStringExtra("genreName");

        tabLayoutInit();
        viewPagerInit();

        genreDetailsViewModel = ViewModelProviders.of(this).get(GenreDetailsViewModel.class);
        genreDetailsViewModel.init(genreName);
        genreDetailsViewModel.getGenre().observe(this, new Observer<Genre>() {
            @Override
            public void onChanged(Genre genre) {
                activityGenreDetailsBinding.setDescription(genre.getDescriptionWrapper().getGenreDesrciption());
            }
        });
    }

    private void tabLayoutInit(){

        tabLayout.addTab(tabLayout.newTab().setText("Albums"));
        tabLayout.addTab(tabLayout.newTab().setText("Artists"));
        tabLayout.addTab(tabLayout.newTab().setText("Tracks"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void viewPagerInit(){

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount(),genreName);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}