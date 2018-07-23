package com.gastropodinteractive.mvp_playground.data;

import android.content.Context;

import com.gastropodinteractive.mvp_playground.data.services.ApiTodolist;
import com.gastropodinteractive.mvp_playground.data.services.model.GetTodolist;
import com.gastropodinteractive.mvp_playground.di.ApplicationContext;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Kei Lazu on 7/24/2018
 * check https://github.com/KeiLazu for more
 */
public class DataManager implements IDataManager {

    private final Context mContext;
    private final ApiTodolist mApiTodolist;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       ApiTodolist apiTodolist) {
        mContext = context;
        mApiTodolist = apiTodolist;

    }

    @Override
    public Single<GetTodolist> getTodolist() {
        return mApiTodolist.getTodolist();
    }
}
