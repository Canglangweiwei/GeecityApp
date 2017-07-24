package net.geecity.hisenseplus.ui.home;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;

import net.geecity.hisenseplus.BaseFragment;
import net.geecity.hisenseplus.R;
import net.geecity.hisenseplus.app.AppComponent;

import butterknife.Bind;

/**
 * <p>
 * 首页
 * </p>
 * Created by Administrator on 2017/7/7 0007.
 */
@SuppressWarnings("ALL")
public class HomeFragment extends BaseFragment implements ObservableScrollViewCallbacks {

    @Bind(R.id.scrollView)
    ObservableScrollView scrollView;
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.common_toolbar_title)
    TextView commonToolbarTitle;

    private int mParallaxImageHeight;

    private Bundle args;

    public static HomeFragment newInstance(Bundle args) {
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(args);
        return homeFragment;
    }

    /**
     * 解析页面传值
     */
    private void parseIntent() {
        args = getArguments();
    }

    @Override
    public int initContentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initUi() {
        commonToolbarTitle.setText("首页");
        // 设置背景为透明
        toolBar.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, getResources().getColor(R.color.colorPrimaryDark)));
    }

    @Override
    protected void initDatas() {
        parseIntent();
    }

    @Override
    protected void initListener() {
        scrollView.setScrollViewCallbacks(this);
        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);
    }

    @Override
    protected void setupComponent(AppComponent component) {

    }

    @Override
    public void onScrollChanged(int i, boolean b, boolean b1) {
        int baseColor = getResources().getColor(R.color.colorPrimaryDark);
        float alpha = Math.min(1, (float) i / mParallaxImageHeight);
        toolBar.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }
}
