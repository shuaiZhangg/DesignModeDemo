package com.zhangshuai.designMode.listen;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2023/6/26
 * @Description:
 * @Version: 1.0
 */
public class ChangEvent extends ApplicationEvent {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChangEvent(Object source,String id) {
        super(source);
        this.id = id;
    }
}
