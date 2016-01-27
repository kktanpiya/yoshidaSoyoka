package com.example.msdhainizam.loginschoolapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Adapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.crashlytics.android.Crashlytics;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class MySchool_main extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        ImageView imageview = (ImageView) findViewById(R.id.imageView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(getDataSet());
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        ScaleInAnimationAdapter scaleAdapter = new ScaleInAnimationAdapter(alphaAdapter);
        scaleAdapter.setFirstOnly(false);
        scaleAdapter.setInterpolator(new OvershootInterpolator());
        mRecyclerView.setAdapter(scaleAdapter);
        //Fabric.with(this, new Crashlytics());


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitleTextColor(0xFFFFFFFF);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        Glide.with(this).load(R.drawable.yui_small2).into(imageview);


    }
    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, "Clicked on Item" + position);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();

        results.add(new DataObject("Sekolah Demang husin", "sekolah tutup", R.drawable.yui4));
        results.add(new DataObject("Sekolah Kampung Baru", "sekolah x mau tutup", R.drawable.yui_small5));
        results.add(new DataObject("Sekolah Tiang Dua", "mari bersekolah", R.drawable.yui_small4));
        results.add(new DataObject("Sekolah Kktanpiya", "sekolah aku Cuti", R.drawable.yui_small2));
        results.add(new DataObject("Sekolah Demang husin", "sekolah tutup", R.drawable.yui4));
        results.add(new DataObject("Sekolah Kampung Baru", "sekolah x mau tutup", R.drawable.yui_small5));
        results.add(new DataObject("Sekolah Tiang Dua", "mari bersekolah", R.drawable.yui_small4));
        results.add(new DataObject("Sekolah Kktanpiya", "sekolah aku Cuti", R.drawable.yui_small2));
        results.add(new DataObject("Sekolah Demang husin", "sekolah tutup", R.drawable.yui4));
        results.add(new DataObject("Sekolah Kampung Baru", "sekolah x mau tutup", R.drawable.yui_small5));
        results.add(new DataObject("Sekolah Tiang Dua", "mari bersekolah", R.drawable.yui_small4));
        results.add(new DataObject("Sekolah Kktanpiya", "sekolah aku Cuti", R.drawable.yui_small2));
        results.add(new DataObject("Sekolah Demang husin", "sekolah tutup", R.drawable.yui4));
        results.add(new DataObject("Sekolah Kampung Baru", "sekolah x mau tutup", R.drawable.yui_small5));
        results.add(new DataObject("Sekolah Tiang Dua", "mari bersekolah", R.drawable.yui_small4));
        results.add(new DataObject("Sekolah Kktanpiya", "sekolah aku Cuti", R.drawable.yui_small2));
        results.add(new DataObject("Sekolah Demang husin", "sekolah tutup", R.drawable.yui4));
        results.add(new DataObject("Sekolah Kampung Baru", "sekolah x mau tutup", R.drawable.yui_small5));
        results.add(new DataObject("Sekolah Tiang Dua", "mari bersekolah", R.drawable.yui_small4));
        results.add(new DataObject("Sekolah Kktanpiya", "sekolah aku Cuti", R.drawable.yui_small2));
        results.add(new DataObject("Sekolah Demang husin", "sekolah tutup", R.drawable.yui4));
        results.add(new DataObject("Sekolah Kampung Baru", "sekolah x mau tutup", R.drawable.yui_small5));
        results.add(new DataObject("Sekolah Tiang Dua", "mari bersekolah", R.drawable.yui_small4));
        results.add(new DataObject("Sekolah Kktanpiya", "sekolah aku Cuti", R.drawable.yui_small2));


        return results;
    }


}