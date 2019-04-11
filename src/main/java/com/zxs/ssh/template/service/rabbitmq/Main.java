package com.zxs.ssh.template.service.rabbitmq;

import com.zxs.ssh.template.service.rabbitmq.consumer.Consumer2_1;
import com.zxs.ssh.template.service.rabbitmq.consumer.Consumer2_2;
import com.zxs.ssh.template.service.rabbitmq.consumer.Consumer3_1;
import com.zxs.ssh.template.service.rabbitmq.consumer.Consumer3_2;
import com.zxs.ssh.template.service.rabbitmq.producer.Producer2_1;
import com.zxs.ssh.template.service.rabbitmq.producer.Producer3_1;

/**
 * Project Name:spring-rabbitmq
 * File Name:Main
 * Package Name:com.zxs.ssh.template.service.rabbitmq
 * Date:2019/4/11
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class Main {
    public static void main(String[] args) {
        Thread producer3_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Producer3_1.produce();
                }catch (Exception e){
                    System.out.println("1");
                }
            }
        });
        Thread consumer3_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Consumer3_1.consumer();
                }catch (Exception e){
                    System.out.println("2");
                }
            }
        });
        Thread consumer3_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Consumer3_2.consumer();
                }catch (Exception e){
                    System.out.println("3");
                }
            }
        });

        producer3_1.start();
        consumer3_1.start();
        consumer3_2.start();
    }
}
