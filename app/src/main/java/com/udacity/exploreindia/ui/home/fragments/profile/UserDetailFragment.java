package com.udacity.exploreindia.ui.home.fragments.profile;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseFragment;
import com.udacity.exploreindia.databinding.FragmentUserDetailBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserDetailFragment extends BaseFragment<UserDetailContract.Presenter,FragmentUserDetailBinding> implements UserDetailContract.View {


    public UserDetailFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getContentResource() {
        return R.layout.fragment_user_detail;
    }

    @Override
    protected void init(View view, @Nullable Bundle savedInstanceState) {

    }


}
