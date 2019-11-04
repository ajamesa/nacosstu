package com.nacosstu.nacosdemo.docexample.config;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

/**
 * @author James Chen
 * @date 03/11/19
 */
public class NaCosConfig {

    private Properties properties = new Properties();

    @Before
    public void prepareData() {
        String serverAddr = "https://localhost:8888";
        String contextPath = "nacos";
        properties.put("serverAddr", serverAddr);
        properties.put("contextPath", contextPath);
    }

    @Test
    public void testConfig() {
        try {
            String dataId = "test";
            String group = "DEFAULT_GROUP";
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
//            String dataId = "test";
            String dataId = "test1";
            String group = "DEFAULT_GROUP";
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = "xxxxyyyyyzzzzz aaaa bbbb cccc 123";
            boolean isPublishOk = configService.publishConfig(dataId, group, content);
            System.out.println(isPublishOk);
        } catch (NacosException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
