package com.gastropodinteractive.mvp_playground.main;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.gastropodinteractive.mvp_playground.base.BasePresenter;
import com.gastropodinteractive.mvp_playground.data.IDataManager;
import com.gastropodinteractive.mvp_playground.fragments.homepage.HomepageFragment;
import com.gastropodinteractive.mvp_playground.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Kei Lazu on 7/17/2018
 * check https://github.com/KeiLazu for more
 */
public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    @Inject
    public MainPresenter(IDataManager iDataManager, ISchedulerProvider iSchedulerProvider, CompositeDisposable compositeDisposable) {
        super(iDataManager, iSchedulerProvider, compositeDisposable);
    }
}
