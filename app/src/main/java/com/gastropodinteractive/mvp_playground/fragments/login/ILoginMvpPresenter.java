package com.gastropodinteractive.mvp_playground.fragments.login;

import com.gastropodinteractive.mvp_playground.base.BasePresenter;
import com.gastropodinteractive.mvp_playground.base.MvpPresenter;

/**
 * Created by Kei Lazu on 7/21/2018
 * check https://github.com/KeiLazu for more
 */
public interface ILoginMvpPresenter<V extends ILoginMvpView> extends MvpPresenter<V> {

    void onViewPrepared();

}
