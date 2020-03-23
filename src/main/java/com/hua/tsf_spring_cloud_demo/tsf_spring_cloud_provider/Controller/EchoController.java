package com.hua.tsf_spring_cloud_demo.tsf_spring_cloud_provider.Controller;

import com.hua.tsf_spring_cloud_demo.tsf_spring_cloud_provider.Config.GlobalConfig;
import com.hua.tsf_spring_cloud_demo.tsf_spring_cloud_provider.Config.ProviderNameConfig;

import com.hua.tsf_spring_cloud_demo.tsf_spring_cloud_provider.Entity.CustomMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.tsf.core.TsfContext;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


//API上报
import io.swagger.annotations.ApiOperation;

@RestController
public class EchoController {
    private static final Logger LOG = LoggerFactory.getLogger(EchoController.class);

    // 配置中心:provider.config.name
    @Autowired
    private ProviderNameConfig providerNameConfig;

    // 配置中心:global.config.name
    @Autowired
    private GlobalConfig globalConfig;

    // notes 对应 API 描述
    @ApiOperation(value = "/echo/{param}", notes = "provide微服务回显字符串", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/echo/{param}", method = RequestMethod.GET)
    public String echo(@PathVariable String param,@RequestParam(required = false) String tagName,
                       @RequestParam(required = false) String tagValue,
                       @RequestParam(required = false) String consumer_config_value,
                       @RequestParam(required = false) String global_config_value) {
        // 通过url传参设置自定义标签
        if (!StringUtils.isEmpty(tagName)) {
            TsfContext.putTag(tagName, tagValue);
            TsfContext.putCustomMetadata(new CustomMetadata(tagName,tagValue));
        }

//         日志
        LOG.info("tsf-provider-demo -- request param: [" + param + "]");

//        取得application.yml中的值
        String result = "Provider Version: 2.0" + "<br>"
                + "Request param:" + param + "<br>"
                + "Provider.config.name:" + providerNameConfig.getName() + "<br>"
                + "Global.config.name:" + globalConfig.getName();

        LOG.info("tsf-provider -- provider config name: [" + providerNameConfig.getName() + ']');
        LOG.info("tsf-provider -- global config name: [" + globalConfig.getName() + ']');
        LOG.info("tsf-provider-demo -- response info: [" + result + "]");

        return result;
    }


}
