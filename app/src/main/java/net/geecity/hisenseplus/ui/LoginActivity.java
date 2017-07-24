package net.geecity.hisenseplus.ui;

import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;

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

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * <p>
 * 用戶登陸
 * </p>
 * Created by Administrator on 2017/7/6 0006.
 */
public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Bind(R.id.et_login_account)
    EditText mEditUsername;// 账号
    @Bind(R.id.et_login_pwd)
    EditText mEditPassword;// 密码

    @Bind(R.id.btn_login)
    Button btn_login;

    @Inject
    LoginPresenter presenter;

    @Override
    protected int initContentView() {
        return R.layout.activity_login;
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
        UserBean loginInfo = ShareUtil.getLoginInfo(this);
        mEditUsername.setText(loginInfo.getAccount());
        mEditPassword.setText(loginInfo.getPassword());
        // 绑定页面
        presenter.attachView(this);
    }

    @Override
    protected void initListener() {
        /**
         * 检测用户名输入框
         */
        RxTextView.textChanges(mEditUsername).subscribe(new Action1<CharSequence>() {
            @Override
            public void call(CharSequence charSequence) {
                presenter.checkInput(charSequence.toString().trim(), mEditPassword.getText().toString().trim());
            }
        });

        /**
         * 检测密码输入框
         */
        RxTextView.textChanges(mEditPassword).subscribe(new Action1<CharSequence>() {
            @Override
            public void call(CharSequence charSequence) {
                presenter.checkInput(mEditUsername.getText().toString().trim(), charSequence.toString().trim());
            }
        });
    }

    /**
     * 开始登录
     */
    @OnClick({R.id.btn_login})
    void btnLogin() {
        String username = mEditUsername.getText().toString().trim();
        String password = mEditPassword.getText().toString().trim();
        presenter.login(username, password);
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
        if (allowedLogin) {
            btn_login.setEnabled(true);
        } else {
            btn_login.setEnabled(false);
        }
    }

    @Override
    public void onFailureCallback(Throwable throwable) {
        showToast("请检查网络是否已连接");
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
            userBean.setPassword(mEditPassword.getText().toString().trim());
            ShareUtil.saveLoginInfo(this, userBean);
            DaggerApplication.get(getApplicationContext()).setLoginBean(loginBean);

            startNextActivity(null, HomeActivity.class, true);
        } else if (Constants.FAILD.equals(result)) {
            showToast(loginResultBean.getErrorCode());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
