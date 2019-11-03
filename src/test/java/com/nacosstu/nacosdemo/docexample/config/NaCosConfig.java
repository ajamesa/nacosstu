package com.nacosstu.nacosdemo.docexample.config;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.Test;

import java.util.Properties;

/**
 * @author James Chen
 * @date 03/11/19
 */
public class NaCosConfig {

    @Test
    public void testConfig() {
        try {
            String serverAddr = "http://localhost:8848";
            String contextPath = "nacos";
            String dataId = "test";
            String group = "DEFAULT_GROUP";
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            properties.put("contextPath", contextPath);
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(dataId, group, 5000);
            System.out.println(content);
        } catch (NacosException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testPublishConfig() {
        try {
            String serverAddr = "http://localhost:8848";
            String contextPath = "nacos";
            String dataId = "test";
            String group = "DEFAULT_GROUP";
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            properties.put("contextPath", contextPath);
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = "xxxxyyyyyzzzzz aaaa bbbb cccc";
            boolean isPublishOk = configService.publishConfig(dataId, group, content);
            System.out.println(isPublishOk);
        } catch (NacosException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
