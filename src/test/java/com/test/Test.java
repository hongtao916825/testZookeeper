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

import com.zk.test.api.ZkConfig;
import com.zk.test.config.TestClient;
import com.zk.test.config.ZkConfigClient;


public class Test {

   public static void main(String[] args) throws Exception {
      ZkConfig zkConfig = new ZkConfig();
      zkConfig.setGroup("test1");
      zkConfig.setVersion("2.0");

      ZkConfigClient zkConfigClient = new ZkConfigClient(zkConfig);
      zkConfigClient.init();
      TestClient testClient = new TestClient();
      testClient.start();
      zkConfigClient.createListener();
   }
}
