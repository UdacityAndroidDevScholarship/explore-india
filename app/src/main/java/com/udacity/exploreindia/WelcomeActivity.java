package com.udacity.exploreindia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.app.NavigationPolicy;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
import com.udacity.exploreindia.helper.PrefManager;


public class WelcomeActivity extends IntroActivity {


    PrefManager prefManager;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefManager = new PrefManager(context);
        setButtonBackVisible(false);
        setButtonNextVisible(false);


        setNavigationPolicy(new NavigationPolicy() {
            @Override
            public boolean canGoForward(int position) {
                return position != 6;
            }

            @Override
            public boolean canGoBackward(int position) {
                return position != 0;
            }
        });

        addSlide(new SimpleSlide.Builder()
                .title("title 1")
                .description("description 1")
                .image(R.drawable.comingsoon)
                .background(R.color.color_canteen)
                .backgroundDark(R.color.color_dark_canteen)
                .build());
        addSlide(new SimpleSlide.Builder()
                .description("description 1")
                .image(R.drawable.comingsoon)
                .background(R.color.color_custom_fragment_2)
                .backgroundDark(R.color.color_dark_custom_fragment_2)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title("title 3")
                .description("description 3")
                .image(R.drawable.comingsoon)
                .background(R.color.color_material_bold)
                .backgroundDark(R.color.color_dark_material_bold)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title("title 4")
                .description("description 4")
                .image(R.drawable.comingsoon)
                .background(R.color.color_custom_fragment_1)
                .backgroundDark(R.color.color_dark_custom_fragment_1)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title("title 5")
                .description("description 5")
                .image(R.drawable.comingsoon)
                .background(R.color.color_material_motion)
                .backgroundDark(R.color.color_dark_material_motion)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title("title 6")
                .description("description 6")
                .image(R.drawable.comingsoon)
                .background(R.color.color_custom_fragment_1)
                .backgroundDark(R.color.color_dark_custom_fragment_1)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title("title 7")
                .description("description 7")
                .image(R.drawable.comingsoon)
                .background(R.color.color_permissions)
                .backgroundDark(R.color.color_dark_permissions)
                .buttonCtaLabel("Get Started")
                .buttonCtaClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        prefManager.setFirstTimeLaunch(true);
                        startActivity(new Intent(getApplicationContext(), SplashActivity.class));
                        finish();
                    }
                })
                .build());


    }
}
