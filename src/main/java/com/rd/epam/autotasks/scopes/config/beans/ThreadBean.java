package com.rd.epam.autotasks.scopes.config.beans;

import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class ThreadBean {
    private String name;

    public ThreadBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreadBean that = (ThreadBean) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ThreadBean{" +
                "name='" + name + '\'' +
                '}';
    }
}