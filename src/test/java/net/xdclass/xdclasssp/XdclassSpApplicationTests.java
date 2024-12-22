package net.xdclass.xdclasssp;

import net.xdclass.xdclasssp.config.RabbitMQConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XdclassSpApplicationTests {

	@Autowired
	private RabbitTemplate template;

//	@Test
//	void testSend() {
//		for(int i=0;i<5;i++){
//				template.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "order.new","新订单");
//		}
//	}
//
//	@Test
//	void testConfirmCallback(){
//		template.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
//			@Override
//			public void confirm(CorrelationData correlationData, boolean ack, String s) {
//				System.out.println("correlationData:"+correlationData);
//				System.out.println("ack"+ack);
//				System.out.println("s"+s);
//				if(ack){
//					System.out.println("消息发送成功");
//					// 业务需求 保存数据OR其他业务 TODO...
//				}else{
//					System.out.println("消息发送失败");
//					// 业务需求 保存错误信息 TODO ...
//				}
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					throw new RuntimeException(e);
//				}
//			}
//		});
//		//记录消息发送数据 TODO ...
//
//		template.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "order.new","新订单2333");
//	}
//
//	/**
//	 * @Description: 开启消息二次确认，交换机到队列的可靠性投递
//	 * @Param: []
//	 * @Return: void
//	 * @Author: yeyc
//	 * @Date: 2024/12/9
//	 */
//	@Test
//	public void  returnTrue(){
//		template.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
//			@Override
//			public void returnedMessage(ReturnedMessage returnedMessage) {
//				int code =	returnedMessage.getReplyCode();
//				String message =returnedMessage.getMessage().toString();
//				String exchange =returnedMessage.getExchange();
//				System.out.println("code>>>>>>>>>>>"+code);
//				System.out.println("message>>>>>>>>>>>"+message);
//				System.out.println("exchange>>>>>>>>>>>"+exchange);
//			}
//
//		});
//		template.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "sdclass.order.newbkl","新订单returncallback");
//	}
}
