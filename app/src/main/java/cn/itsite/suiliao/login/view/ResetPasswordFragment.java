package cn.itsite.suiliao.login.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.itsite.abase.mvp.view.base.BaseFragment;
import cn.itsite.dreamnote.login.contract.ResetPasswordContract;
import cn.itsite.dreamnote.login.presenter.ResetPasswordPresenter;


/**
 * Author：leguang on 2017/4/12 0009 14:23
 * Email：langmanleguang@qq.com
 */

public class ResetPasswordFragment extends BaseFragment<ResetPasswordContract.Presenter> implements ResetPasswordContract.View {
    public static final String TAG = ResetPasswordFragment.class.getSimpleName();

    @NonNull
    @Override
    protected ResetPasswordContract.Presenter createPresenter() {
        return new ResetPasswordPresenter(this);
    }

    public static ResetPasswordFragment newInstance() {
        return new ResetPasswordFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_forget_password, container, false);
//        unbinder = ButterKnife.bind(this, view);
//        return attachToSwipeBack(view);
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initToolbar();
        initData();
        initListener();
    }

    private void initToolbar() {
//        initStateBar(toolbar);
//        toolbarTitle.setText("重置密码");
//        toolbar.setNavigationIcon(R.drawable.ic_back_blue_60_60);
//        toolbar.setNavigationOnClickListener(v -> _mActivity.onBackPressedSupport());
    }

    private void initData() {
    }

    private void initListener() {
//        etPhoneNo.addTextChangedListener(textWatcher);
//        etPassword.addTextChangedListener(textWatcher);
//        etVerifyCode.addTextChangedListener(textWatcher);
//        etAgainPassword.addTextChangedListener(textWatcher);
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



    //检查是否输入完全
    private void checkIsInputComplete() {
//        boolean userName = TextUtils.isEmpty(etPhoneNo.getText().toString());
//        boolean password = TextUtils.isEmpty(etPassword.getText().toString());
//        boolean againPassword = TextUtils.isEmpty(etAgainPassword.getText().toString());
//        boolean verCode = TextUtils.isEmpty(etVerifyCode.getText().toString());
//
//        boolean all = userName || password || againPassword || verCode;
//
//        btnSubmit.setEnabled(!all);
//        if (tvGetVerify.getText().toString().equals("获取验证码")) {
//            tvGetVerify.setEnabled(!userName);
//        }
    }
}
