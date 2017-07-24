package net.geecity.hisenseplus.bean;

/**
 * <p>
 * 功能说明：基类
 * </p>
 * Created by weiwei On 2016-1-18 上午11:02:04
 */
@SuppressWarnings("ALL")
public class BaseBean {

    private String result;
    private String errorCode;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
