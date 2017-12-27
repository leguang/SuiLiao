package cn.itsite.alaunch.launch.presenter;

import cn.itsite.abase.mvp.presenter.base.BasePresenter;
import cn.itsite.alaunch.launch.contract.SplashContract;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class SplashPresenter extends BasePresenter<SplashContract.View, SplashContract.Model>
        implements SplashContract.Presenter {
    private static final String TAG = SplashPresenter.class.getSimpleName();

    public SplashPresenter(SplashContract.View mView) {
        super(mView);
    }
}
