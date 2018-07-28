package com.gastropodinteractive.mvp_playground.fragments.tododetail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gastropodinteractive.mvp_playground.R;
import com.gastropodinteractive.mvp_playground.base.BaseFragment;
import com.gastropodinteractive.mvp_playground.data.services.datamodel.Todolist;
import com.gastropodinteractive.mvp_playground.di.components.ActivityComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodoDetailFragment extends BaseFragment implements ITodoDetailView {

    @Inject
    ITodoDetailPresenter<ITodoDetailView> mPresenter;

    View v;

    final static String TODOLIST_JSON = "TODOLIST_JSON";

    public TodoDetailFragment() {
        // Required empty public constructor
    }

    public static TodoDetailFragment newInstance(String todolistJson) {
        TodoDetailFragment fragment = new TodoDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TODOLIST_JSON, todolistJson);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_todo_detail, container, false);

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
        if (getArguments() != null) {
            showMessage("Adaan");
        }

        mPresenter.onViewPrepared();

    }
}
