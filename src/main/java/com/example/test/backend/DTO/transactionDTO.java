package com.example.test.backend.DTO;

import com.example.test.backend.Model.Product;
import com.example.test.backend.Model.Transaction;
import com.example.test.backend.Model.User;

import java.util.Date;
import java.util.List;

public class transactionDTO {
    private Long trans_id;
    private User user;
    private int product_amount;
    private Date date;
    private List<Product> products;

    public transactionDTO(Transaction transaction){}

    public transactionDTO(Long trans_id, User user, int product_amount, Date date, List<Product> products) {
        this.trans_id = trans_id;
        this.user = user;
        this.product_amount = product_amount;
        this.date = date;
        this.products = products;
    }

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
}
