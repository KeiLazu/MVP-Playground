package com.gastropodinteractive.mvp_playground.fragments.login;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

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

    @Override
    public void Validator(String email, String password) {
        if (TextUtils.isEmpty(email)) {
            getMvpView().showMessage("Email is empty");
        } else if (TextUtils.isEmpty(password)) {
            getMvpView().showMessage("Password is empty");
        } else {
            LoginStart(email, password);
        }
    }

    @Override
    public void LoginStart(String email, String password) {
        getMvpView().showMessage("Welcome " + email);
    }
}
