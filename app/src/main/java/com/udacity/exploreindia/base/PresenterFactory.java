package com.udacity.exploreindia.base;

import com.udacity.exploreindia.injection.InjectionUtils;
import com.udacity.exploreindia.ui.home.HomeActivity;
import com.udacity.exploreindia.ui.home.HomePresenter;
import com.udacity.exploreindia.ui.home.fragments.main.MainFragment;
import com.udacity.exploreindia.ui.home.fragments.main.MainPresenter;
import com.udacity.exploreindia.ui.home.fragments.place.PlaceFragment;
import com.udacity.exploreindia.ui.home.fragments.place.PlacePresenter;
import com.udacity.exploreindia.ui.home.fragments.profile.UserDetailFragment;
import com.udacity.exploreindia.ui.home.fragments.profile.UserDetailPresenter;
import com.udacity.exploreindia.ui.login.LoginActivity;
import com.udacity.exploreindia.ui.login.LoginPresenter;
import com.udacity.exploreindia.ui.splash.SplashActivity;
import com.udacity.exploreindia.ui.splash.SplashPresenter;

/**
 * Created by Kautilya on 24-04-2018.
 */
public class PresenterFactory {

    public static <T extends BaseFragment, S extends BaseMvpPresenter> S getPresenter(T claxx) {
        S presenter = null;
        if (claxx instanceof MainFragment) {
            presenter = (S) new MainPresenter(InjectionUtils.getSharedPreference(), InjectionUtils.providesDataRepo(), claxx.getContext());
        } else if (claxx instanceof PlaceFragment) {
            presenter = (S) new PlacePresenter(InjectionUtils.getSharedPreference(), InjectionUtils.providesDataRepo(), claxx.getContext());
        } else if (claxx instanceof UserDetailFragment) {
            presenter = (S) new UserDetailPresenter(InjectionUtils.getSharedPreference(), InjectionUtils.providesDataRepo(), claxx.getContext());
        } else {
            throw new IllegalStateException("Activity presenter not supported yet");
        }
        throw new IllegalStateException("Fragment presenter not supported yet");
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseActivity, S extends BaseMvpPresenter> S getPresenter(T claxx) {
        S presenter = null;
        if (claxx instanceof SplashActivity) {
            presenter = (S) new SplashPresenter(InjectionUtils.getSharedPreference(), InjectionUtils.providesDataRepo(), claxx);
        } else if (claxx instanceof LoginActivity) {
            presenter = (S) new LoginPresenter(InjectionUtils.getSharedPreference(), InjectionUtils.providesDataRepo(), claxx);
        } else if (claxx instanceof HomeActivity) {
            presenter = (S) new HomePresenter(InjectionUtils.getSharedPreference(), InjectionUtils.providesDataRepo(), claxx);
        } else {
            throw new IllegalStateException("Activity presenter not supported yet");
        }

        return presenter;
    }
}
