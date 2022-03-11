package com.example.test.backend.DTO;

import com.example.test.backend.Model.Product;
import com.example.test.backend.Model.Stock;

import java.util.List;

public class stockDTO {
    private Long stock_id;
    private List<Product> products;

    public stockDTO(Stock stock){}

    public stockDTO(Long stock_id, List<Product> products) {
        this.stock_id = stock_id;
        this.products = products;
    }

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
}
