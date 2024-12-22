package net.xdclass.xdclasssp.mq;

import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Component
//@RabbitListener(queues = "order_queue")
public class OrderMQListener {


    //消息监听，消息消费
//    @RabbitHandler
    public void messageHandler(String body, Message message) {
        long msgTag = message.getMessageProperties().getDeliveryTag();
        System.out.println("msgTag=" + msgTag);
        System.out.println("message=" + message.toString());
        System.out.println("body=" + body);

    }

}
