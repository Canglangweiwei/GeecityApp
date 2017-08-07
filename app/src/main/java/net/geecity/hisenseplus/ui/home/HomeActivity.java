package net.geecity.hisenseplus.ui.home;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import net.geecity.hisenseplus.BaseActivity;
import net.geecity.hisenseplus.R;
import net.geecity.hisenseplus.app.AppComponent;
import net.geecity.hisenseplus.ui.DaggerApplication;
import net.geecity.hisenseplus.ui.find.FindFragment;
import net.geecity.hisenseplus.ui.live.LiveFragment;
import net.geecity.hisenseplus.ui.manager.GuanJiaFragment;
import net.geecity.hisenseplus.ui.mine.MineFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * <p>
 * 首页
 * </p>
 * Created by Administrator on 2017/7/7 0007.
 */
@SuppressWarnings("ALL")
public class HomeActivity extends BaseActivity {

    @Bind(R.id.drawer_layout)
    LinearLayout drawerLayout;

    @Bind(R.id.m_main_sy_btn_true)
    Button mMainSyBtnTrue;
    @Bind(R.id.m_main_gj_btn_true)
    Button mMainGjBtnTrue;
    @Bind(R.id.m_main_sh_btn_true)
    Button mMainShBtnTrue;
    @Bind(R.id.m_main_fx_btn_true)
    Button mMainFxBtnTrue;
    @Bind(R.id.m_main_wd_btn_true)
    Button mMainWdBtnTrue;

    private Fragment homeFrg, managerFrg, lifeFrg, findFrg, mineFrg;

    @Override
    protected int initContentView() {
        return R.layout.activity_home;
    }

    @Override
    protected void initUi() {
        changeBottomStatus(0);
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

    /**
     * 底部导航标签的点击事件
     *
     * @param view
     */
    @OnClick({R.id.m_main_sy_btn_false, R.id.m_main_sy_btn_true, R.id.m_main_fw_lay,
            R.id.m_main_gj_btn_false, R.id.m_main_gj_btn_true, R.id.m_main_sj_lay,
            R.id.m_main_sh_btn_false, R.id.m_main_sh_btn_true, R.id.m_main_gz_lay,
            R.id.m_main_fx_btn_false, R.id.m_main_fx_btn_true, R.id.m_main_lxr_lay,
            R.id.m_main_wd_btn_false, R.id.m_main_wd_btn_true, R.id.m_main_wd_lay})
    void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_main_sy_btn_false:// 首页
            case R.id.m_main_sy_btn_true:
            case R.id.m_main_fw_lay:
                changeBottomStatus(0);
                break;
            case R.id.m_main_gj_btn_false:// 管家
            case R.id.m_main_gj_btn_true:
            case R.id.m_main_sj_lay:
                changeBottomStatus(1);
                break;
            case R.id.m_main_sh_btn_false:// 生活
            case R.id.m_main_sh_btn_true:
            case R.id.m_main_gz_lay:
                changeBottomStatus(2);
                break;
            case R.id.m_main_fx_btn_false:// 发现
            case R.id.m_main_fx_btn_true:
            case R.id.m_main_lxr_lay:
                changeBottomStatus(3);
                break;
            case R.id.m_main_wd_btn_false:// 我的
            case R.id.m_main_wd_btn_true:
            case R.id.m_main_wd_lay:
                changeBottomStatus(4);
                break;
        }
    }

    /**
     * 更改底部按钮状态
     *
     * @param index 选中第几个
     */
    private void changeBottomStatus(int index) {
        addFragmentToStack(index);
        mMainSyBtnTrue.setVisibility((index == 0) ? View.VISIBLE : View.GONE);
        mMainGjBtnTrue.setVisibility((index == 1) ? View.VISIBLE : View.GONE);
        mMainShBtnTrue.setVisibility((index == 2) ? View.VISIBLE : View.GONE);
        mMainFxBtnTrue.setVisibility((index == 3) ? View.VISIBLE : View.GONE);
        mMainWdBtnTrue.setVisibility((index == 4) ? View.VISIBLE : View.GONE);
    }

    /**
     * 添加fragment
     *
     * @param index 选中第几个
     */
    private void addFragmentToStack(int index) {
        Bundle bundle = new Bundle();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                bundle.putString("home", "home");
                /** 首页 */
                if (homeFrg == null) {
                    homeFrg = HomeFragment.newInstance(bundle);
                    transaction.add(R.id.m_home_frameLayout, homeFrg);
                } else {
                    transaction.show(homeFrg);
                }
                break;
            case 1:
                bundle.putString("manager", "manager");
                /** 管家 */
                if (managerFrg == null) {
                    managerFrg = GuanJiaFragment.newInstance(bundle);
                    transaction.add(R.id.m_home_frameLayout, managerFrg);
                } else {
                    transaction.show(managerFrg);
                }
                break;
            case 2:
                bundle.putString("live", "live");
                /** 生活 */
                if (lifeFrg == null) {
                    lifeFrg = LiveFragment.newInstance(bundle);
                    transaction.add(R.id.m_home_frameLayout, lifeFrg);
                } else {
                    transaction.show(lifeFrg);
                }
                break;
            case 3:
                bundle.putString("find", "find");
                /** 发现 */
                if (findFrg == null) {
                    findFrg = FindFragment.newInstance(bundle);
                    transaction.add(R.id.m_home_frameLayout, findFrg);
                } else {
                    transaction.show(findFrg);
                }
                break;
            case 4:
                bundle.putString("mine", "mine");
                /** 我的 */
                if (mineFrg == null) {
                    mineFrg = MineFragment.newInstance(bundle);
                    transaction.add(R.id.m_home_frameLayout, mineFrg);
                } else {
                    transaction.show(mineFrg);
                }
                break;
            default:
                bundle.putString("home", "home");
                /** 首页 */
                if (homeFrg == null) {
                    homeFrg = HomeFragment.newInstance(bundle);
                    transaction.add(R.id.m_home_frameLayout, homeFrg);
                } else {
                    transaction.show(homeFrg);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFrg != null) {
            transaction.hide(homeFrg);
        }
        if (managerFrg != null) {
            transaction.hide(managerFrg);
        }
        if (lifeFrg != null) {
            transaction.hide(lifeFrg);
        }
        if (findFrg != null) {
            transaction.hide(findFrg);
        }
        if (mineFrg != null) {
            transaction.hide(mineFrg);
        }
    }

    private long newTime;

    /**
     * 监听返回键
     */
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - newTime > 2000) {
            newTime = System.currentTimeMillis();
            Snackbar snackbar = Snackbar.make(drawerLayout, getString(R.string.press_twice_exit), Snackbar.LENGTH_SHORT);
            snackbar.setAction(R.string.exit_directly, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DaggerApplication.get(getApplicationContext()).finishAllActivity();
                }
            });
            snackbar.show();
        } else {
            moveTaskToBack(true);
        }
    }
}
