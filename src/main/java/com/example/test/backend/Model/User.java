package com.example.test.backend.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users", schema = "liquibase")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(name = "Name")
    private String user_name;

    @Column(name = "Mobile number")
    private String user_mobile;

    @Column(name = "Email")
    private String user_email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_role_id")
    private Roles user_role;

    @Column(name = "Transactions")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transactions> transactions;

    //constructoren

    public User(){}

    public User(Long user_id, String user_name, String user_mobile, String user_email, Roles user_role) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_mobile = user_mobile;
        this.user_email = user_email;
        this.user_role = user_role;
    }

    private User(Builder builder) {
        setUser_id(builder.user_id);
        setUser_name(builder.user_name);
        setUser_mobile(builder.user_mobile);
        setUser_email(builder.user_email);
        setUser_role(builder.user_role);
    }

    //get&set

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

    //Functie



    //Builder

    public static final class Builder {
        private Long user_id;
        private String user_name;
        private String user_mobile;
        private String user_email;
        private Roles user_role;

        public Builder() {
        }

        public Builder user_id(Long val) {
            user_id = val;
            return this;
        }

        public Builder user_name(String val) {
            user_name = val;
            return this;
        }

        public Builder user_mobile(String val) {
            user_mobile = val;
            return this;
        }

        public Builder user_email(String val) {
            user_email = val;
            return this;
        }

        public Builder user_role(Roles val) {
            user_role = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
