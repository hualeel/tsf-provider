package com.hua.tsf_spring_cloud_demo.tsf_spring_cloud_provider.Controller;

import com.hua.tsf_spring_cloud_demo.tsf_spring_cloud_provider.Config.ProviderNameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
    private static final Logger LOG = LoggerFactory.getLogger(EchoController.class);

//    配置中心
    @Autowired
    private ProviderNameConfig providerNameConfig;

    @RequestMapping(value = "/echo/{param}", method = RequestMethod.GET)
    public String echo(@PathVariable String param) {
//         日志
        LOG.info("tsf-provider-demo -- request param: [" + param + "]");

//        取得application.yml中的值
        String result = "request param: " + param + ", response from " + providerNameConfig.getName();

        LOG.info("tsf-provider-demo -- provider config name: [" + providerNameConfig.getName() + ']');
        LOG.info("tsf-provider-demo -- response info: [" + result + "]");

        return result;
    }



}
