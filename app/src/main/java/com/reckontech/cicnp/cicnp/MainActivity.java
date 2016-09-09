package com.reckontech.cicnp.cicnp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.reckontech.cicnp.cicnp.AddBlacklist.AddBlackListOne;
import com.reckontech.cicnp.cicnp.NavBar.NavFragment;
import com.reckontech.cicnp.cicnp.SearchBlacklist.SearchBlacklistFragment;
import com.reckontech.cicnp.cicnp.Watch.WatchFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    ActionBarDrawerToggle mDrawerToggle;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Show Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawerLayout);

        //Set DrawerToggle Listener
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.DrawerOpen, R.string.DrawerClose){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);


        //Setup viewpager
        mViewPager = (ViewPager) findViewById(R.id.main_viewPager);
        setupViewPager(mViewPager);

        //Setup tabs
        mTabLayout = (TabLayout) findViewById(R.id.main_tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    //Add fragment tabs here
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new WatchFragment(), "Watch");
        adapter.addFragment(new AddBlackListOne(), "Add Blacklist");
        adapter.addFragment(new SearchBlacklistFragment(), "Search Blacklist");
        viewPager.setAdapter(adapter);
    }

    //For Burger animation
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        // Handle your other action bar items...
        switch(item.getItemId())
        {
        }

        return super.onOptionsItemSelected(item);
    }
}
