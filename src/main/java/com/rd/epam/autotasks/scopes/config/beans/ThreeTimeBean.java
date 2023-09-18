package com.rd.epam.autotasks.scopes.config.beans;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ThreeTimeBean {
    private long id;
    private String name;

    public ThreeTimeBean(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        ThreeTimeBean employee = (ThreeTimeBean) o;
        return id == employee.id &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ThreeTimeBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}