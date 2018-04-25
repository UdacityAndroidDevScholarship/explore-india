package com.udacity.exploreindia.UI.splash;

import com.udacity.exploreindia.Base.BaseMvpPresenter;
import com.udacity.exploreindia.Base.BaseView;

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

