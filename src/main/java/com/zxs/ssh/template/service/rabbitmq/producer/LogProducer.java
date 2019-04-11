package com.zxs.ssh.template.service.rabbitmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project Name:spring-rabbitmq
 * File Name:LogProducer
 * Package Name:com.zxs.ssh.template.service.rabbitmq.producer
 * Date:2019/4/11
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Service("logProducer")
public class LogProducer {
    private static final Logger logger = LoggerFactory.getLogger(LogProducer.class);

    @Resource(name = "template")
    private AmqpTemplate template;

    @Value("${rabbit.error.queue}")
    private String errorQueueKey;

    @Value("${rabbit.warn.queue}")
    private String warnQueueKey;

    @Value("${rabbit.info.queue}")
    private String infoQueueKey;

    public void sendError(String message) {
        try {
            this.template.send(errorQueueKey, MessageBuilder.withBody(message.getBytes("utf-8")).build());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
    public void sendWarn(String message) {
        try {
            this.template.send(warnQueueKey, MessageBuilder.withBody(message.getBytes("utf-8")).build());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
    public void sendInfo(String message) {
        try {
            this.template.send(infoQueueKey, MessageBuilder.withBody(message.getBytes("utf-8")).build());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
