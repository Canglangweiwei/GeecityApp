package net.geecity.hisenseplus.ui.live;

import android.os.Bundle;

import net.geecity.hisenseplus.BaseFragment;
import net.geecity.hisenseplus.R;
import net.geecity.hisenseplus.app.AppComponent;

/**
 * <p>
 * 生活
 * </p>
 * Created by Administrator on 2017/7/7 0007.
 */
@SuppressWarnings("ALL")
public class LiveFragment extends BaseFragment {

    private Bundle args;

    public static LiveFragment newInstance(Bundle args) {
        LiveFragment homeFragment = new LiveFragment();
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
        return R.layout.fragment_live;
    }

    @Override
    protected void initUi() {

    }

    @Override
    protected void initDatas() {
        parseIntent();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void setupComponent(AppComponent component) {

    }
}
