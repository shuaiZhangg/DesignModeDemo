package com.zhangshuai.designMode.listen.impl;

import com.zhangshuai.designMode.listen.ChangEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2023/6/26
 * @Description:
 * @Version: 1.0
 */
@Component
public class EmailServiceImpl {

    @Async
    @Order(10)
    @EventListener
    public void deal(ChangEvent event){
        String id = event.getId();
        System.out.println("处理业务 成功");
        System.out.println("发送邮件 成功");
    }
}
