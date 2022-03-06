package com.example.test.backend.Model;

import javax.persistence.*;

@Entity
@Table(name="Product_Types", schema = "liquibase")
public class Product_Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prod_type_id;

    private String prod_type_name;

    //Constructor

    public Product_Type() {}

    public Product_Type(Long prod_type_id, String prod_type_name) {
        this.prod_type_id = prod_type_id;
        this.prod_type_name = prod_type_name;
    }

    private Product_Type(Builder builder) {
        setProd_type_id(builder.prod_type_id);
        setProd_type_name(builder.prod_type_name);
    }

    //GET&SET

    public Long getProd_type_id() {
        return prod_type_id;
    }

    public void setProd_type_id(Long prod_type_id) {
        this.prod_type_id = prod_type_id;
    }

    public String getProd_type_name() {
        return prod_type_name;
    }

    public void setProd_type_name(String prod_type_name) {
        this.prod_type_name = prod_type_name;
    }

    //Builder

    public static final class Builder {
        private Long prod_type_id;
        private String prod_type_name;

        public Builder() {
        }

        public Builder prod_type_id(Long val) {
            prod_type_id = val;
            return this;
        }

        public Builder prod_type_name(String val) {
            prod_type_name = val;
            return this;
        }

        public Product_Type build() {
            return new Product_Type(this);
        }
    }
}
