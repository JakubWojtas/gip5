package com.example.test.backend.DTO;

import com.example.test.backend.Model.Roles;
import com.example.test.backend.Model.Transaction;
import com.example.test.backend.Model.User;

import java.util.List;

public class userDTO {
    private Long  user_id;
    private String user_name;
    private String user_mobile;
    private String user_email;
    private Roles user_role;
    private List<Transaction> transactions;

    public userDTO(User user) {
    }

    public userDTO(Long user_id, String user_name, String user_mobile, String user_email, Roles user_role, List<Transaction> transactions) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_mobile = user_mobile;
        this.user_email = user_email;
        this.user_role = user_role;
        this.transactions = transactions;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Roles getUser_role() {
        return user_role;
    }

    public void setUser_role(Roles user_role) {
        this.user_role = user_role;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
