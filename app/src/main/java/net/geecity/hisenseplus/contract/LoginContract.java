package net.geecity.hisenseplus.contract;

import net.geecity.hisenseplus.BasePresenter;
import net.geecity.hisenseplus.BaseView;
import net.geecity.hisenseplus.bean.LoginResultBean;

@SuppressWarnings("ALL")
public interface LoginContract {

    interface View extends BaseView {
        void canLogin(boolean allowedLogin);

        void getLogininfo(LoginResultBean loginResultBean);
    }

    interface Presenter extends BasePresenter<View> {
        void login(String username, String password);
    }
}