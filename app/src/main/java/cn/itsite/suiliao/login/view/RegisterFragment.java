package cn.itsite.suiliao.login.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.itsite.abase.common.DialogHelper;
import cn.itsite.abase.mvp.view.base.BaseFragment;
import cn.itsite.suiliao.login.contract.RegisterContract;
import cn.itsite.suiliao.login.presenter.RegisterPresenter;


/**
 * Author：leguang on 2017/4/12 0009 14:23
 * Email：langmanleguang@qq.com
 */

public class RegisterFragment extends BaseFragment<RegisterPresenter> implements RegisterContract.View {
    public static final String TAG = RegisterFragment.class.getSimpleName();

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @NonNull
    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter(this);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_register, container, false);
//        unbinder = ButterKnife.bind(this, view);
//        return attachToSwipeBack(view);
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initToolbar();
        initData();
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkIsInputComplete();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void initToolbar() {
//        initStateBar(toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_back_blue_60_60);
//        toolbar.setNavigationOnClickListener(v -> _mActivity.onBackPressedSupport());
    }

    private void initData() {
    }


    //检查是否输入完全
    private void checkIsInputComplete() {
//        boolean agree = !cbAgree.isChecked();
//        boolean userName = TextUtils.isEmpty(etPhoneNo.getText().toString());
//        boolean password = TextUtils.isEmpty(etPassword.getText().toString());
//        boolean againPassword = TextUtils.isEmpty(etAgainPassword.getText().toString());
//        boolean verCode = TextUtils.isEmpty(etVerifyCode.getText().toString());
//
//        boolean all = agree || userName || password || againPassword || verCode;
//
//        btSubmit.setEnabled(!all);
//        if (tvGetVerify.getText().toString().equals("获取验证码")) {
//            tvGetVerify.setEnabled(!userName);
//        }
    }

    @Override
    public void start(Object response) {

    }

    @Override
    public void error(String errorMessage) {
        DialogHelper.warningSnackbar(getView(), errorMessage);
    }
}
