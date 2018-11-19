package com.zk.test.curator;/* ━━━━━━如来保佑━━━━━━
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

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

public class CuratorCrud {
   private final String connectString = "localhost:2181,localhost:2182,localhost:2183";
   CuratorFramework cf ;
   public CuratorCrud() {
      //1 重试策略：初试时间为1s 重试10次
      RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
      //2 通过工厂创建连接
      cf = CuratorFrameworkFactory.builder()
              .connectString(connectString)
              .sessionTimeoutMs(500)
              .retryPolicy(retryPolicy)
//					.namespace("super")
              .build();
      //3 开启连接
      cf.start();
   }

   public void createWatcher(String path, Watcher watcher){
      try {
         cf.getData().usingWatcher(watcher).forPath(path);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public boolean isExsit(String path){
      try {
         Stat stat = cf.checkExists().forPath(path);
         return stat != null;
      } catch (Exception e) {
         e.printStackTrace();
      }
      return  false;
   }

   public String createPersistent(String path,String  data){
      try {
         cf.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path,data.getBytes());
      } catch (Exception e) {
         e.printStackTrace();
      }

      return  null;
   }

   public String getData(String path){
      try {
         return new String(cf.getData().forPath(path));
      } catch (Exception e) {
         e.printStackTrace();
      }
      return  null;
   }


   public void delete(String path){
      try {
         cf.delete().guaranteed().deletingChildrenIfNeeded().forPath(path);
      } catch (Exception e) {
         e.printStackTrace();
      }

   }


   public CuratorFramework getCf() {
      return cf;
   }

   public void setCf(CuratorFramework cf) {
      this.cf = cf;
   }

   public void setData(String path, String  data){
      try {
         cf.setData().forPath(path,data.getBytes());
      } catch (Exception e) {
         e.printStackTrace();
      }
   }



}
