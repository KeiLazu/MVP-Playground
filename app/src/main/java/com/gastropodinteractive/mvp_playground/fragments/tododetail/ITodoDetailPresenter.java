package com.gastropodinteractive.mvp_playground.fragments.tododetail;

import com.gastropodinteractive.mvp_playground.base.BasePresenter;
import com.gastropodinteractive.mvp_playground.base.MvpPresenter;

/**
 * Created by Kei Lazu on 7/28/2018
 * check https://github.com/KeiLazu for more
 */
public interface ITodoDetailPresenter<V extends ITodoDetailView> extends MvpPresenter<V> {

    void onViewPrepared();

}
