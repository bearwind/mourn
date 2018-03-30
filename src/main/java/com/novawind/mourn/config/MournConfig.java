package com.novawind.mourn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Jeremy Xiong<br>
 * 2018-02-09 15:10
 */
@Component
@ConfigurationProperties(prefix = "mourn.config")
public class MournConfig {

    private int autoLoginKeepDays;

    public int getAutoLoginKeepDays () {
        return autoLoginKeepDays;
    }
    public void setAutoLoginKeepDays (int autoLoginKeepDays) {
        this.autoLoginKeepDays = autoLoginKeepDays;
    }
}
