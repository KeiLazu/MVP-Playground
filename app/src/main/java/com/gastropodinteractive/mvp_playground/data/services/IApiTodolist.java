package com.gastropodinteractive.mvp_playground.data.services;

import com.gastropodinteractive.mvp_playground.data.services.model.GetTodolist;

import io.reactivex.Single;

/**
 * Created by Kei Lazu on 7/23/2018
 * check https://github.com/KeiLazu for more
 */
public interface IApiTodolist {

    Single<GetTodolist> getTodolist();

}
