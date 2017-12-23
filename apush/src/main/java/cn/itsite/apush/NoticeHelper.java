package cn.itsite.apush;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import com.orhanobut.logger.Logger;

import cn.itsite.abase.BaseApplication;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by leguang on 2017/9/18 0018.
 * Email：langmanleguang@qq.com
 */

public class NoticeHelper {
    public static final String TAG = NoticeHelper.class.getSimpleName();

    public static void notify(Context mContext, final String message) {
    }

    public static void notify(String message, Notification notification) {
        NotificationManager manager = (NotificationManager) BaseApplication.mContext.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(message.hashCode(), notification);
    }

    public static void openUrl(Context context, String url) {
        if (!TextUtils.isEmpty(url.trim())) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            context.startActivity(intent);
        }
    }

    public static void openActivity(Context context, String activity) {
        if (!TextUtils.isEmpty(activity.trim())) {
            Intent intent = new Intent();
            intent.setClassName(context, activity);
            context.startActivity(intent);
        }
    }

    public static void launchApp(Context context) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (intent == null) {
            Logger.e("cannot find app:" + context.getPackageName());
        } else {
            context.startActivity(intent);
        }
    }

    public static void cancel(int id) {
        NotificationManager manager = (NotificationManager) BaseApplication.mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(id);
    }
}
