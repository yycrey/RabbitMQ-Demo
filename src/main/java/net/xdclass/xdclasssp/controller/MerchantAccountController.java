package net.xdclass.xdclasssp.controller;

import net.xdclass.xdclasssp.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author yeyc
 * @Description 描述类的作用
 * @Date 2024/12/9
 * @Param
 * @Exception
 **/
@RestController
@RequestMapping("/api/v1/merchant_account")
public class MerchantAccountController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/merchant")
    public Object merchantAccount() {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        rabbitTemplate.convertAndSend(RabbitMQConfig.NORMAL_EXCHANGE_NAME
                , RabbitMQConfig.NORMAL_ROUTING_KEY, "商家的账号已经通过了审核");
        stringObjectHashMap.put("code", 200);
        stringObjectHashMap.put("msg", "ok");
        return stringObjectHashMap;
    }

}
