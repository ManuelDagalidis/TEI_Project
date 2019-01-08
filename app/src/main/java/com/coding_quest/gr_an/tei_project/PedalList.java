package com.coding_quest.gr_an.tei_project;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class PedalList extends AppCompatActivity {

    private EffectPageAdapter mEffectPageAdapter;

    private ViewPager mViewPager;

    private String instrument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedal_list);

        instrument = getIntent().getStringExtra("instrument");

        Bundle bundle = new Bundle();
        bundle.putString("instrument", instrument);
        Tab1Fragment fragobj = new Tab1Fragment();
        fragobj.setArguments(bundle);

        mEffectPageAdapter = new EffectPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        EffectPageAdapter adapter = new EffectPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new Tab1Fragment(), "MODULATION");
        adapter.addFragment(new Tab2Fragment(), "DISTORTION");
        adapter.addFragment(new Tab3Fragment(), "PITCH SHIFTERS");
        adapter.addFragment(new Tab4Fragment(), "MISC");

        viewPager.setAdapter(adapter);
    }
}
