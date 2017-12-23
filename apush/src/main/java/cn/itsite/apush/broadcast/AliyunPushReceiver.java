package cn.itsite.apush.broadcast;

import android.content.Context;

import cn.itsite.apush.NoticeHelper;
import com.alibaba.sdk.android.push.MessageReceiver;
import com.alibaba.sdk.android.push.notification.CPushMessage;
import com.orhanobut.logger.Logger;
import com.taobao.accs.utl.ALog;

import java.util.Map;

/**
 * Created by leguang on 2017/9/22 0022.
 * Email：langmanleguang@qq.com
 */

public class AliyunPushReceiver extends MessageReceiver {
    public static final String TAG = AliyunPushReceiver.class.getSimpleName();

    @Override
    public void onNotification(Context context, final String title, final String summary, final Map<String, String> extraMap) {
        Logger.e("onNotification, title: " + title + ", summary: " + summary + ", extraMap: " + extraMap);
    }

    @Override
    public void onMessage(Context context, CPushMessage message) {
        Logger.e("onMessage, messageId: " + message.getMessageId() + ", title: " + message.getTitle() + ", content:" + message.getContent());
        NoticeHelper.notify(context, message.getContent());
    }

    @Override
    public void onNotificationOpened(Context context, String title, String summary, String extraMap) {
        Logger.e("onNotificationOpened, title: " + title + ", summary: " + summary + ", extraMap:" + extraMap);
    }

    @Override
    protected void onNotificationClickedWithNoAction(Context context, String title, String summary, String extraMap) {
        Logger.e("onNotificationClickedWithNoAction, title: " + title + ", summary: " + summary + ", extraMap:" + extraMap);
    }

    @Override
    protected void onNotificationReceivedInApp(Context context, String title, String summary, Map<String, String> extraMap, int openType, String openActivity, String openUrl) {
        Logger.e("onNotificationReceivedInApp, title: " + title + ", summary: " + summary + ", extraMap:" + extraMap + ", openType:" + openType + ", openActivity:" + openActivity + ", openUrl:" + openUrl);
    }

    @Override
    protected void onNotificationRemoved(Context context, String messageId) {
        Logger.e("onNotificationRemoved, messageId:" + messageId);
    }


}