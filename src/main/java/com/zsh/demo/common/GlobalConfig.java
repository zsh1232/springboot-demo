package com.zsh.demo.common;

import org.springframework.stereotype.Component;

@Component
public class GlobalConfig {

    public interface kafka {
        int SEND_WAIT_TIME = 1000;  //ms
    }
}
