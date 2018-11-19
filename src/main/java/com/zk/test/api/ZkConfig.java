package com.zk.test.api;

/**
 * zNode封装
 */
public class ZkConfig {

    private String group;
    private String version;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getConfigPath(){

        return "/"+group+"/"+version;
    }

}
