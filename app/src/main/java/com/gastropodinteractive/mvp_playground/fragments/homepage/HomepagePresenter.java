package com.gastropodinteractive.mvp_playground.fragments.homepage;

import com.gastropodinteractive.mvp_playground.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Kei Lazu on 7/19/2018
 * check https://github.com/KeiLazu for more
 */
public class HomepagePresenter<V extends IHomepageMvpView> extends BasePresenter<V> implements IHomepageMvpPresenter<V> {

    @Inject
    public HomepagePresenter() {
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showMessage("HAI HOMEPAGE");
    }
}
