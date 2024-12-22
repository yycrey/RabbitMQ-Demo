package net.xdclass.xdclasssp.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author yeyc
 * @Description 描述类的作用
 * @Date 2024/12/9
 * @Param
 * @Exception
 **/
@Component
@RabbitListener(queues = "lock_merchant_dead_queue")
public class MerchantMQListener {


    @RabbitHandler
    public void messageHandler(String body, Message message, Channel channel) throws IOException {
        System.out.println("body=" + body);
        System.out.println("body=" + message.getBody());
        long msgTag = message.getMessageProperties().getDeliveryTag();
        // TODO ... 其他业务逻辑
        //告诉客户端，消息已确认
        channel.basicAck(msgTag, false);
    }
}
