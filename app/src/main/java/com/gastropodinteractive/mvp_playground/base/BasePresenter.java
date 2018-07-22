package com.gastropodinteractive.mvp_playground.base;

/**
 * Created by Kei Lazu on 7/17/2018
 * check https://github.com/KeiLazu for more
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V mMvpView;

    @Override
    public void onAttach(V MvpView) {
        mMvpView = MvpView;
    }

    @Override
    public void onDetach() {
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
