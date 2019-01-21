package com.example.caiputuijian.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements fragment_library.OnFragmentInteractionListener, fragment_recommendation.OnFragmentInteractionListener, fragment_community.OnFragmentInteractionListener, fragment_personality.OnFragmentInteractionListener {

    private Fragment flibrary,frecommendation,fcommunity,fpersonality,fragments[];
    private int lastfragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_recommendation:
                    if(lastfragment!=0){
                        switchfragment(lastfragment, 0);
                        lastfragment = 0;
                    }
                    return true;
                case R.id.navigation_library:
                    if(lastfragment != 1){
                        switchfragment(lastfragment, 1);
                        lastfragment = 1;
                    }
                    return true;
                case R.id.navigation_community:
                    if(lastfragment != 2){
                        switchfragment(lastfragment, 2);
                        lastfragment = 2;
                    }
                    return true;
                case R.id.navigation_person:
                    if(lastfragment != 3){
                        switchfragment(lastfragment, 3);
                        lastfragment = 3;
                    }
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void initfragment(){
        frecommendation = new fragment_recommendation();
        flibrary = new fragment_library();
        fcommunity = new fragment_community();
        fpersonality = new fragment_personality();
        fragments = new Fragment[]{frecommendation,flibrary,fcommunity,fpersonality};
        lastfragment = 0;
        getSupportFragmentManager().beginTransaction().replace(R.id.container, frecommendation)
                                                        .show(frecommendation).commit();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void switchfragment(int lastfragment,  int index){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);
        if(fragments[index].isAdded() == false){
            transaction.add(R.id.container, fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        initfragment();
    }

}
