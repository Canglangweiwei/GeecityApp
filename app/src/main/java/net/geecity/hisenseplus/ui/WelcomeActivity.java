package net.geecity.hisenseplus.ui;

import android.os.Handler;
import android.text.TextUtils;

import net.geecity.hisenseplus.BaseActivity;
import net.geecity.hisenseplus.R;
import net.geecity.hisenseplus.app.AppComponent;
import net.geecity.hisenseplus.bean.LoginBean;
import net.geecity.hisenseplus.bean.LoginResultBean;
import net.geecity.hisenseplus.bean.UserBean;
import net.geecity.hisenseplus.component.DaggerLoginPresenterComponent;
import net.geecity.hisenseplus.config.Constants;
import net.geecity.hisenseplus.contract.LoginContract;
import net.geecity.hisenseplus.module.LoginModule;
import net.geecity.hisenseplus.presenter.LoginPresenter;
import net.geecity.hisenseplus.ui.home.HomeActivity;
import net.geecity.hisenseplus.util.ShareUtil;
import net.geecity.hisenseplus.util.Validator;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * 欢迎页
 */
public class WelcomeActivity extends BaseActivity implements LoginContract.View {

    private String username, password;

    @Inject
    LoginPresenter presenter;

    @Override
    protected int initContentView() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void bindButterKnife() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initUi() {

    }

    @Override
    protected void initDatas() {
        final UserBean userBean = ShareUtil.getLoginInfo(this);
        if (userBean != null) {
            username = userBean.getAccount();
            password = userBean.getPassword();
        }

        presenter.attachView(this);
        final boolean needGuide = (boolean) ShareUtil.get(WelcomeActivity.this, Constants.is_first_start, true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (needGuide) {
                    startNextActivity(null, GuidePageActivity.class, true);
                } else {
                    if (userBean == null
                            || TextUtils.isEmpty(username)
                            || TextUtils.isEmpty(password)) {
                        startNextActivity(null, LoginActivity.class, true);
                    } else {
                        presenter.login(username, password);
                    }
                }
            }
        }, 1500);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void setupComponent(AppComponent component) {
        DaggerLoginPresenterComponent.builder()
                .appComponent(component)
                .loginModule(new LoginModule(this, new Validator()))
                .build()
                .inject(this);
    }

    @Override
    public void canLogin(boolean allowedLogin) {

    }

    @Override
    public void getLogininfo(LoginResultBean loginResultBean) {
        if (loginResultBean == null) {
            showToast("登录失败");
            return;
        }
        String result = loginResultBean.getResult();

        // 成功返回请求数据
        if (Constants.SUCCESS.equals(result)) {
            LoginBean loginBean = loginResultBean.getData();
            if (loginBean == null) {
                return;
            }
            UserBean userBean = loginBean.getUser();
            if (userBean == null) {
                return;
            }
            // 保存用户信息
            userBean.setPassword(password);
            ShareUtil.saveLoginInfo(this, userBean);
            DaggerApplication.get(getApplicationContext()).setLoginBean(loginBean);

            startNextActivity(null, HomeActivity.class, true);
        } else if (Constants.FAILD.equals(result)) {
            showToast(loginResultBean.getErrorCode());
        }
    }

    @Override
    public void onFailureCallback(Throwable throwable) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
