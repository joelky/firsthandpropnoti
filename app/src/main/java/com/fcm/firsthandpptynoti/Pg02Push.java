package com.fcm.firsthandpptynoti;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/*
onCreate
    setContentView
    ViewPager (extend ViewGroup) - Layout manager that allows the user to flip left and right through pages of data.
                                   You supply an implementation of a PagerAdapter to generate the pages that the view shows.
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
    Class MyViewPagerAdapter extends FragmentPagerAdapter
        new MyViewPagerAdapter
            add fragment (my pages)
            mViewPager.setAdapter(mViewPagerAdapter);
    TabLayout (extends HorizontalScrollView)
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

    tablayout < viewpager < viewpager adapter
*/
public class Pg02Push extends BaseActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected String setTitleOnToolbar() {
        return "推播通知";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg02_push);

        /*
        Tab
        */
        //ViewPager - Layout manager that allows the user to flip left and right through pages of data.
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        //MyViewPagerAdapter
        setupViewPager(mViewPager);
        //...
        //..
        //.

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        //Assigns the ViewPager to TabLayout
        //The one-stop shop for setting up this TabLayout with a ViewPager.
        mTabLayout.setupWithViewPager(mViewPager);

    } // End of onCreate

    /*
    Tab
    */
    private void setupViewPager(ViewPager viewPager) {
        MyViewPagerAdapter mViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        mViewPagerAdapter.addFragment(new Pg02Tab01MyPush(), "我的通知");     // Pg02Tab01MyPush - tab content page. 我的通知 - Tab name
        mViewPagerAdapter.addFragment(new Pg02Tab02AllPush(), "全部通知");
        mViewPagerAdapter.addFragment(new Pg02Tab03CriticalPush(), "重大通知");
        mViewPagerAdapter.addFragment(new Pg02Tab04MySubs(), "我的訂閱");
        mViewPagerAdapter.addFragment(new Pg02Tab05NotiSetting(), "設定通知");
        viewPager.setAdapter(mViewPagerAdapter);
    }

    /*
    FragementPagerAdapter (extend PagerAdapter)
    Implementation of PagerAdapter that represents each page as a Fragment that is persistently kept in the fragment manager as long as the user can return to the page.
    fragment of each page the user visits will be kept in memory, though its view hierarchy may be destroyed when not visible.
    This can result in using a significant amount of memory since fragment instances can hold on to an arbitrary amount of state.
    For larger sets of pages, consider FragmentStatePagerAdapter.
    */
    class MyViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public MyViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        // abstract class implementation- FragmentPagerAdapter
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        // abstract class implementation- FragmentPagerAdapter
        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);

        }

    }

}

