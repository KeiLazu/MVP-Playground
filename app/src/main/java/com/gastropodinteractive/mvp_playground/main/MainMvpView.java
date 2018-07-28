package com.gastropodinteractive.mvp_playground.main;

import com.gastropodinteractive.mvp_playground.base.MvpView;
import com.gastropodinteractive.mvp_playground.data.services.datamodel.Todolist;

/**
 * Created by Kei Lazu on 7/17/2018
 * check https://github.com/KeiLazu for more
 */
public interface MainMvpView extends MvpView {

    void showInitialFragment();

    void toHomepageDisplay();

    void toLoginDisplay();

    void toTodoDetailDisplay(String todolistJson);

}
