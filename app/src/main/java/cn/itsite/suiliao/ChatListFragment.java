package cn.itsite.suiliao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.itsite.abase.mvp.view.base.BaseFragment;

/**
 * @author leguang
 * @version v0.0.0
 * @E-mail langmanleguang@qq.com
 * @time 2017/12/23 0023 18:22
 */
public class ChatListFragment extends BaseFragment {
    private static final String TAG = ChatListFragment.class.getSimpleName();

    public static ChatListFragment newInstance() {
        ChatListFragment fragment = new ChatListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat_list, container, false);
    }


}
