package net.geecity.hisenseplus.ui;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import net.geecity.hisenseplus.BaseActivity;
import net.geecity.hisenseplus.R;
import net.geecity.hisenseplus.app.AppComponent;
import net.geecity.hisenseplus.config.Constants;
import net.geecity.hisenseplus.util.ShareUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * APP引导页
 */
@SuppressWarnings("ALL")
public class GuidePageActivity extends BaseActivity {

    private static final int[] PAGE_ID = {R.drawable.luncher_a, R.drawable.luncher_b, R.drawable.luncher_c};

    @Bind(R.id.pv_guide)
    ViewPager mViewPager;
    @Bind(R.id.btn_next)
    Button mBtnNext;
    @Bind(R.id.btn_start)
    Button mBtnStart;

    private List<View> mList = new ArrayList<>();
    private int mCurrentPoint;
    private boolean isFirstScrollEnd;

    @Override
    protected int initContentView() {
        return R.layout.activity_guide_page;
    }

    @Override
    protected void bindButterKnife() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initUi() {

    }

    private void initNovicePic() {
        for (int aPAGE_ID : PAGE_ID) {
            View view =
                    LayoutInflater.from(GuidePageActivity.this).inflate(R.layout.item_guide, null);
            ImageView imgv = (ImageView) view.findViewById(R.id.novi_img);
            imgv.setImageResource(aPAGE_ID);
            mList.add(view);
        }
        mViewPager.setAdapter(new NoviceAdapter());
        mViewPager.setCurrentItem(0);
    }

    @OnClick({R.id.btn_next, R.id.btn_start})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                if (mCurrentPoint < PAGE_ID.length - 1) {
                    mViewPager.setCurrentItem(mCurrentPoint + 1);
                }
                break;
            case R.id.btn_start:
                launcherHomeActivity();
            default:
                break;
        }
    }

    @Override
    protected void initDatas() {
        initNovicePic();
    }

    @Override
    protected void initListener() {
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                mCurrentPoint = arg0;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                if (arg0 == PAGE_ID.length - 1 && arg0 == mCurrentPoint) {
                    if (isFirstScrollEnd) {
                        launcherHomeActivity();
                    } else {
                        isFirstScrollEnd = true;
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    @Override
    protected void setupComponent(AppComponent component) {

    }

    /**
     * 启动下一页面
     */
    private void launcherHomeActivity() {
        ShareUtil.put(GuidePageActivity.this, Constants.is_first_start, false);
        startNextActivity(null, LoginActivity.class, true);
    }

    private class NoviceAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mList == null ? 0 : mList.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mList.get(position));
            return mList.get(position);
        }
    }
}
