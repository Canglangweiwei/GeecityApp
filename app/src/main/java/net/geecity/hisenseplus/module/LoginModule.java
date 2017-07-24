package net.geecity.hisenseplus.module;

import net.geecity.hisenseplus.contract.LoginContract;
import net.geecity.hisenseplus.util.Validator;

import dagger.Module;
import dagger.Provides;

@SuppressWarnings("ALL")
@Module
public class LoginModule {

    private final LoginContract.View view;
    private Validator validator;

    /**
     * 构造器
     *
     * @param view      页面
     * @param validator 账户、密码验证工具
     */
    public LoginModule(LoginContract.View view, Validator validator) {
        this.view = view;
        this.validator = validator;
    }

    /**
     * 在@Module注解的类中，使用@Provider注解，说明提供依赖注入的具体对象
     */
    @Provides
    public Validator provideValidator() {
        return validator;
    }
}
