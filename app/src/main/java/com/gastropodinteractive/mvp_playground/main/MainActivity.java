package com.gastropodinteractive.mvp_playground.main;

import android.os.Bundle;

import com.gastropodinteractive.mvp_playground.R;
import com.gastropodinteractive.mvp_playground.base.BaseActivity;
import com.gastropodinteractive.mvp_playground.data.services.datamodel.Todolist;
import com.gastropodinteractive.mvp_playground.fragments.homepage.HomepageFragment;
import com.gastropodinteractive.mvp_playground.fragments.login.LoginFragment;
import com.gastropodinteractive.mvp_playground.fragments.tododetail.TodoDetailFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);

        showInitialFragment();
    }

    @Override
    public void showInitialFragment() {
        toLoginDisplay();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }

    @Override
    protected void setUp() {
    }

    @Override
    public void toHomepageDisplay() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment_holder, HomepageFragment.newInstance(), HomepageFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void toLoginDisplay() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment_holder, LoginFragment.newInstance(), LoginFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void toTodoDetailDisplay(String todolistJson) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment_holder, TodoDetailFragment.newInstance(todolistJson), TodoDetailFragment.class.getSimpleName())
                .commit();
    }

//    @Override
//    public void replaceFragment(int layout, Fragment fragment) {
//
//    }
}
