package com.gastropodinteractive.mvp_playground;

import android.app.Application;

import com.gastropodinteractive.mvp_playground.di.components.ApplicationComponent;
import com.gastropodinteractive.mvp_playground.di.components.DaggerApplicationComponent;
import com.gastropodinteractive.mvp_playground.di.modules.ApplicationModule;

/**
 * Created by Kei Lazu on 7/17/2018
 * check https://github.com/KeiLazu for more
 */
public class MvpApp extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

}
