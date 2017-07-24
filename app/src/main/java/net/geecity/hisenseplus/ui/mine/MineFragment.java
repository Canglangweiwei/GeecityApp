package net.geecity.hisenseplus.ui.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.geecity.hisenseplus.BaseActivity;
import net.geecity.hisenseplus.BaseFragment;
import net.geecity.hisenseplus.R;
import net.geecity.hisenseplus.app.AppComponent;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <p>
 * 我的
 * </p>
 * Created by Administrator on 2017/7/7 0007.
 */
@SuppressWarnings("ALL")
public class MineFragment extends BaseFragment {

    @Bind(R.id.common_toolbar_title)
    TextView commonToolbarTitle;

    private Bundle args;

    public static MineFragment newInstance(Bundle args) {
        MineFragment homeFragment = new MineFragment();
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
        return R.layout.fragment_mine;
    }

    @Override
    protected void initUi() {
        commonToolbarTitle.setText("我的");
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

    @OnClick({R.id.btn_userinfo})
    void onclick() {
        ((BaseActivity) getActivity()).startNextActivity(null, MineDetailActivity.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
