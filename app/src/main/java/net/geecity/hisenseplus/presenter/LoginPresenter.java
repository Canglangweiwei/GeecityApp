package net.geecity.hisenseplus.presenter;

import android.support.annotation.NonNull;

import net.geecity.hisenseplus.bean.LoginBean;
import net.geecity.hisenseplus.bean.LoginResultBean;
import net.geecity.hisenseplus.contract.LoginContract;
import net.geecity.hisenseplus.store.LoginStore;
import net.geecity.hisenseplus.util.Validator;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 用户登录
 */
@SuppressWarnings("ALL")
public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private Subscription mSubscription;
    private LoginBean loginBean;
    private Validator validator;

    public void checkInput(String username, String password) {
        if (validator == null) {
            return;
        }
        view.canLogin(validator.validUsername(username) && validator.validPassword(password));
    }

    @Inject
    LoginStore loginStore;

    @Inject
    public LoginPresenter(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void login(String username, String password) {
        mSubscription = loginStore.userLogin(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<LoginResultBean>() {
                    @Override
                    public void call(LoginResultBean loginResultBean) {
                        view.getLogininfo(loginResultBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        view.onFailureCallback(throwable);
                    }
                });
    }

    @Override
    public void attachView(@NonNull LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (mSubscription != null
                && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        view = null;
    }
}
