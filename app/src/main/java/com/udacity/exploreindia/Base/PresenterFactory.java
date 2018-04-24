package com.udacity.exploreindia.Base;

import com.udacity.exploreindia.UI.splash.SplashActivity;
import com.udacity.exploreindia.UI.splash.SplashPresenter;
import com.udacity.exploreindia.injection.InjectionUtils;

/**
 * Created by Kautilya on 24-04-2018.
 */
public class PresenterFactory {

    public static <T extends BaseFragment, S extends BaseMvpPresenter> S getPresenter(T claxx) {


        throw new IllegalStateException("Fragment presenter not supported yet");
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseActivity, S extends BaseMvpPresenter> S getPresenter(T claxx) {
        S presenter = null;
        if (claxx instanceof SplashActivity) {
            presenter = (S) new SplashPresenter(InjectionUtils.getSharedPreference(),InjectionUtils.providesDataRepo(),claxx);
        } else {
            throw new IllegalStateException("Activity presenter not supported yet");
        }
        return presenter;
    }
}
