package com.example.test.backend.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id", nullable = false)
    private Long stock_id;

    @Column(name = "Products")
    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private List<Product> products;

    //Constructor

    public Stock(){}

    public Stock(List<Product> products) {
        this.products = products;
    }

    private Stock(Builder builder) {
        setProducts(builder.products);
    }


    //GET&SET

    public Long getStock_id() {
        return stock_id;
    }

    public void setStock_id(Long stock_id) {
        this.stock_id = stock_id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    //functies

    public void addProduct(Product product){
        if (product == null) throw new IllegalArgumentException();
        products.add(product);
    }

    public void removeProduct(Product product){
        if (product == null) throw new IllegalArgumentException();
        this.products.removeIf(prod ->
                Objects.equals(prod.getProd_id(), product.getProd_id()));
    }

    //Builder

    public static final class Builder {
        private List<Product> products;

        public Builder() {
        }

        public Builder products(List<Product> val) {
            products = val;
            return this;
        }

        public Stock build() {
            return new Stock(this);
        }
    }
}
