package net.geecity.hisenseplus.ui.manager;

import android.os.Bundle;

import net.geecity.hisenseplus.BaseFragment;
import net.geecity.hisenseplus.R;
import net.geecity.hisenseplus.app.AppComponent;

/**
 * <p>
 * 管家
 * </p>
 * Created by Administrator on 2017/7/7 0007.
 */
@SuppressWarnings("ALL")
public class GuanJiaFragment extends BaseFragment {

    private Bundle args;

    public static GuanJiaFragment newInstance(Bundle args) {
        GuanJiaFragment homeFragment = new GuanJiaFragment();
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
        return R.layout.fragment_manager;
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
