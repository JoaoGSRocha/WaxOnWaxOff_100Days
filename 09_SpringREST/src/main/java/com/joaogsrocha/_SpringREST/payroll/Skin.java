package com.joaogsrocha._SpringREST.payroll;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
class Skin {
    private @Id @GeneratedValue Long id;
    private String name;
    private String condition;

    Skin() {}

    Skin(String name, String condition) {
        this.name = name;
        this.condition = condition;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String role) {
        this.condition = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skin skin = (Skin) o;
        return Objects.equals(id, skin.id) &&
                Objects.equals(name, skin.name) &&
                Objects.equals(condition, skin.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, condition);
    }

    @Override
    public String toString() {
        return "Skin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", condition='" + condition + '\'' +
                "} \n";
    }
}
