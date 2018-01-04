package cn.itsite.achat.chat.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import cn.itsite.abase.common.Params;
import cn.itsite.abase.mvp.view.base.BaseFragment;
import cn.itsite.abase.mvp.view.base.BaseRecyclerViewAdapter;
import cn.itsite.achat.R;
import cn.itsite.statemanager.StateManager;

/**
 * @author leguang
 * @version v0.0.0
 * @E-mail langmanleguang@qq.com
 * @time 2017/12/23 0023 18:22
 */
public class ChatListFragment extends BaseFragment {
    private static final String TAG = ChatListFragment.class.getSimpleName();
    private StateManager mStateManager;
    private BaseRecyclerViewAdapter<String, BaseViewHolder> adapter;
    private Params params = Params.getInstance();
    private Toolbar toolbar;
    private RecyclerView recyclerView;

    public static ChatListFragment newInstance() {
        ChatListFragment fragment = new ChatListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        initStateManager();
    }

    private void initView(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        recyclerView = view.findViewById(R.id.recyclerView);
    }

    private void initData() {
        initStateBar(toolbar);
        toolbar.setTitle("连接什么WIFI");
        toolbar.setNavigationOnClickListener(v -> _mActivity.onBackPressed());

        recyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));

        List<String> mData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mData.add(i + "");
        }

        adapter = new BaseRecyclerViewAdapter<String, BaseViewHolder>(R.layout.item_chat_list, mData) {

            @Override
            protected void convert(BaseViewHolder holder, String item) {
                holder.setText(R.id.tv_delete_item_chat_list, item);
            }
        };
        //设置允许加载更多
        adapter.setOnLoadMoreListener(() -> {
            params.page++;
//            mPresenter.requestRecord(params);//请求开门记录列表
        }, recyclerView);
        recyclerView.setAdapter(adapter);
    }

    private void initStateManager() {
        mStateManager = StateManager.builder(_mActivity)
                .setContent(recyclerView)
                .setEmptyView(R.layout.state_empty)
//                .setEmptyImage(R.drawable.ic_open_record_empty_state_gray_200px)
                .setEmptyText("暂无开门记录！")
//                .setErrorOnClickListener(v -> ptrFrameLayout.autoRefresh())
//                .setEmptyOnClickListener(v -> ptrFrameLayout.autoRefresh())
                .build();
    }
}
