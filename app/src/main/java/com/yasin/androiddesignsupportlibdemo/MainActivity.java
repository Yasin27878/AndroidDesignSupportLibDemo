package com.yasin.androiddesignsupportlibdemo;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private NavigationView mNview;
    private Toolbar mToolbar;
    private TabLayout mTab;
    private ViewPager mViewPager;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        mNview = (NavigationView) findViewById(R.id.nv_view);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTab = (TabLayout) findViewById(R.id.tab);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(v -> {
            Snackbar.make(v,"Snackbar!",Snackbar.LENGTH_LONG).show();
        });

        setSupportActionBar(mToolbar);
        mToolbar.setTitle("title");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_list_white);
        }
        setViewPager();

        mNview.setNavigationItemSelectedListener(item -> {
            item.setChecked(true);
            mDrawer.closeDrawers();
            return false;
        });
    }

    private void setViewPager() {
        List<BaseFragment> fragmentList = new ArrayList<>(4);
        ListContentFragment listContentFragment = (ListContentFragment) ListContentFragment.newInstance("LIST", R.layout.recycler_view);
        fragmentList.add(listContentFragment);
        GradContentFragment gradContentFragment = (GradContentFragment) GradContentFragment.newInstance("GRAD", R.layout.recycler_view);
        fragmentList.add(gradContentFragment);
        CardContentFragment cardContentFragment = (CardContentFragment) CardContentFragment.newInstance("CARD", R.layout.recycler_view);
        fragmentList.add(cardContentFragment);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(adapter);
        mTab.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                break;
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
