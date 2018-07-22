package com.gastropodinteractive.mvp_playground.fragments.homepage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gastropodinteractive.mvp_playground.R;
import com.gastropodinteractive.mvp_playground.base.BaseFragment;
import com.gastropodinteractive.mvp_playground.di.components.ActivityComponent;
import com.gastropodinteractive.mvp_playground.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomepageFragment extends BaseFragment implements IHomepageMvpView {

    @Inject
    IHomepageMvpPresenter<IHomepageMvpView> mPresenter;

    View v;

    @BindView(R.id.homepage_btn_login)
    Button btnLogin;

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
        mPresenter.onViewPrepared();
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    @OnClick(R.id.homepage_btn_login)
    public void toLoginDisplay() {
        if (getActivity() instanceof MainActivity) {
            MainActivity activity = (MainActivity) getActivity();
            activity.toLoginDisplay();
        }
    }
}
