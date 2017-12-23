package cn.itsite.suiliao.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.itsite.abase.mvp.view.base.BaseFragment;
import cn.itsite.suiliao.main.chat.ChatListFragment;
import cn.itsite.suiliao.R;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author leguang
 * @version v0.0.0
 * @E-mail langmanleguang@qq.com
 * @time 2017/12/23 0023 18:22
 */
public class MainFragment extends BaseFragment {
    private static final String TAG = MainFragment.class.getSimpleName();
    private SupportFragment[] mFragments = new SupportFragment[3];

    public static MainFragment newInstance(Bundle bundle) {
        MainFragment fragment = new MainFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportFragment firstFragment = findFragment(ChatListFragment.class);
        if (firstFragment == null) {
            mFragments[0] = ChatListFragment.newInstance();
            mFragments[1] = ChatListFragment.newInstance();
            mFragments[2] = ChatListFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_container, 0,
                    mFragments[0],
                    mFragments[1],
                    mFragments[2]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用
            mFragments[0] = firstFragment;
            mFragments[1] = findFragment(ChatListFragment.class);
            mFragments[2] = findFragment(ChatListFragment.class);
        }

        initView(view);
    }

    private void initView(View view) {
        BottomNavigationView navigation = view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_chat:
                    return true;
                case R.id.navigation_play:
                    return true;
                case R.id.navigation_mine:
                    return true;
                default:
                    break;
            }
            return false;
        });
    }
}
