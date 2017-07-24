package net.geecity.hisenseplus.ui.find;

import android.os.Bundle;

import net.geecity.hisenseplus.BaseFragment;
import net.geecity.hisenseplus.R;
import net.geecity.hisenseplus.app.AppComponent;

/**
 * <p>
 * 首页
 * </p>
 * Created by Administrator on 2017/7/7 0007.
 */
@SuppressWarnings("ALL")
public class FindFragment extends BaseFragment {

    private Bundle args;

    public static FindFragment newInstance(Bundle args) {
        FindFragment homeFragment = new FindFragment();
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
        return R.layout.fragment_find;
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
