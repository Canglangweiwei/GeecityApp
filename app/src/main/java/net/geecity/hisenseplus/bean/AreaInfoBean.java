package net.geecity.hisenseplus.bean;

import java.io.Serializable;

/**
 * <p>
 * 功能说明：小区信息
 * </p>
 * Created by weiwei On 2016-9-18 下午4:14:45
 */
@SuppressWarnings("ALL")
public class AreaInfoBean implements Serializable {

    private static final long serialVersionUID = 986412624005677456L;
    private String A_id;// 小区id
    private String A_name;// 小区名称
    private String findShow;// 判断是否显示发现 - 发布模块儿
    private String doorshow;// 判断是否显示蓝牙开门
    private int isDefault;// 1-是默认房间，0-不是

    public AreaInfoBean() {
        super();
    }

    public String getA_id() {
        return A_id;
    }

    public void setA_id(String a_id) {
        A_id = a_id;
    }

    public String getA_name() {
        return A_name;
    }

    public void setA_name(String a_name) {
        A_name = a_name;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public String getFindShow() {
        return findShow;
    }

    public void setFindShow(String findShow) {
        this.findShow = findShow;
    }

    public String getDoorshow() {
        return doorshow;
    }

    public void setDoorshow(String doorshow) {
        this.doorshow = doorshow;
    }
}
