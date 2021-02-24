package com.shangxin.demo.pojo;

public class Result {
    private boolean flag;
    private String describe;
    private Object result;

    public Result(boolean flag, String describe) {
        this.flag = flag;
        this.describe = describe;
    }

    public Result(boolean flag, String describe, Object result) {
        this.flag = flag;
        this.describe = describe;
        this.result = result;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
