package com.example.test.backend.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Transactions", schema = "liquibase")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trans_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private int product_amount;

    private Date date;

    @OneToMany(mappedBy = "prod_id", cascade = CascadeType.ALL)
    private List<Product> products;

    //Constructor

    public Transaction(){}

    public Transaction(Long trans_id, User user, int product_amount, Date date, List<Product> products) {
        this.trans_id = trans_id;
        this.user = user;
        this.product_amount = product_amount;
        this.date = date;
        this.products = products;
    }

    private Transaction(Builder builder) {
        setTrans_id(builder.trans_id);
        setUser(builder.user);
        setProduct_amount(builder.product_amount);
        setDate(builder.date);
        setProducts(builder.products);
    }


    //GET&SET

    public Long getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(Long trans_id) {
        this.trans_id = trans_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(int product_amount) {
        this.product_amount = product_amount;
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

    //Funtions

    public void addProduct(Product product){
        if (product == null) throw new IllegalArgumentException();
        this.products.add(product);
    }

    public void removeProduct(Product product){
        if (product == null) throw new IllegalArgumentException();
        this.products.removeIf(prod ->
                Objects.equals(prod.getProd_id(), product.getProd_id()));
    }

    //Builder

    public static final class Builder {
        private Long trans_id;
        private User user;
        private int product_amount;
        private Date date;
        private List<Product> products;

        public Builder() {
        }

        public Builder trans_id(Long val) {
            trans_id = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder product_amount(int val) {
            product_amount = val;
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

        public Transaction build() {
            return new Transaction(this);
        }
    }

}
