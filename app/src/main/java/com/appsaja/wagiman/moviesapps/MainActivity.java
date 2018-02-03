package com.appsaja.wagiman.moviesapps;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.appsaja.wagiman.moviesapps.fragment.NowPlayingFragment;
import com.appsaja.wagiman.moviesapps.fragment.TopMoviesFragment;
import com.appsaja.wagiman.moviesapps.fragment.TvSeriesFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menuNowPlaying :
                        getSupportActionBar().setTitle("Now Playing");
                        fragment = new NowPlayingFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.menuTopMovies :
                        getSupportActionBar().setTitle("Top Movies");
                        fragment = new TopMoviesFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.menuTvSeries :
                        getSupportActionBar().setTitle("TV Series");
                        fragment = new TvSeriesFragment();
                        loadFragment(fragment);
                        return true;
                }

                return false;
            }
        });

        if (savedInstanceState == null){
            getSupportActionBar().setTitle("Now Playing");
            fragment = new NowPlayingFragment();
            loadFragment(fragment);
        }

    }

    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit();
    }

}
