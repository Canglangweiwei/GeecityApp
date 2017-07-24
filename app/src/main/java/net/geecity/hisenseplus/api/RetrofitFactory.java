package net.geecity.hisenseplus.api;

import net.geecity.hisenseplus.bean.LoginResultBean;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * 网络请求管理工厂
 */
public class RetrofitFactory {

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    private static final Retrofit sRetrofit = new Retrofit.Builder()
            .baseUrl("http://app.hisenseplus.com:8100/appPhone/rest/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
            .client(okHttpClient)
            .build();

    private static final ApiService apiService = sRetrofit.create(ApiService.class);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     */
    public static Observable<LoginResultBean> userLogin(String username, String password) {
        return apiService.userLogin(username, password);
    }
}