package vn.com.webbanhang.entity;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @SequenceGenerator(name = "account_id_seq", sequenceName = "account_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_seq")
    Long id;
    @Column(name = "user_name")
    String username;
    @Column(name = "hashpass")
    String hashPass;
    String email;
    public Account(){

    }

    public Account(String username, String hashPass, String email) {
        this.username = username;
        this.hashPass = hashPass;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
