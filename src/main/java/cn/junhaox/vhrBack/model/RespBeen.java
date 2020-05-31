package cn.junhaox.vhrBack.model;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/5/31 8:39
 */
public class RespBeen {
    private Integer status;
    private String msg;
    private Object data;

    private RespBeen() {}

    private RespBeen(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static RespBeen ok(String msg) {
        return new RespBeen(200, msg, null);
    }

    public static RespBeen ok(String msg, Object data) {
        return new RespBeen(200, msg, data);
    }

    public static RespBeen error(String msg) {
        return new RespBeen(500, msg, null);
    }

    public static RespBeen error(String msg, Object data) {
        return new RespBeen(500, msg, data);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
