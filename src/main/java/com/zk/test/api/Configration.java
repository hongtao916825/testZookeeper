package com.zk.test.api;

/**
 * 配置文件封装
 */
public class Configration {

    private String path;

    private String url;

    private String pwd;

    public Configration() {
    }

    public Configration(String path, String url, String pwd) {
        this.path = path;
        this.url = url;
        this.pwd = pwd;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
