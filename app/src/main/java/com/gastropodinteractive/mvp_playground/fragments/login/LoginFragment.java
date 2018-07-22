package com.gastropodinteractive.mvp_playground.fragments.login;


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
public class LoginFragment extends BaseFragment implements ILoginMvpView {

    @Inject
    ILoginMvpPresenter<ILoginMvpView> mPresenter;

    View v;

    @BindView(R.id.login_btn_homepage)
    Button btnToHomepage;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment loginFragment = new LoginFragment();
        return loginFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_login, container, false);

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

    // Click Logic
    @OnClick(R.id.login_btn_homepage)
    void ToHomepage() {
        if (getActivity() instanceof MainActivity) {
            MainActivity activity = (MainActivity) getActivity();
            activity.toHomepageDisplay();
        }
    }

}
