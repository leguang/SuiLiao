package cn.itsite.alaunch.launch.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.circlenavigator.CircleNavigator;

import cn.itsite.abase.cache.SPCache;
import cn.itsite.abase.mvp.view.base.BaseFragment;
import cn.itsite.alaunch.R;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class GuideFragment extends BaseFragment {
    private static final String TAG = GuideFragment.class.getSimpleName();
    public static final String IS_FIRST_ENTRY = "is_first_entry";
    private ViewPager vpGuide;
    private Button btGuide;
    private MagicIndicator indicator;
    Integer[] images = {
            R.drawable.bg_yingdao1ye_1242px_2208px,
            R.drawable.bg_yingdao2ye_1242px_2208px,
            R.drawable.bg_yingdao3ye_1242px_2208px};

    public static GuideFragment newInstance() {
        return new GuideFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        initListener();
        initIndicator();
    }

    private void initView(View view) {
        vpGuide = view.findViewById(R.id.vp_guide_fragment);
        btGuide = view.findViewById(R.id.bt_guide_fragment);
        indicator = view.findViewById(R.id.indicator_guide_fragment);
    }

    private void initData() {
        vpGuide.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return images == null ? 0 : images.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView iv = new ImageView(_mActivity);
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(_mActivity)
                        .load(images[position])
                        .into(iv);
                container.addView(iv);
                return iv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
    }

    private void initListener() {
        btGuide.setOnClickListener(view -> {
            SPCache.put(_mActivity, IS_FIRST_ENTRY, false);

            // TODO: 2017/12/27 0027 改成隐士启动，用ARouter
//        startActivity(new Intent(_mActivity, MainActivity.class));
            ARouter.getInstance().build("/module/1").navigation();



            _mActivity.overridePendingTransition(0, 0);
            //此处之所以延迟退出是因为立即退出在小米手机上会有一个退出跳转动画，而我不想要这个垂直退出的跳转动画。
//            getView().postDelayed(() -> _mActivity.finish(), 1000);
        });

        vpGuide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == images.length - 1) {
                    btGuide.setVisibility(View.VISIBLE);
                } else {
                    btGuide.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initIndicator() {
        CircleNavigator circleNavigator = new CircleNavigator(_mActivity);
        circleNavigator.setCircleCount(images.length);
        circleNavigator.setCircleColor(ContextCompat.getColor(_mActivity, R.color.base_color));
        circleNavigator.setCircleClickListener(index -> vpGuide.setCurrentItem(index));
        indicator.setNavigator(circleNavigator);
        ViewPagerHelper.bind(indicator, vpGuide);
    }
}
