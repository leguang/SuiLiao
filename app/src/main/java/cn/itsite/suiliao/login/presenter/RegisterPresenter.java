package cn.itsite.suiliao.login.presenter;


import cn.itsite.abase.mvp.presenter.base.BasePresenter;
import cn.itsite.dreamnote.login.contract.RegisterContract;

/**
 * Author：leguang on 2017/4/12 0009 14:23
 * Email：langmanleguang@qq.com
 */

public class RegisterPresenter extends BasePresenter<RegisterContract.View, RegisterContract.Model> implements RegisterContract.Presenter {
    /**
     * 创建Presenter的时候就绑定View和创建model。
     *
     * @param mView 所要绑定的view层对象，一般在View层创建Presenter的时候通过this把自己传过来。
     */
    public RegisterPresenter(RegisterContract.View mView) {
        super(mView);
    }
}
