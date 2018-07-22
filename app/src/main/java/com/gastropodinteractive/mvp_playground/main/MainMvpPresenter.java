package com.gastropodinteractive.mvp_playground.main;

import android.support.annotation.IdRes;

import com.gastropodinteractive.mvp_playground.base.MvpPresenter;
import com.gastropodinteractive.mvp_playground.di.PerActivity;

/**
 * Created by Kei Lazu on 7/17/2018
 * check https://github.com/KeiLazu for more
 */
@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

}
