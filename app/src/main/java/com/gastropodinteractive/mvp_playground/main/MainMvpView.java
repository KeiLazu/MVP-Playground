package com.gastropodinteractive.mvp_playground.main;

import com.gastropodinteractive.mvp_playground.base.MvpView;

/**
 * Created by Kei Lazu on 7/17/2018
 * check https://github.com/KeiLazu for more
 */
public interface MainMvpView extends MvpView {

    void showInitialFragment();

    void toHomepageDisplay();

    void toLoginDisplay();

}
