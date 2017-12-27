package cn.itsite.suiliao;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.Logger;

import org.litepal.LitePal;

import cn.itsite.abase.BaseApplication;
import cn.itsite.abase.common.UserHelper;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class App extends BaseApplication implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = App.class.getSimpleName();
    public static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        initData();//数据的初始化要在友盟推送之前，因为要注册别名时，用到用户名。
        initPush();//初始化推送。
        LitePal.initialize(this);//初始化ORM。
        initRouter();
    }

    private void initRouter() {
//        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }

    private void initData() {
        UserHelper.init();
        registerActivityLifecycleCallbacks(this);
    }

    /**
     * 初始化推送。
     */
    public void initPush() {
//        PushHelper.init(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Logger.e("onActivityCreated");
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Logger.e("onActivityStarted");
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Logger.e("onActivityResumed");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Logger.e("onActivityPaused");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Logger.e("onActivityStopped");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Logger.e("onActivitySaveInstanceState");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Logger.e("onActivityDestroyed");
    }
}
