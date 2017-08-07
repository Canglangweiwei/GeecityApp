package net.geecity.hisenseplus.api;

import net.geecity.hisenseplus.bean.LoginResultBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

@SuppressWarnings("ALL")
public interface ApiService {

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     */
    @FormUrlEncoded
    @POST("user/userLogin")
    Observable<LoginResultBean> userLogin(@Field("account") String username, @Field("password") String password);
}