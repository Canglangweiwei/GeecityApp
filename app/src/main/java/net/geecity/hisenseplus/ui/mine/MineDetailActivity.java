package net.geecity.hisenseplus.ui.mine;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import net.geecity.hisenseplus.BaseActivity;
import net.geecity.hisenseplus.R;
import net.geecity.hisenseplus.app.AppComponent;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * <p>
 * 用户详细信息
 * </p>
 * Created by Administrator on 2017/7/7 0007.
 */
public class MineDetailActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected int initContentView() {
        return R.layout.activity_mine_detail;
    }

    @Override
    protected void bindButterKnife() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initUi() {
        collapsingToolbar.setTitle("我的");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.app_name);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void setupComponent(AppComponent component) {

    }
}
