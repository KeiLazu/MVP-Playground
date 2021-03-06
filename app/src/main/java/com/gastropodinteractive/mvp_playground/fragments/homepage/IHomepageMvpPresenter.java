package com.gastropodinteractive.mvp_playground.fragments.homepage;

import com.gastropodinteractive.mvp_playground.base.MvpPresenter;
import com.gastropodinteractive.mvp_playground.data.services.datamodel.Todolist;

/**
 * Created by Kei Lazu on 7/19/2018
 * check https://github.com/KeiLazu for more
 */
public interface IHomepageMvpPresenter<V extends IHomepageMvpView> extends MvpPresenter<V> {

    void onViewPrepared();

    void toTodoDetail(Todolist todolist);

}
