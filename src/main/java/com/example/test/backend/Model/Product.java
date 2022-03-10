package com.example.test.backend.Model;

import javax.persistence.*;

@Entity
@Table(name="Products", schema = "liquibase")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prod_id;

    @Column(name = "Name")
    private String prod_name;

    @Column(name = "Description")
    private String prod_desc;

    @Column(name = "Limit")
    private String prod_limit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prod_type_id")
    private Product_Type prod_type_id;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "trans_id")
    private Transaction transactions;

    //Constuctors

    public Product(){}

    public Product(Long prod_id, String prod_name, String prod_desc, String prod_limit, Product_Type prod_type_id, Transaction transactions) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.prod_desc = prod_desc;
        this.prod_limit = prod_limit;
        this.prod_type_id = prod_type_id;
        this.transactions = transactions;
    }

    private Product(Builder builder) {
        setProd_id(builder.prod_id);
        setProd_name(builder.prod_name);
        setProd_desc(builder.prod_desc);
        setProd_limit(builder.prod_limit);
        setProd_type_id(builder.prod_type_id);
        stock = builder.stock;
        transactions = builder.transactions;
    }


    //GET&SET


    public Long getProd_id() {
        return prod_id;
    }

    public void setProd_id(Long prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_desc() {
        return prod_desc;
    }

    public void setProd_desc(String prod_desc) {
        this.prod_desc = prod_desc;
    }

    public String getProd_limit() {
        return prod_limit;
    }

    public void setProd_limit(String prod_limit) {
        this.prod_limit = prod_limit;
    }

    public Product_Type getProd_type_id() {
        return prod_type_id;
    }

    public void setProd_type_id(Product_Type prod_type_id) {
        this.prod_type_id = prod_type_id;
    }

    public Stock getStock() {
        return stock;
    }

    public Transaction getTransactions() {
        return transactions;
    }

    //Builder

    public static final class Builder {
        private Long prod_id;
        private String prod_name;
        private String prod_desc;
        private String prod_limit;
        private Product_Type prod_type_id;
        private Stock stock;
        private Transaction transactions;

        public Builder() {
        }

        public Builder prod_id(Long val) {
            prod_id = val;
            return this;
        }

        public Builder prod_name(String val) {
            prod_name = val;
            return this;
        }

        public Builder prod_desc(String val) {
            prod_desc = val;
            return this;
        }

        public Builder prod_limit(String val) {
            prod_limit = val;
            return this;
        }

        public Builder prod_type_id(Product_Type val) {
            prod_type_id = val;
            return this;
        }

        public Builder stock(Stock val) {
            stock = val;
            return this;
        }

        public Builder transactions(Transaction val) {
            transactions = val;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

}
