package com.gastropodinteractive.mvp_playground.base;

import com.google.gson.Gson;

/**
 * Created by Kei Lazu on 7/16/2018
 * check https://github.com/KeiLazu for more
 */
public interface MvpPresenter<V extends MvpView> {

    Gson getGson();

    void onAttach(V MvpView);

    void onDetach();

}
