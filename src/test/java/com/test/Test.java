package com.test;/* ━━━━━━如来保佑━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━永无BUG━━━━━━
 * 图灵学院-悟空老师
 * 以往视频加小乔老师QQ：895900009
 * 悟空老师QQ：245553999
 */

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
         try {
            System.out.println(JSON.toJSONString(Contant.configration));
            Thread.sleep(10 * 1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
