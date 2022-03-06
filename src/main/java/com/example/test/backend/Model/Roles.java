package com.example.test.backend.Model;

import javax.persistence.*;

@Entity
@Table(name="Roles", schema = "liquibase")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    private String role_name;

    //constructor

    public Roles(){}

    public Roles(Long role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    private Roles(Builder builder) {
        setRole_id(builder.role_id);
        setRole_name(builder.role_name);
    }

    //GET&SET

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    //builder

    public static final class Builder {
        private Long role_id;
        private String role_name;

        public Builder() {
        }

        public Builder role_id(Long val) {
            role_id = val;
            return this;
        }

        public Builder role_name(String val) {
            role_name = val;
            return this;
        }

        public Roles build() {
            return new Roles(this);
        }
    }
}
