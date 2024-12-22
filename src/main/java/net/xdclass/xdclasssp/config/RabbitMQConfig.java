package net.xdclass.xdclasssp.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Configuration
public class RabbitMQConfig {
    //延迟消息队列实战

    /*
    死信队列
     */
    public static final String DEAD_QUEUE = "lock_merchant_dead_queue";
    /*
    死信队列交换机
     */
    public static final String DEAD_EXCHANGE_NAME = "dead_exchange";
    /*
     * 死信队列路由器
     */
    public static final String ROUTING_KEY = "lock_merchant_dead_routing_key";
    // 定义一个普通队列，普通交换机
    public static final String NORMAL_EXCHANGE_NAME = "normal_exchange";
    public static final String NORMAL_QUEUE = "normal_queue";
    public static final String NORMAL_ROUTING_KEY = "normal.#";

    /*
    创建死信交换机
     */
    @Bean
    public Exchange deadExchange() {
        return new TopicExchange(DEAD_EXCHANGE_NAME, true, false);
    }

    /*
    创建死信队列
     */
    @Bean
    public Queue deadQueue() {
        return QueueBuilder.durable(DEAD_QUEUE).build();
    }

    /*
    绑定死信交换机跟死信队列（根据routingkey可以绑定）
     */
    @Bean
    public Binding deadBinding() {
        return new Binding(DEAD_QUEUE, Binding.DestinationType.QUEUE, DEAD_EXCHANGE_NAME, ROUTING_KEY, null);
    }

    /*
    创建普通交换机
     */
    @Bean
    public Exchange normalExchange() {
        return ExchangeBuilder.topicExchange(NORMAL_EXCHANGE_NAME).durable(true).build();
    }

    /*
    创建普通队列
     */
    @Bean
    public Queue normalQueue() {

        HashMap<String, Object> stringObjectHashMap = new HashMap<>(3);
        //消息过期后，进入死信交换机
        stringObjectHashMap.put("x-dead-letter-exchange", DEAD_EXCHANGE_NAME);
        //消息过期后，进去死信交换机的路由key
        stringObjectHashMap.put("x-dead-letter-routing-key", ROUTING_KEY);
        //设置过期时间，单位毫秒
        stringObjectHashMap.put("x-message-ttl", 10000);

        return QueueBuilder.durable(NORMAL_QUEUE).withArguments(stringObjectHashMap).build();
    }

    /*
    绑定普通队列跟交换机
     */
    @Bean
    public Binding normalBinding() {
        return new Binding(NORMAL_QUEUE, Binding.DestinationType.QUEUE, NORMAL_EXCHANGE_NAME, NORMAL_ROUTING_KEY, null);
    }

//    public static final String EXCHANGE_NAME = "order_exchange";
//
//    public static final String QUEUE = "order_queue";
//
//
//    /**
//     * topic 交换机
//     * @return
//     */
//    @Bean
//    public Exchange orderExchange(){
//        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
//    }
//
//
//    /**
//     * 队列
//     * @return
//     */
//    @Bean
//    public Queue orderQueue(){
//        return QueueBuilder.durable(QUEUE).build();
//    }
//
//
//    /**
//     * 交换机和队列绑定关系
//     */
//    @Bean
//    public Binding orderBinding(Queue queue, Exchange exchange){
//        return BindingBuilder.bind(queue).to(exchange).with("order.#").noargs();
//    }

}
