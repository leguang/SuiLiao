package cn.itsite.alogin.login.presenter;

import android.support.annotation.NonNull;

import cn.itsite.abase.mvp.presenter.base.BasePresenter;
import cn.itsite.alogin.login.contract.ResetPasswordContract;
import cn.itsite.alogin.login.model.ResetPasswordModel;


/**
 * Author：leguang on 2017/4/12 0009 14:23
 * Email：langmanleguang@qq.com
 */

public class ResetPasswordPresenter extends BasePresenter<ResetPasswordContract.View, ResetPasswordContract.Model> implements ResetPasswordContract.Presenter {
    /**
     * 创建Presenter的时候就绑定View和创建model。
     *
     * @param mView 所要绑定的view层对象，一般在View层创建Presenter的时候通过this把自己传过来。
     */
    public ResetPasswordPresenter(ResetPasswordContract.View mView) {
        super(mView);
    }

    @NonNull
    @Override
    protected ResetPasswordContract.Model createModel() {
        return new ResetPasswordModel();
    }

}
