package net.geecity.hisenseplus.component;

import net.geecity.hisenseplus.app.AppComponent;
import net.geecity.hisenseplus.ui.LoginActivity;
import net.geecity.hisenseplus.module.LoginModule;
import net.geecity.hisenseplus.ui.WelcomeActivity;

import dagger.Component;

/**
 * 简单说就是，可以通过Component访问到Module中提供的依赖注入对象。
 * 假设，如果有两个Module，AModule、BModule，
 * 如果Component只注册了AModule，而没有注册BModule，那么BModule中提供的对象，无法进行依赖注入！
 */
@SuppressWarnings("ALL")
@Component(dependencies = AppComponent.class, modules = {LoginModule.class})
public interface LoginPresenterComponent {

    /**
     * <p>
     * 可以注册多个页面
     * </p>
     * 登录页面
     */
    void inject(LoginActivity loginActivity);

    void inject(WelcomeActivity welcomeActivity);
}
