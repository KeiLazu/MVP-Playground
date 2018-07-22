package com.gastropodinteractive.mvp_playground.di.components;

import android.app.Application;
import android.content.Context;

import com.gastropodinteractive.mvp_playground.MvpApp;
import com.gastropodinteractive.mvp_playground.di.ApplicationContext;
import com.gastropodinteractive.mvp_playground.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Kei Lazu on 7/16/2018
 * check https://github.com/KeiLazu for more
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    @ApplicationContext
    Context context();

    Application application();

}
