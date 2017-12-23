package cn.itsite.suiliao.login;

import android.Manifest;
import android.os.Bundle;

import com.taobao.accs.utl.ALog;

import java.util.List;

import cn.itsite.abase.mvp.view.base.BaseActivity;
import cn.itsite.abase.utils.ToastUtils;
import cn.itsite.suiliao.App;
import cn.itsite.suiliao.R;
import cn.itsite.suiliao.login.view.LoginFragment;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Author：leguang on 2017/4/12 0009 14:23
 * Email：langmanleguang@qq.com
 */

public class LoginActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {
    private static final String TAG = LoginActivity.class.getSimpleName();
    private static final int SMS = 122;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findFragment(LoginFragment.class) == null) {
            loadRootFragment(R.id.fl_container, LoginFragment.newInstance());
        }
    }

    @AfterPermissionGranted(SMS)
    private void sms() {
        String[] perms = {Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS};
        if (EasyPermissions.hasPermissions(this, perms)) {
            //有权限就直接进行定位操作
//            ToastUtils.showToast(App.mContext, "正在定位……");
//            initLocate();最好还是不需要定位，只记录手动选择的城市和小区。定位只是辅助筛选。
        } else {
            EasyPermissions.requestPermissions(this, "应用需要接收短信验证", SMS, perms);
            ToastUtils.showToast(App.mContext, "申请权限……");

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
        // Some permissions have been granted
        // ...

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
        // Some permissions have been denied
        // ...

    }
}
