package net.geecity.hisenseplus.store;

import net.geecity.hisenseplus.api.RetrofitFactory;
import net.geecity.hisenseplus.bean.LoginResultBean;

import javax.inject.Inject;

import rx.Observable;

/**
 * 数据请求管理仓库
 */
@SuppressWarnings("ALL")
public class LoginStore {

    @Inject
    public LoginStore() {
        super();
    }

    /**
     * 获取最新新闻列表
     */
    public Observable<LoginResultBean> userLogin(String username, String password) {
        return RetrofitFactory.userLogin(username, password);
    }
}













