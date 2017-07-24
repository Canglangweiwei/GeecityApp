package net.geecity.hisenseplus.bean;

import java.util.List;

/**
 * <p>
 * 功能说明：登陆信息
 * </p>
 * Created by weiwei On 2016-9-18 下午4:14:16
 */
@SuppressWarnings("ALL")
public class LoginBean {

    private UserBean user;
    private List<AreaInfoBean> area;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<AreaInfoBean> getArea() {
        return area;
    }

    public void setArea(List<AreaInfoBean> area) {
        this.area = area;
    }
}
