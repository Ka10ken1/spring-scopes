package com.rd.epam.autotasks.scopes.config.thread;

import com.rd.epam.autotasks.scopes.config.beans.ThreadBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ThreadBeansConfig {

    @Scope(scopeName = "thread")
    @Bean("threadBean1")
    public Object getThreeTimesBean1() {
        ThreadBean bean = new ThreadBean("first");
        return bean;
    }

    @Scope(scopeName = "thread")
    @Bean("threadBean2")
    public Object getThreeTimesBean2() {
        ThreadBean bean = new ThreadBean("second");
        return bean;
    }
}