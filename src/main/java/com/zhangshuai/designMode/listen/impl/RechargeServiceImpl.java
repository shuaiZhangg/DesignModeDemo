package com.zhangshuai.designMode.listen.impl;

import com.zhangshuai.designMode.listen.ChangEvent;
import com.zhangshuai.designMode.listen.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2023/6/26
 * @Description:
 * @Version: 1.0
 */
@Service
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void recharge(String giftActivityId) {
        applicationContext.publishEvent(new ChangEvent(this, giftActivityId));
    }
}
