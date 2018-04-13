package com.udacity.exploreindia.ui.main;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class MainViewModel extends ViewModel {

    /**
     * Used to pass dependencies to ViewModel through constructor.
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @SuppressWarnings("unchecked")
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MainViewModel();
        }
    }
}
