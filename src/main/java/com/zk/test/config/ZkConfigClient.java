package com.zk.test.config;

import com.alibaba.fastjson.JSON;
import com.zk.test.api.Configration;
import com.zk.test.api.Contant;
import com.zk.test.curator.CuratorCrud;
import com.zk.test.api.ZkConfig;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 客户端同步配置文件
 */
public class ZkConfigClient extends CuratorCrud {

    private ZkConfig zkConfig;

    public void init(){
        Contant.configration = JSON.parseObject(this.getData(Contant.NODE_PATH + zkConfig.getConfigPath()), Configration.class);
    }

    public ZkConfigClient(ZkConfig zkConfig) {
        this.zkConfig = zkConfig;
    }

    public ZkConfig getZkConfig() {
        return zkConfig;
    }

    public void setZkConfig(ZkConfig zkConfig) {
        this.zkConfig = zkConfig;
    }

    public void createListener() throws Exception {

        /**
         * 在注册监听器的时候，如果传入此参数，当事件触发时，逻辑由线程池处理
         */
        /**
         * 监听数据节点的变化情况
         */
        String path = Contant.NODE_PATH + zkConfig.getConfigPath();
        final NodeCache nodeCache = new NodeCache(this.getCf(), path);
        nodeCache.getListenable().addListener(
                new NodeCacheListener() {
                    @Override
                    public void nodeChanged() throws Exception {
                        Contant.configration = JSON.parseObject(new String(nodeCache.getCurrentData().getData()),Configration.class);
                        System.out.println("Node data is changed, new data: " +
                                new String(nodeCache.getCurrentData().getData()));
                    }
                }
        );
        nodeCache.start(true);
    }

}
