package com.gastropodinteractive.mvp_playground.fragments.login;

import android.content.Context;

import com.gastropodinteractive.mvp_playground.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Kei Lazu on 7/21/2018
 * check https://github.com/KeiLazu for more
 */
public class LoginPresenter<V extends ILoginMvpView> extends BasePresenter<V> implements ILoginMvpPresenter<V> {

    @Inject
    public LoginPresenter() {
    }

    @Override
    public void onViewPrepared() {

    }
}
