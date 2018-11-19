package com.test;

import com.zk.test.api.Configration;
import com.zk.test.api.ZkConfig;
import com.zk.test.config.ZkConfingServer;

public class TestServer {


    public static void main(String[] args){
        ZkConfig zkConfig = new ZkConfig();
        zkConfig.setGroup("test1");
        zkConfig.setVersion("2.0");
        Configration configration = new Configration("test","testUrl","aa123456");
        ZkConfingServer server = new ZkConfingServer(zkConfig,configration);
        server.setData();
    }


}
