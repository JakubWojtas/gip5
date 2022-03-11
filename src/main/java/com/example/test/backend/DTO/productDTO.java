package com.example.test.backend.DTO;

import com.example.test.backend.Model.Product;
import com.example.test.backend.Model.Product_Type;
import com.example.test.backend.Model.Stock;
import com.example.test.backend.Model.Transaction;

public class productDTO {
    private Long prod_id;
    private String prod_name;
    private String prod_desc;
    private String prod_limit;
    private Product_Type product_type;
    private Stock stock;
    private Transaction transaction;

    public productDTO(Product product){}

    public productDTO(Long prod_id, String prod_name, String prod_desc, String prod_limit, Product_Type product_type, Stock stock, Transaction transaction) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.prod_desc = prod_desc;
        this.prod_limit = prod_limit;
        this.product_type = product_type;
        this.stock = stock;
        this.transaction = transaction;
    }

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

    public Product_Type getProduct_type() {
        return product_type;
    }

    public void setProduct_type(Product_Type product_type) {
        this.product_type = product_type;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
