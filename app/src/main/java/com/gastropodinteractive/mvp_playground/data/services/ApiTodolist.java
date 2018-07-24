package com.gastropodinteractive.mvp_playground.data.services;

import com.gastropodinteractive.mvp_playground.data.services.model.GetTodolist;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by Kei Lazu on 7/23/2018
 * check https://github.com/KeiLazu for more
 */

@Singleton
public class ApiTodolist implements IApiTodolist {

    @Inject
    public ApiTodolist() {
    }

    @Override
    public Single<GetTodolist> getTodolist() {
        return Rx2AndroidNetworking.get(EndPoint.GET_TODOLIST)
                .build()
                .getObjectSingle(GetTodolist.class);
    }
}
