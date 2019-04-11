package com.zxs.ssh.template.service.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zxs.ssh.template.service.util.ConnectionUtil;

/**
 * Project Name:spring-rabbitmq
 * File Name:Producer2_1
 * Package Name:com.zxs.ssh.template.service.rabbitmq.producer
 * Date:2019/4/11
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class Producer2_1 {
    private final static String QUEUE_NAME = "test_queue_work";

    public static void produce() throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        for (int i = 0; i < 100; i++) {
            // 消息内容
            String message = "" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            //System.out.println(" [x] Sent '" + message + "'");

            Thread.sleep(10);
        }

        channel.close();
        connection.close();
    }
}
