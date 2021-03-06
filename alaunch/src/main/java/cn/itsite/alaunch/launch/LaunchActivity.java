package cn.itsite.alaunch.launch;

import android.content.Intent;
import android.os.Bundle;

import cn.itsite.abase.mvp.view.base.BaseActivity;
import cn.itsite.abase.utils.ToastUtils;
import cn.itsite.alaunch.R;
import cn.itsite.alaunch.launch.view.SplashFragment;


/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class LaunchActivity extends BaseActivity {
    public static final String TAG = LaunchActivity.class.getSimpleName();
    private static final long WAIT_TIME = 2000L;// 再点一次退出程序时间设置。
    public static final String PRESS_AGAIN = "再按一次退出";
    private long TOUCH_TIME = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, SplashFragment.newInstance());
        }
    }

    @Override
    public boolean swipeBackPriority() {
        return false;
    }

    @Override
    public void onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            //退到桌面，而不是退出应用，让用户以为退出应用，尽量保活。
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            ToastUtils.showToast(this, PRESS_AGAIN);
        }
    }
}
