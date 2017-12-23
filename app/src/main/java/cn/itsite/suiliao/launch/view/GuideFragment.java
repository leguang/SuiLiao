package cn.itsite.suiliao.launch.view;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.circlenavigator.CircleNavigator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.itsite.abase.cache.SPCache;
import cn.itsite.abase.mvp.view.base.BaseFragment;
import cn.itsite.suiliao.common.Constants;
import cn.itsite.suiliao.main.MainActivity;
import cn.itsite.suiliao.R;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class GuideFragment extends BaseFragment {
    private static final String TAG = GuideFragment.class.getSimpleName();
    @BindView(R.id.vp_guide_fragment)
    ViewPager vpGuide;
    @BindView(R.id.bt_guide_fragment)
    Button btGuide;
    @BindView(R.id.fl_container_guide_fragment)
    FrameLayout flContainer;
    @BindView(R.id.indicator_guide_fragment)
    MagicIndicator indicator;
    private Unbinder unbinder;
    Integer[] images = {
            R.drawable.bg_yingdao1ye_1242px_2208px,
            R.drawable.bg_yingdao2ye_1242px_2208px,
            R.drawable.bg_yingdao3ye_1242px_2208px};
    private ArgbEvaluator mArgbEvaluator = new ArgbEvaluator();

    public static GuideFragment newInstance() {
        return new GuideFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initListener();
        initIndicator();
    }

    private void initData() {
        vpGuide.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                if (images != null) {
                    return images.length;
                }
                return 0;
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.bt_guide_fragment)
    public void onViewClicked() {
        SPCache.put(_mActivity, Constants.ISFIRSTENTRY, false);
        startActivity(new Intent(_mActivity, MainActivity.class));
        _mActivity.overridePendingTransition(0, 0);
        //此处之所以延迟退出是因为立即退出在小米手机上会有一个退出跳转动画，而我不想要这个垂直退出的跳转动画。
        getView().postDelayed(() -> _mActivity.finish(), 1000);
    }

    private void initListener() {
        vpGuide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int evaluate;
                switch (position) {
                    case 0:
                        evaluate = (Integer) mArgbEvaluator.evaluate(positionOffset, 0XFF76C5F0, 0XFF052CB8);
                        flContainer.setBackgroundColor(evaluate);
                        break;
                    case 1:
                        evaluate = (Integer) mArgbEvaluator.evaluate(positionOffset, 0XFF052CB8, 0XFFFFFFFF);
                        flContainer.setBackgroundColor(evaluate);
                        break;
                    case 2:
                        break;
                }
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
