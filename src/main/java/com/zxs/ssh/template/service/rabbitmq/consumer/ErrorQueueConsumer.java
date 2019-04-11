package com.zxs.ssh.template.service.rabbitmq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Project Name:spring-rabbitmq
 * File Name:ErrorQueueConsumer
 * Package Name:com.zxs.ssh.template.service.rabbitmq.consumer
 * Date:2019/4/11
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Service("errorQueueConsumer")
public class ErrorQueueConsumer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try{
            System.out.println("【ErrorQueueConsumer】"+new Timestamp(System.currentTimeMillis())+"    "+new String(message.getBody(),"utf-8"));
        }catch (Exception e){

        }
    }
}
