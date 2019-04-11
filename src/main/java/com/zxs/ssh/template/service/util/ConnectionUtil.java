package com.zxs.ssh.template.service.util;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

/**
 * Project Name:spring-rabbitmq
 * File Name:ConnectionUtil
 * Package Name:com.zxs.ssh.template.service.util
 * Date:2019/4/11
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class ConnectionUtil {
    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("132.232.90.79");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost("testhost");
        factory.setUsername("zengxueshan");
        factory.setPassword("123456");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}
