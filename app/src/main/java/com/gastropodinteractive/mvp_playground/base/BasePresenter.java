package com.gastropodinteractive.mvp_playground.base;

import com.gastropodinteractive.mvp_playground.data.DataManager;
import com.gastropodinteractive.mvp_playground.data.IDataManager;
import com.gastropodinteractive.mvp_playground.utils.rx.ISchedulerProvider;
import com.gastropodinteractive.mvp_playground.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Kei Lazu on 7/17/2018
 * check https://github.com/KeiLazu for more
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V mMvpView;

    private final IDataManager mIDataManager;
    private final ISchedulerProvider mISchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;

    @Inject
    public BasePresenter(IDataManager iDataManager,
                         ISchedulerProvider iSchedulerProvider,
                         CompositeDisposable compositeDisposable) {
        this.mIDataManager = iDataManager;
        this.mISchedulerProvider = iSchedulerProvider;
        this.mCompositeDisposable = compositeDisposable;
    }

    public IDataManager getIDataManager() {
        return mIDataManager;
    }

    public ISchedulerProvider getISchedulerProvider() {
        return mISchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    @Override
    public void onAttach(V MvpView) {
        mMvpView = MvpView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }

}
