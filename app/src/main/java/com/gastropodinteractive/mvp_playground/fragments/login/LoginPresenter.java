package com.gastropodinteractive.mvp_playground.fragments.login;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.gastropodinteractive.mvp_playground.R;
import com.gastropodinteractive.mvp_playground.base.BasePresenter;
import com.gastropodinteractive.mvp_playground.data.IDataManager;
import com.gastropodinteractive.mvp_playground.fragments.homepage.HomepageFragment;
import com.gastropodinteractive.mvp_playground.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Kei Lazu on 7/21/2018
 * check https://github.com/KeiLazu for more
 */
public class LoginPresenter<V extends ILoginMvpView> extends BasePresenter<V> implements ILoginMvpPresenter<V> {

    @Inject
    public LoginPresenter(IDataManager iDataManager, ISchedulerProvider iSchedulerProvider, CompositeDisposable compositeDisposable) {
        super(iDataManager, iSchedulerProvider, compositeDisposable);
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
        getMvpView().toHomepage();
    }
}
