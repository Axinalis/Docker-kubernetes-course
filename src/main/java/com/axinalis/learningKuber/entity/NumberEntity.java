package com.axinalis.learningKuber.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "numbers")
public class NumberEntity {

    private Long id;
    private Long value;

    public NumberEntity() {
    }

    public NumberEntity(Long id, Long value) {
        this.id = id;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberEntity that = (NumberEntity) o;
        return Objects.equals(id, that.id) && value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
