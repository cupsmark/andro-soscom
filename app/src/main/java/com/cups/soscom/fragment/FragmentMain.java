package com.cups.soscom.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cups.soscom.BaseActivity;
import com.cups.soscom.BaseFragment;
import com.cups.soscom.R;
import com.cups.soscom.helper.HelperGlobal;
import com.cups.soscom.ui.UISemiCircle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ekobudiarto on 6/6/17.
 */

public class FragmentMain extends BaseFragment {

    View mainView;
    HelperGlobal.InterfaceFragment interfaceFragment;
    BaseActivity activity;
    final String TAG_FRAGMENT_MAIN = "tag:fragment_main";

    TabLayout tabLayout;
    ViewPager viewPager;
    MainPagerAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(mainView == null)
        {
            mainView = inflater.inflate(R.layout.fragment_main, container, false);
        }
        onInit();
        return mainView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context != null)
        {
            this.activity = (BaseActivity) context;
            interfaceFragment = (HelperGlobal.InterfaceFragment) this.activity;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity != null)
        {
            this.activity = (BaseActivity) activity;
            interfaceFragment = (HelperGlobal.InterfaceFragment) this.activity;
        }
    }

    @Override
    public void onInit() {
        super.onInit();
        setTAG(TAG_FRAGMENT_MAIN);


    }

    @Override
    public void onStart() {
        super.onStart();
        onInitComponent();
        onLoadData();
    }

    @Override
    public void onInitComponent() {
        super.onInitComponent();
        tabLayout = (TabLayout) mainView.findViewById(R.id.frg_main_tablayout);
        viewPager = (ViewPager) mainView.findViewById(R.id.frg_main_viewpager);
        setupViewPager();
        tabLayout.setupWithViewPager(viewPager);
        setupTabs();
    }

    @Override
    public void onLoadData() {
        super.onLoadData();

    }

    private void setupTabs()
    {
        final UISemiCircle circle = new UISemiCircle(HelperGlobal.getColor(activity, R.color.base_yellow), UISemiCircle.Direction.TOP);
        final View tabHome = LayoutInflater.from(activity).inflate(R.layout.view_frg_main_tab_home, null, false);
        final View bgHomeSelected = (View) tabHome.findViewById(R.id.view_frg_main_tab_icon_home_selected);
        final ImageView iconHome = (ImageView) tabHome.findViewById(R.id.view_frg_main_tab_icon_home);
        final Bitmap iconHomeDefault = ((BitmapDrawable) iconHome.getDrawable()).getBitmap();
        final Bitmap iconHomeColored = HelperGlobal.setBitmapColor(HelperGlobal.getColor(activity, R.color.base_grey), iconHomeDefault);
        tabLayout.getTabAt(0).setCustomView(tabHome);

        final View tabLove = LayoutInflater.from(activity).inflate(R.layout.view_frg_main_tab_love, null, false);
        final View bgLoveSelected = (View) tabLove.findViewById(R.id.view_frg_main_tab_icon_love_selected);
        final ImageView iconLove = (ImageView) tabLove.findViewById(R.id.view_frg_main_tab_icon_love);
        final Bitmap iconLoveDefault = ((BitmapDrawable) iconLove.getDrawable()).getBitmap();
        final Bitmap iconLoveColored = HelperGlobal.setBitmapColor(HelperGlobal.getColor(activity, R.color.base_grey), iconLoveDefault);
        tabLayout.getTabAt(1).setCustomView(tabLove);

        final View tabGrid = LayoutInflater.from(activity).inflate(R.layout.view_frg_main_tab_grid, null, false);
        final View bgGridSelected = (View) tabGrid.findViewById(R.id.view_frg_main_tab_icon_grid_selected);
        final ImageView iconGrid = (ImageView) tabGrid.findViewById(R.id.view_frg_main_tab_icon_grid);
        final Bitmap iconGridDefault = ((BitmapDrawable) iconGrid.getDrawable()).getBitmap();
        final Bitmap iconGridColored = HelperGlobal.setBitmapColor(HelperGlobal.getColor(activity, R.color.base_grey), iconGridDefault);
        tabLayout.getTabAt(2).setCustomView(tabGrid);

        final View tabNotification = LayoutInflater.from(activity).inflate(R.layout.view_frg_main_tab_notification, null, false);
        final View bgNotifSelected = (View) tabNotification.findViewById(R.id.view_frg_main_tab_icon_notification_selected);
        final ImageView iconNotif = (ImageView) tabNotification.findViewById(R.id.view_frg_main_tab_icon_notification);
        final Bitmap iconNotifDefault = ((BitmapDrawable) iconNotif.getDrawable()).getBitmap();
        final Bitmap iconNotifColored = HelperGlobal.setBitmapColor(HelperGlobal.getColor(activity, R.color.base_grey), iconNotifDefault);
        tabLayout.getTabAt(3).setCustomView(tabNotification);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0)
                {
                    bgHomeSelected.setBackground(circle);
                    bgLoveSelected.setBackground(new ColorDrawable(Color.TRANSPARENT));
                    bgGridSelected.setBackground(new ColorDrawable(Color.TRANSPARENT));
                    bgNotifSelected.setBackground(new ColorDrawable(Color.TRANSPARENT));
                    iconHome.setImageBitmap(iconHomeColored);
                    iconLove.setImageBitmap(iconLoveDefault);
                    iconGrid.setImageBitmap(iconGridDefault);
                    iconNotif.setImageBitmap(iconNotifDefault);
                }
                else if(tab.getPosition() == 1)
                {
                    bgHomeSelected.setBackground(new ColorDrawable(Color.TRANSPARENT));
                    bgLoveSelected.setBackground(circle);
                    bgGridSelected.setBackground(new ColorDrawable(Color.TRANSPARENT));
                    bgNotifSelected.setBackground(new ColorDrawable(Color.TRANSPARENT));
                    iconHome.setImageBitmap(iconHomeDefault);
                    iconLove.setImageBitmap(iconLoveColored);
                    iconGrid.setImageBitmap(iconGridDefault);
                    iconNotif.setImageBitmap(iconNotifDefault);
                }
                else if(tab.getPosition() == 2)
                {
                    bgHomeSelected.setBackground(new ColorDrawable(Color.TRANSPARENT));
                    bgLoveSelected.setBackground(new ColorDrawable(Color.TRANSPARENT));
                    bgGridSelected.setBackground(circle);
                    bgNotifSelected.setBackground(new ColorDrawable(Color.TRANSPARENT));
                    iconHome.setImageBitmap(iconHomeDefault);
                    iconLove.setImageBitmap(iconLoveDefault);
                    iconGrid.setImageBitmap(iconGridColored);
                    iconNotif.setImageBitmap(iconNotifDefault);
                }
                else
                {
                    bgHomeSelected.setBackground(new ColorDrawable(Color.TRANSPARENT));
                    bgLoveSelected.setBackground(new ColorDrawable(Color.TRANSPARENT));
                    bgGridSelected.setBackground(new ColorDrawable(Color.TRANSPARENT));
                    bgNotifSelected.setBackground(circle);
                    iconHome.setImageBitmap(iconHomeDefault);
                    iconLove.setImageBitmap(iconLoveDefault);
                    iconGrid.setImageBitmap(iconGridDefault);
                    iconNotif.setImageBitmap(iconNotifColored);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager()
    {
        adapter = new MainPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new FragmentHome(), "HOME");
        adapter.addFragment(new FragmentLove(), "LOVE");
        adapter.addFragment(new FragmentGrid(), "GRID");
        adapter.addFragment(new FragmentNotification(), "NOTIFICATION");
        viewPager.setAdapter(adapter);
    }

    @Override
    public String getTAG() {
        return TAG_FRAGMENT_MAIN;
    }

    class MainPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mListFragment = new ArrayList<>();
        private final List<String> mListFragmentTitle = new ArrayList<>();

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mListFragment.get(position);
        }

        @Override
        public int getCount() {
            return mListFragment.size();
        }

        public void addFragment(Fragment fragment, String title)
        {
            mListFragment.add(fragment);
            mListFragmentTitle.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mListFragmentTitle.get(position);
        }
    }
}
