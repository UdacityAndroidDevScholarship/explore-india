package com.udacity.exploreindia;

import android.app.Activity;
import android.content.Context;

public class Utils {

    public static void finishEntryAnimation(Context context)
    {
        Activity activity=(Activity)context;
        activity.overridePendingTransition(R.anim.slide_in_from_right,R.anim.slide_out_to_left);
        activity.finish();
    }
}
