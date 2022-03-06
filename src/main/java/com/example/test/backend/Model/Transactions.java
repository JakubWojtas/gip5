package com.example.test.backend.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Transactions", schema = "liquibase")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trans_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private int pruduct_amount;

    private Date date;

    @OneToMany(mappedBy = "prod_id", cascade = CascadeType.ALL)
    private List<Product> products;

    //Constructor
    public Transactions(){}

    public Transactions(int pruduct_amount, Date date, List<Product> products) {
        this.pruduct_amount = pruduct_amount;
        this.date = date;
        this.products = products;
    }

    private Transactions(Builder builder) {
        setPruduct_amount(builder.pruduct_amount);
        setDate(builder.date);
        setProducts(builder.products);
    }


    //GET&SET

    public int getPruduct_amount() {
        return pruduct_amount;
    }

    public void setPruduct_amount(int pruduct_amount) {
        this.pruduct_amount = pruduct_amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    //Functie

    public void addProduct(Product product){
        if (product == null) throw new IllegalArgumentException();
        products.add(product);
    }

    public void deleteProduct(Product product){
        if (product == null) throw new IllegalArgumentException();
        for (Product p : products){
            if(p.getProd_id().equals(product.getProd_id())){
                products.remove(product);
            }
        }
    }

    //Builder

    public static final class Builder {
        private int pruduct_amount;
        private Date date;
        private List<Product> products;

        public Builder() {
        }

        public Builder pruduct_amount(int val) {
            pruduct_amount = val;
            return this;
        }

        public Builder date(Date val) {
            date = val;
            return this;
        }

        public Builder products(List<Product> val) {
            products = val;
            return this;
        }

        public Transactions build() {
            return new Transactions(this);
        }
    }
}
