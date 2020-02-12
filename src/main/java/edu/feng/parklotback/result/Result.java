package edu.feng.parklotback.result;


// 主要是为了构造response 主要是响应码 Code应该是枚举值这里简化了
public class Result {
    //响应码
    private int code;

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}

