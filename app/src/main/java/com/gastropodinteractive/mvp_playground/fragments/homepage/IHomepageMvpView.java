package com.gastropodinteractive.mvp_playground.fragments.homepage;

import com.gastropodinteractive.mvp_playground.base.MvpView;
import com.gastropodinteractive.mvp_playground.data.services.datamodel.Todolist;
import com.gastropodinteractive.mvp_playground.data.services.model.GetTodolist;

import java.util.List;

/**
 * Created by Kei Lazu on 7/19/2018
 * check https://github.com/KeiLazu for more
 */
public interface IHomepageMvpView extends MvpView {

    void updateTodo(List<Todolist> todolist);

}
