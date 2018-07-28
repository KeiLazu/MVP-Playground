package com.gastropodinteractive.mvp_playground.fragments.homepage;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.gastropodinteractive.mvp_playground.base.BasePresenter;
import com.gastropodinteractive.mvp_playground.data.IDataManager;
import com.gastropodinteractive.mvp_playground.data.services.datamodel.Todolist;
import com.gastropodinteractive.mvp_playground.data.services.model.GetTodolist;
import com.gastropodinteractive.mvp_playground.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Kei Lazu on 7/19/2018
 * check https://github.com/KeiLazu for more
 */
public class HomepagePresenter<V extends IHomepageMvpView> extends BasePresenter<V> implements IHomepageMvpPresenter<V> {

    @Inject
    public HomepagePresenter(IDataManager iDataManager, ISchedulerProvider iSchedulerProvider, CompositeDisposable compositeDisposable) {
        super(iDataManager, iSchedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getCompositeDisposable().add(getIDataManager()
                .getTodolist()
                .subscribeOn(getISchedulerProvider().io())
                .observeOn(getISchedulerProvider().ui())
                .subscribe(new Consumer<GetTodolist>() {
                    @Override
                    public void accept(GetTodolist getTodolist) throws Exception {
                        Log.i("getTodolist", "todolist>\n" + getTodolist.toString());
                        getMvpView().updateTodo(getTodolist.getTodolist());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        getMvpView().showMessage("ErrCode: HP-OVP42");
                    }
                }));
    }

    @Override
    public void toTodoDetail(Todolist todolist) {
        getMvpView().toTodoDetail(getGson().toJson(todolist));
    }

}
