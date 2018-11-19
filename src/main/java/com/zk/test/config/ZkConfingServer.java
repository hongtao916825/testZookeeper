package com.zk.test.config;

import com.alibaba.fastjson.JSON;
import com.zk.test.api.Configration;
import com.zk.test.api.Contant;
import com.zk.test.curator.CuratorCrud;
import com.zk.test.api.ZkConfig;

/**
 * 模拟服务端
 */
public class ZkConfingServer extends CuratorCrud{

    private ZkConfig zkConfig;

    private Configration configration;

    public ZkConfingServer(ZkConfig zkConfig, Configration configration) {
        this.zkConfig = zkConfig;
        this.configration = configration;
    }

    public void setData(){
        if(!this.isExsit(Contant.NODE_PATH + zkConfig.getConfigPath())){
            this.createPersistent(Contant.NODE_PATH + zkConfig.getConfigPath(), JSON.toJSONString(configration));
        }else{
            this.setData(Contant.NODE_PATH + zkConfig.getConfigPath(), JSON.toJSONString(configration));
        }
    }

    public ZkConfig getZkConfig() {
        return zkConfig;
    }

    public void setZkConfig(ZkConfig zkConfig) {
        this.zkConfig = zkConfig;
    }



}
