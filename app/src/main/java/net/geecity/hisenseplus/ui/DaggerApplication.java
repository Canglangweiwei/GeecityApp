package net.geecity.hisenseplus.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import net.geecity.hisenseplus.app.AppComponent;
import net.geecity.hisenseplus.app.AppModule;
import net.geecity.hisenseplus.app.DaggerAppComponent;
import net.geecity.hisenseplus.bean.AreaInfoBean;
import net.geecity.hisenseplus.bean.LoginBean;
import net.geecity.hisenseplus.config.Constants;
import net.geecity.hisenseplus.util.LogUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


@SuppressWarnings("ALL")
public class DaggerApplication extends Application {

    private AppComponent appComponent;

    public static DaggerApplication get(Context context) {
        return (DaggerApplication) context.getApplicationContext();
    }

    private Stack<Activity> activityStack;// activity栈

    private boolean isBind;// 是否绑定了房源
    private LoginBean loginBean;// 登录信息
    private List<AreaInfoBean> areaInfos;// 小区信息
    private AreaInfoBean defaultAreaInfo;// 默认小区信息

    @Override
    public void onCreate() {
        super.onCreate();
        setApplicationComponent();
        LogUtil.logInit(Constants.LOG_DEBUG);
    }

    private void setApplicationComponent() {
        // Dagger开头的注入类DaggerAppComponent
        appComponent = DaggerAppComponent.builder()
                // 此时appModule方法是过时方法，因为我们没有使用到任何一个module中提供的对象
                .appModule(new AppModule(this))
                .build();
    }

    /**
     * 获取AppComponent
     */
    public AppComponent component() {
        if (appComponent == null) {
            setApplicationComponent();
        }
        return appComponent;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public List<AreaInfoBean> getAreaInfos() {
        return areaInfos;
    }

    /**
     * 应将数据存入数据库，即使更新和为空时重新读取
     *
     * @param areaInfos
     */
    public void setAreaInfos(List<AreaInfoBean> areaInfos) {
        this.areaInfos = areaInfos;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
        setAreaInfos(loginBean.getArea());
        for (AreaInfoBean aInfo : this.areaInfos) {
            if (aInfo.getIsDefault() == 1) {
                setDefaultAreaInfo(aInfo);
            }
        }
    }

    /**
     * 获取默认房间
     **/
    public AreaInfoBean getDefaultAreaInfo() {
        return defaultAreaInfo;
    }

    /**
     * 设置默认房间
     */
    public void setDefaultAreaInfo(AreaInfoBean defaultAreaInfo) {
        this.defaultAreaInfo = defaultAreaInfo;
        if (areaInfos == null || areaInfos.size() == 0) {
            areaInfos = new LinkedList<AreaInfoBean>();
            areaInfos.add(defaultAreaInfo);
        }
        if (loginBean == null) {
            loginBean = new LoginBean();
        }
        loginBean.setArea(areaInfos);
    }

    /**
     * 是否绑定了房源
     */
    public boolean isBind() {
        isBind = false;
        AreaInfoBean houseBean = getBindHouse();
        // 获取绑定的房间编号，如果没有，表示未绑定
        isBind = (houseBean != null);
        return isBind;
    }

    /**
     * 获取绑定的房间信息
     */
    private AreaInfoBean getBindHouse() {
        if (loginBean != null) {
            List<AreaInfoBean> aBeans = loginBean.getArea();
            for (AreaInfoBean aBean : aBeans) {
                if (aBean.getIsDefault() == 1) {
                    return aBean;
                }
            }
        }
        return null;
    }

    public void setBind(boolean isBind) {
        this.isBind = isBind;
    }

    /**
     * 把一个activity压入栈列中
     *
     * @param actvity
     */
    public void pushActivityToStack(Activity actvity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(actvity);
    }

    /**
     * 获取栈顶的activity，先进后出原则
     */
    public Activity getLastActivityFromStack() {
        return activityStack.lastElement();
    }

    /**
     * 从栈列中移除一个activity
     *
     * @param activity
     */
    public void popActivityFromStack(Activity activity) {
        if (activityStack != null && activityStack.size() > 0) {
            if (activity != null) {
                activity.finish();
                activityStack.remove(activity);
                activity = null;
            }
        }
    }

    /**
     * 退出所有activity
     */
    public void finishAllActivity() {
        if (activityStack != null) {
            while (activityStack.size() > 0) {
                Activity activity = getLastActivityFromStack();
                if (activity == null) {
                    break;
                }
                popActivityFromStack(activity);
            }
        }
    }
}
