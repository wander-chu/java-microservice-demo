package com.demo.democonsumer.client;

import com.demo.democonsumer.client.config.MyFeignConfig;
import com.demo.democonsumer.client.fallback.InfoFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * FeignClient 配置说明
 * 1.name：被调用的服务应用名称
 * 2.fallback： InfoFallBack作为熔断实现，当请求provider失败时调用其中的方法
 * 3.configuration： feign配置
 */
@FeignClient(name = "provider", fallback = InfoFallBack.class, configuration = MyFeignConfig.class)
public interface InfoClient {

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    String getDefaultInfo();

    @RequestMapping(value = "/info/{name}", method = RequestMethod.POST)
    String getInfo(@PathVariable("name") String name);

}
