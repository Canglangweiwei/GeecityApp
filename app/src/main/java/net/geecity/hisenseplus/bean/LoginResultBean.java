package net.geecity.hisenseplus.bean;

/**
 * 
 * <p>
 * 功能说明：登陆信息
 * </p>
 * 
 * Created by weiwei On 2016-9-18 下午4:26:38
 */
public class LoginResultBean extends BaseBean {

    private LoginBean data;// 登陆信息

    public LoginBean getData() {
        return data;
    }

    public void setData(LoginBean data) {
        this.data = data;
    }
}
