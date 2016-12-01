package com.barranquero.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.barranquero.tablayout.adapter.AdapterViewPager;

public class TabLayout_Activity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewPager;
    private AdapterViewPager adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // TabLayout must be initialised and tabs must be created
        tablayout = (TabLayout)findViewById(R.id.tablayout);
        //tablayout.addTab(tablayout.newTab().setText("Tab1"));

        for (String title : getResources().getStringArray(R.array.tabs)) {
            //tablayout.addTab(tablayout.newTab().setText(title));
            tablayout.addTab(tablayout.newTab());
        }

        viewPager = (ViewPager)findViewById(R.id.pager);
        adapter = new AdapterViewPager(getSupportFragmentManager(), tablayout.getTabCount(), this);
        viewPager.setPageTransformer(true, new RotateUpTransformer());
        viewPager.setAdapter(adapter);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tablayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tablayout.setupWithViewPager(viewPager);
        setIcons();

        /*viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //tablayout.getTabAt(position).select();
                tablayout.setScrollPosition(position, 0f, true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/

        /*tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        });*/
    }

    private void setIcons() {
        for (int i = 0; i < tablayout.getTabCount(); i++) {
            tablayout.getTabAt(i).setIcon(android.R.drawable.ic_delete);
        }
    }
}
