package com.udacity.exploreindia.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.udacity.exploreindia.R;

/**
 * Created by Shivam
 */
public class Utils {

    /**
     * Animation with
     * Exit current Activity- SlideOut to Left
     * Entry new Activity- SlideIn from Right
     * @param context
     */
    public static void finishEntryAnimation(Context context, Intent intent)
    {
        Activity activity=(Activity)context;
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.anim_slide_in_from_right, R.anim.anim_slide_out_to_left);
        activity.finish();
    }
}
