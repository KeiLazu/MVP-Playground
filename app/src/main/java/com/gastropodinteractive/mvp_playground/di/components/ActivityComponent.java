package com.gastropodinteractive.mvp_playground.di.components;

import com.gastropodinteractive.mvp_playground.di.PerActivity;
import com.gastropodinteractive.mvp_playground.di.modules.ActivityModule;
import com.gastropodinteractive.mvp_playground.fragments.homepage.HomepageFragment;
import com.gastropodinteractive.mvp_playground.fragments.login.LoginFragment;
import com.gastropodinteractive.mvp_playground.fragments.tododetail.TodoDetailFragment;
import com.gastropodinteractive.mvp_playground.main.MainActivity;

import dagger.Component;

/**
 * Created by Kei Lazu on 7/16/2018
 * check https://github.com/KeiLazu for more
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(HomepageFragment fragment);

    void inject(LoginFragment fragment);

    void inject(TodoDetailFragment fragment);

}
