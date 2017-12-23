package cn.itsite.suiliao.main.mine.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.itsite.abase.mvp.view.base.BaseFragment;
import cn.itsite.suiliao.R;

/**
 * Created by leguang on 2017/9/15 0015.
 * Email：langmanleguang@qq.com
 */

public class MineFragment extends BaseFragment {
    public final String TAG = MineFragment.class.getSimpleName();

    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
