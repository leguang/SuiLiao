package cn.itsite.suiliao;

import android.os.Bundle;

import cn.itsite.abase.mvp.view.base.BaseActivity;

/**
 * @author leguang
 * @version v0.0.0
 * @E-mail langmanleguang@qq.com
 * @time 2017/12/23 0023 18:22
 */
public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findFragment(MainFragment.class) == null) {
            loadRootFragment(R.id.fl_container, new MainFragment());
        }
    }
}
