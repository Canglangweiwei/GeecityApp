package net.geecity.hisenseplus.api;

import net.geecity.hisenseplus.bean.LoginResultBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

@SuppressWarnings("ALL")
public interface ApiService {

    @FormUrlEncoded
    @POST("user/userLogin")
    Observable<LoginResultBean> userLogin(@Field("account") String username, @Field("password") String password);
}