package com.example.newsmaterialdesginudemy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);

        //link tablayout to view pager
        tabLayout.setupWithViewPager(viewPager);

        //initializing fragments
        CovidNewsFragment covidNewsFragment = new CovidNewsFragment();
        BusinessNewsFragment businessNewsFragment = new BusinessNewsFragment();
        EntertainmentNewsFragment entertainmentNewsFragment = new EntertainmentNewsFragment();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);


        //adding the fragments
        viewPagerAdapter.addFragment(covidNewsFragment, "Covid-19");
        viewPagerAdapter.addFragment(businessNewsFragment, "Business");
        viewPagerAdapter.addFragment(entertainmentNewsFragment, "Entertainment");
        viewPager.setAdapter(viewPagerAdapter);
    }


}

//class to view pages
class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> fragmentTitles = new ArrayList<>();

    //Constructor
    public ViewPagerAdapter(FragmentManager fm, int behaviour) {
        super(fm, behaviour);
    }

    //creates fragment to be added on the viewPager
    void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitles.add(title);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitles.get(position);
    }
}