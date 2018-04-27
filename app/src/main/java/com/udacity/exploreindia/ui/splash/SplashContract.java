package com.udacity.exploreindia.ui.splash;

import com.udacity.exploreindia.base.BaseMvpPresenter;
import com.udacity.exploreindia.base.BaseView;

/**
 * Created by Kautilya on 24-04-2018.
 */
public interface SplashContract {

    interface Presenter extends BaseMvpPresenter<View>{


        void inintCountDown();

    }

    interface View extends BaseView{

        void moveToNextSScreen();
    }
}

