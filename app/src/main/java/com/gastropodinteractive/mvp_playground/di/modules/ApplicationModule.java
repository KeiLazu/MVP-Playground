package com.gastropodinteractive.mvp_playground.di.modules;

import android.app.Application;
import android.content.Context;

import com.gastropodinteractive.mvp_playground.di.ApplicationContext;

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

}
