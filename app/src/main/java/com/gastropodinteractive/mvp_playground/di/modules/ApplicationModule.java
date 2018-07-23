package com.gastropodinteractive.mvp_playground.di.modules;

import android.app.Application;
import android.content.Context;

import com.gastropodinteractive.mvp_playground.data.DataManager;
import com.gastropodinteractive.mvp_playground.data.IDataManager;
import com.gastropodinteractive.mvp_playground.data.services.ApiTodolist;
import com.gastropodinteractive.mvp_playground.data.services.IApiTodolist;
import com.gastropodinteractive.mvp_playground.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kei Lazu on 7/16/2018
 * check https://github.com/KeiLazu for more
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    IDataManager provideIDataManager(DataManager dataManager) {
        return dataManager;
    }

    @Provides
    @Singleton
    IApiTodolist provideIApiTodolist (ApiTodolist apiTodolist){
        return apiTodolist;
    }

}
