/*
 *   Copyright (C) 2015 Sitexa Open Source Project
 *   <p>
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *   <p>
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   <p>
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.sitexa.android.community.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sitexa.android.community.R;
import com.sitexa.android.community.internal.di.components.UserComponent;
import com.sitexa.android.community.model.UserModel;
import com.sitexa.android.community.presenter.UserDetailsPresenter;
import com.sitexa.android.community.view.UserDetailsView;
import com.sitexa.android.community.view.component.AutoLoadImageView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment that shows details of a certain user.
 */
public class UserDetailsFragment extends BaseFragment implements UserDetailsView {

    private final static String TAG = UserDetailsFragment.class.getSimpleName();

    @Inject
    UserDetailsPresenter userDetailsPresenter;

    @Bind(R.id.iv_cover)
    AutoLoadImageView iv_cover;
    @Bind(R.id.tv_fullname)
    TextView tv_fullname;
    @Bind(R.id.tv_email)
    TextView tv_email;
    @Bind(R.id.tv_followers)
    TextView tv_followers;
    @Bind(R.id.tv_description)
    TextView tv_description;
    @Bind(R.id.rl_progress)
    RelativeLayout rl_progress;
    @Bind(R.id.rl_retry)
    RelativeLayout rl_retry;
    @Bind(R.id.bt_retry)
    Button bt_retry;

    @Inject
    long userId;

    public UserDetailsFragment() {
        super();
    }

    //////////Fragment//////////
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_user_details, container, false);
        ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.getComponent(UserComponent.class).inject(this);
        this.userDetailsPresenter.setView(this);
        this.userDetailsPresenter.initialize(this.userId);
    }

    @Override
    public void onResume() {
        super.onResume();
        this.userDetailsPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.userDetailsPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.userDetailsPresenter.destroy();
    }

    //////////LoadDataView//////////
    @Override
    public void showLoading() {
        this.rl_progress.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideLoading() {
        this.rl_progress.setVisibility(View.GONE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showRetry() {
        this.rl_retry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.rl_retry.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        this.showToastMessage(message);
    }

    @Override
    public Context getContext() {
        return getActivity().getApplicationContext();
    }

    //////////UserDetailsView//////////
    @Override
    public void renderUser(UserModel user) {
        if (user != null) {
            this.iv_cover.setImageUrl(user.getHeadIcon());
            this.tv_fullname.setText(user.getUsername());
            this.tv_email.setText(user.getMobileNo());
            this.tv_followers.setText(String.valueOf(user.getCommunityID()));
            this.tv_description.setText(user.getCommunityName());
        }
    }

    /////////this///////////
    @OnClick(R.id.bt_retry)
    void onButtonRetryClick() {
        if (this.userDetailsPresenter != null) {
            this.userDetailsPresenter.initialize(this.userId);
        }
    }
}
