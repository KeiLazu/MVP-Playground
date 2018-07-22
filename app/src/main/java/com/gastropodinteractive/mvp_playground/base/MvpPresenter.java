package com.gastropodinteractive.mvp_playground.base;

/**
 * Created by Kei Lazu on 7/16/2018
 * check https://github.com/KeiLazu for more
 */
public interface MvpPresenter<V extends MvpView> {

    void onAttach(V MvpView);

    void onDetach();

}
