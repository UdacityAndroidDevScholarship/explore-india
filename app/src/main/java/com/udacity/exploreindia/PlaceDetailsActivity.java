package com.udacity.exploreindia;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * Created by kamalshree on 4/29/2018.
 */

public class PlaceDetailsActivity extends AppCompatActivity {

    ViewPager viewPagerImages, viewPagerText;
    ViewPagerImageAdapter viewPagerImageAdapter;
    ViewPagerTextAdapter viewPagerTextAdapter;
    LinearLayout linearLayoutImages, linearLayoutText;
    private int dotcountImages, dotcountText;
    private ImageView[] dotsImages, dotsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        /* Toolbar */
        Toolbar mytoolbar = findViewById(R.id.app_bar);
        setSupportActionBar(mytoolbar);
        setTitle("  " + getResources().getString(R.string.app_tb_title).toString());
        getSupportActionBar().setIcon(R.drawable.ic_menu);

        /* Start of ViewPager implementation for the siding Images */
        linearLayoutImages = findViewById(R.id.slidrDots);
        viewPagerImages = findViewById(R.id.places_details_vp_images);
        viewPagerImageAdapter = new ViewPagerImageAdapter(this);
        viewPagerImages.setAdapter(viewPagerImageAdapter);


        dotcountImages = viewPagerImageAdapter.getCount();
        dotsImages = new ImageView[dotcountImages];


        for (int i = 0; i < dotcountImages; i++) {
            dotsImages[i] = new ImageView(this);
            dotsImages[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);
            linearLayoutImages.addView(dotsImages[i], params);

        }
        dotsImages[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        viewPagerImages.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotcountImages; i++) {
                    dotsImages[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dotsImages[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        /* End sliding Image */

       /* Start of ViewPager implementation for the siding Text */
        linearLayoutText = findViewById(R.id.slidrDotsText);
        viewPagerText = findViewById(R.id.places_details_vp_text);
        viewPagerTextAdapter = new ViewPagerTextAdapter(this);
        viewPagerText.setAdapter(viewPagerTextAdapter);

        dotcountText = viewPagerTextAdapter.getCount();
        dotsText = new ImageView[dotcountText];

        for (int i = 0; i < dotcountText; i++) {
            dotsText[i] = new ImageView(this);
            dotsText[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);

            linearLayoutText.addView(dotsText[i], params);

        }
        dotsText[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        viewPagerText.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotcountText; i++) {
                    dotsText[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dotsText[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        /* End sliding Text */

    }

    /* Start of Menu item Implementation */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /* End of Menu item Implementation */
}