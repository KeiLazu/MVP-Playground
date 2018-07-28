package com.gastropodinteractive.mvp_playground.fragments.homepage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gastropodinteractive.mvp_playground.R;
import com.gastropodinteractive.mvp_playground.adapters.TodoAdapter;
import com.gastropodinteractive.mvp_playground.base.BaseFragment;
import com.gastropodinteractive.mvp_playground.data.services.datamodel.Todolist;
import com.gastropodinteractive.mvp_playground.data.services.model.GetTodolist;
import com.gastropodinteractive.mvp_playground.di.components.ActivityComponent;
import com.gastropodinteractive.mvp_playground.main.MainActivity;
import com.gastropodinteractive.mvp_playground.utils.ClickListener;
import com.gastropodinteractive.mvp_playground.utils.RecyclerTouchListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomepageFragment extends BaseFragment implements IHomepageMvpView, ClickListener {

    @Inject
    IHomepageMvpPresenter<IHomepageMvpView> mPresenter;

    @Inject
    TodoAdapter todoAdapter;

    @Inject
    LinearLayoutManager llmTodo;

    View v;

    @BindView(R.id.homepage_rv_todo)
    RecyclerView rvTodo;

    public HomepageFragment() {
        // Required empty public constructor
    }

    public static HomepageFragment newInstance() {
        HomepageFragment homepageFragment = new HomepageFragment();
        return homepageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_homepage, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, v));
            mPresenter.onAttach(this);
        }

        return v;
    }

    @Override
    protected void setUp(View view) {
        llmTodo.setOrientation(LinearLayoutManager.VERTICAL);
        rvTodo.setLayoutManager(llmTodo);
        rvTodo.setItemAnimator(new DefaultItemAnimator());
        rvTodo.setAdapter(todoAdapter);
        rvTodo.addOnItemTouchListener(new RecyclerTouchListener(getContext(), rvTodo, this));

        mPresenter.onViewPrepared();
    }

    @Override
    public void updateTodo(List<Todolist> todolist) {
        todoAdapter.addTodolist(todolist);
    }

    @Override
    public void toTodoDetail(String todolistJson) {
        if (getActivity() instanceof MainActivity) {
            MainActivity activity = (MainActivity) getActivity();
            activity.toTodoDetailDisplay(todolistJson);
        }
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void onClick(View view, int position) {
        mPresenter.toTodoDetail(todoAdapter.getTodolistInPosition(position));
    }

    @Override
    public void onLongClick(View view, int position) {

    }
}
