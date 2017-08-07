package net.geecity.hisenseplus.bean;

/**
 * <p>
 * 功能说明：用户信息
 * </p>
 * <p>
 * Created by weiwei On 2016-9-18 下午4:13:56
 */
@SuppressWarnings("ALL")
public class UserBean {

    private int id;// 会员Id
    private String Account;// 手机号
    private String password;
    private int Types;
    private String NAME;
    private String NickName;
    private String TEL;
    private String R_id;
    private int U_id;
    private int AccountCount;
    private String sex;
    private String Photo;
    private String gxqm;// 个性签名
    private String xqah;
    private String qgzk;
    private int jifen;// 积分

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJifen() {
        return jifen;
    }

    public void setJifen(int jifen) {
        this.jifen = jifen;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTypes() {
        return Types;
    }

    public void setTypes(int types) {
        Types = types;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String nAME) {
        NAME = nAME;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String tEL) {
        TEL = tEL;
    }

    public String getR_id() {
        return R_id;
    }

    public void setR_id(String r_id) {
        R_id = r_id;
    }

    public int getU_id() {
        return U_id;
    }

    public void setU_id(int u_id) {
        U_id = u_id;
    }

    public int getAccountCount() {
        return AccountCount;
    }

    public void setAccountCount(int accountCount) {
        AccountCount = accountCount;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getGxqm() {
        return gxqm;
    }

    public void setGxqm(String gxqm) {
        this.gxqm = gxqm;
    }

    public String getXqah() {
        return xqah;
    }

    public void setXqah(String xqah) {
        this.xqah = xqah;
    }

    public String getQgzk() {
        return qgzk;
    }

    public void setQgzk(String qgzk) {
        this.qgzk = qgzk;
    }
}
