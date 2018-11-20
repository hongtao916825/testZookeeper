package com.test;

import com.alibaba.fastjson.JSON;
import com.zk.test.api.Configration;
import com.zk.test.api.Contant;
import com.zk.test.api.ZkConfig;
import com.zk.test.config.ZkConfigClient;
import com.zk.test.config.ZkConfingServer;


public class Test {

   public static void main(String[] args) throws Exception {
      ZkConfig zkConfig = new ZkConfig();
      zkConfig.setGroup("test1");
      zkConfig.setVersion("2.0");

      Configration configration = new Configration("test","testUrl","aa123456");
      ZkConfingServer server = new ZkConfingServer(zkConfig,configration);
      server.setData();

      ZkConfigClient zkConfigClient = new ZkConfigClient(zkConfig);
      zkConfigClient.init();
      zkConfigClient.createListener();
      while (true) {
         System.out.println(JSON.toJSONString(Contant.configration));
         Thread.sleep(10 * 1000);
      }
   }
}
