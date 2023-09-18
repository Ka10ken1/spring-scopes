package com.rd.epam.autotasks.scopes.config.justasecond;

import com.rd.epam.autotasks.scopes.config.beans.JustSecondBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JustSecondBeansConfig {
    @Scope(scopeName = "justASecond")
    @Bean("jasBean1")
    public Object getJustSecondBean1() {
        JustSecondBean bean = new JustSecondBean(1);
        return bean;
    }

    @Scope(scopeName = "justASecond")
    @Bean("jasBean2")
    public Object getJustSecondBean2() {
        JustSecondBean bean = new JustSecondBean(2);
        return bean;
    }
}