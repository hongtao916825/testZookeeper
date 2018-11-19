package com.zk.test.config;

import com.alibaba.fastjson.JSON;
import com.zk.test.api.Contant;

/**
 * 客户端封装
 */
public class TestClient extends Thread{

    @Override
    public void run() {
        super.run();
        TestClient.outPut();
    }

    public static void outPut() {
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
