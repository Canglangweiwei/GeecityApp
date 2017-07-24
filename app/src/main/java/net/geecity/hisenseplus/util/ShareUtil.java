package net.geecity.hisenseplus.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import net.geecity.hisenseplus.bean.UserBean;

@SuppressWarnings("ALL")
public class ShareUtil {

    public ShareUtil() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 保存在手机里面的文件名
     */
    public static final String FILE_NAME = "share_data";

    public static void saveLoginInfo(Context mContext, UserBean userBean) {
        SharedPreferences shared = mContext.getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putInt("id", userBean.getId());
        editor.putString("Account", userBean.getAccount());
        editor.putString("password", userBean.getPassword());
        editor.putInt("Types", userBean.getTypes());
        editor.putString("NAME", userBean.getNAME());
        editor.putString("NickName", userBean.getNickName());
        editor.putString("TEL", userBean.getTEL());
        editor.putString("R_id", userBean.getR_id());
        editor.putInt("U_id", userBean.getU_id());
        editor.putInt("AccountCount", userBean.getAccountCount());
        editor.putString("sex", userBean.getSex());
        editor.putString("Photo", userBean.getPhoto());
        editor.putString("gxqm", userBean.getSex());
        editor.putString("xqah", userBean.getXqah());
        editor.putString("qgzk", userBean.getQgzk());
        editor.putInt("jifen", userBean.getJifen());
        editor.commit();
    }

    /**
     * 获取登录信息
     */
    public static UserBean getLoginInfo(Context mContext) {
        SharedPreferences shared = mContext.getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        UserBean userBean = new UserBean();
        userBean.setId(shared.getInt("id", 0));
        userBean.setAccount(shared.getString("Account", ""));
        userBean.setPassword(shared.getString("password", ""));
        userBean.setTypes(shared.getInt("Types", 0));
        userBean.setNAME(shared.getString("NAME", ""));
        userBean.setNickName(shared.getString("NickName", ""));
        userBean.setTEL(shared.getString("TEL", ""));
        userBean.setR_id(shared.getString("R_id", ""));
        userBean.setU_id(shared.getInt("U_id", 0));
        userBean.setAccountCount(shared.getInt("AccountCount", 0));
        userBean.setSex(shared.getString("sex", ""));
        userBean.setPhoto(shared.getString("Photo", ""));
        userBean.setGxqm(shared.getString("gxqm", ""));
        userBean.setXqah(shared.getString("xqah", ""));
        userBean.setQgzk(shared.getString("qgzk", ""));
        userBean.setJifen(shared.getInt("jifen", 0));
        return userBean;
    }

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param context
     * @param key
     * @param object
     */
    public static void put(Context context, String key, Object object) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }
        editor.commit();
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param context
     * @param key
     * @param defaultObject
     * @return
     */
    public static Object get(Context context, String key, Object defaultObject) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }
        return null;
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param context
     * @param key
     */
    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
    }

    /**
     * 清除所有数据
     *
     * @param context
     */
    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    /**
     * 清空用户信息
     */
    public static void clearUserinfo(Context mContext) {
        SharedPreferences shared = mContext.getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.clear();
        editor.commit();
    }
}