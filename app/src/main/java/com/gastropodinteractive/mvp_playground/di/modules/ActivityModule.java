package com.gastropodinteractive.mvp_playground.di.modules;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.gastropodinteractive.mvp_playground.adapters.TodoAdapter;
import com.gastropodinteractive.mvp_playground.data.services.datamodel.Todolist;
import com.gastropodinteractive.mvp_playground.data.services.model.GetTodolist;
import com.gastropodinteractive.mvp_playground.di.ActivityContext;
import com.gastropodinteractive.mvp_playground.di.PerActivity;
import com.gastropodinteractive.mvp_playground.fragments.homepage.HomepagePresenter;
import com.gastropodinteractive.mvp_playground.fragments.homepage.IHomepageMvpPresenter;
import com.gastropodinteractive.mvp_playground.fragments.homepage.IHomepageMvpView;
import com.gastropodinteractive.mvp_playground.fragments.login.ILoginMvpPresenter;
import com.gastropodinteractive.mvp_playground.fragments.login.ILoginMvpView;
import com.gastropodinteractive.mvp_playground.fragments.login.LoginPresenter;
import com.gastropodinteractive.mvp_playground.main.MainMvpPresenter;
import com.gastropodinteractive.mvp_playground.main.MainMvpView;
import com.gastropodinteractive.mvp_playground.main.MainPresenter;
import com.gastropodinteractive.mvp_playground.utils.rx.ISchedulerProvider;
import com.gastropodinteractive.mvp_playground.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Kei Lazu on 7/16/2018
 * check https://github.com/KeiLazu for more
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    ISchedulerProvider provideSchedulerProvider() {
        return new SchedulerProvider();
    }

    // ------------------- Presenter

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    IHomepageMvpPresenter<IHomepageMvpView> provideHomepageMvpPresenter(HomepagePresenter<IHomepageMvpView> presenter) {
        return presenter;
    }

    @Provides
    ILoginMvpPresenter<ILoginMvpView> provideLoginMvpPresenter(LoginPresenter<ILoginMvpView> presenter) {
        return presenter;
    }

    // ---------------- Adapters

    @Provides
    TodoAdapter provideTodoAdapter() {
        return new TodoAdapter(new ArrayList<Todolist>());
    }

    // ---------------- Layout Manager

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    // ---------------- Utils

//    @Provides
//    Dialog provideDialog(AppCompatActivity activity) {
//        return new Dialog(activity);
//    }

}
