package cn.itsite.suiliao.main.play.view;

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

public class PlayFragment extends BaseFragment {
    public final String TAG = PlayFragment.class.getSimpleName();

    public static PlayFragment newInstance() {
        return new PlayFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
