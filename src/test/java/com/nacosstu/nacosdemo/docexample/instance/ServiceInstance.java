package com.nacosstu.nacosdemo.docexample.instance;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.AbstractHealthChecker;
import com.alibaba.nacos.api.naming.pojo.Cluster;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.api.naming.pojo.Service;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author James Chen
 * @date 03/11/19
 */
public class ServiceInstance {

    private Properties properties = new Properties();

    @Before
    public void prepareData() {
        String serverAddr = "https://localhost:8888";
        String contextPath = "nacos";
        properties.put("serverAddr", serverAddr);
        properties.put("contextPath", contextPath);
    }

    @Test
    public void addInstance() throws NacosException {
        NamingService naming = NamingFactory.createNamingService(properties);
        naming.registerInstance("nacos.test.3", "11.11.11.11", 8888, "TEST1");

        Instance instance = new Instance();
        instance.setIp("55.55.55.55");
        instance.setPort(9999);
        instance.setHealthy(false);
        instance.setWeight(2.0);
        Map<String, String> instanceMeta = new HashMap<>();
        instanceMeta.put("site", "et2");
        instance.setMetadata(instanceMeta);

        Service service = new Service("nacos.test.4");
        service.setAppName("nacos-naming");
//        service.sethealthCheckMode("server");
//        service.setEnableHealthCheck(true);
        service.setProtectThreshold(0.8F);
        service.setGroupName("CNCF");
        Map<String, String> serviceMeta = new HashMap<>();
        serviceMeta.put("symmetricCall", "true");
        service.setMetadata(serviceMeta);
//        instance.setService(service);

        Cluster cluster = new Cluster();
        cluster.setName("TEST5");
        AbstractHealthChecker.Http healthChecker = new AbstractHealthChecker.Http();
        healthChecker.setExpectedResponseCode(400);
//        healthChecker.setCurlHost("USer-Agent|Nacos");
//        healthChecker.setCurlPath("/xxx.html");
        cluster.setHealthChecker(healthChecker);
        Map<String, String> clusterMeta = new HashMap<>();
        clusterMeta.put("xxx", "yyyy");
        cluster.setMetadata(clusterMeta);

//        instance.setCluster(cluster);
        naming.registerInstance("nacos.test.4", instance);
    }

    @Test
    public void testAllInstance() throws NacosException {
        NamingService naming = NamingFactory.createNamingService(properties);
        System.out.println(naming.getAllInstances("nacos.test.4"));
    }

    @Test
    public void testOneHealthInstance() throws NacosException {
        NamingService naming = NamingFactory.createNamingService(properties);
        System.out.println(naming.selectOneHealthyInstance("nacos.test.4"));

    }
}
