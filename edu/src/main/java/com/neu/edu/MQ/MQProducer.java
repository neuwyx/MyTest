package com.neu.edu.MQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public class MQProducer {
    public final static String QUEUE_NAME="rabbitMQ.test";

    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        // factory.setUsername("lp");
        // factory.setPassword("");
        // factory.setPort(2088);
        // 创建一个新的连接
        Connection connection = factory.newConnection();


        //创建一个通道
        Channel channel = connection.createChannel();
        //  声明一个队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "Hello RabbitMQ";

        // basicPublish第一个参数为交换机名称、第二个参数为队列映射的路由key、
        // 第三个参数为消息的其他属性、第四个参数为发送信息的主体
        int count = 0;
        while (true) {
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println("Producer Send +'" + message + "'");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (++count == 1000) {
                break;
            }
        }
        // channel.close();
        // connection.close();

    }
}
