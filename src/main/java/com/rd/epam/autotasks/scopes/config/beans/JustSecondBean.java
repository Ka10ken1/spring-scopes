package com.rd.epam.autotasks.scopes.config.beans;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Objects;
@Component
public class JustSecondBean {
    private int id;
    private Timestamp timestamp;

    public JustSecondBean(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JustSecondBean that = (JustSecondBean) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "JustSecondBean{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                '}';
    }
}
