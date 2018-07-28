package com.gastropodinteractive.mvp_playground.fragments.tododetail;

import com.gastropodinteractive.mvp_playground.base.BaseFragment;
import com.gastropodinteractive.mvp_playground.base.BasePresenter;
import com.gastropodinteractive.mvp_playground.data.IDataManager;
import com.gastropodinteractive.mvp_playground.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Kei Lazu on 7/28/2018
 * check https://github.com/KeiLazu for more
 */
public class TodoDetailPresenter<V extends ITodoDetailView> extends BasePresenter<V> implements ITodoDetailPresenter<V> {

    @Inject
    public TodoDetailPresenter(IDataManager iDataManager, ISchedulerProvider iSchedulerProvider, CompositeDisposable compositeDisposable) {
        super(iDataManager, iSchedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {

    }
}
