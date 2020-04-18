package com.example.demo;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String title;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @ManyToOne(optional = false)
    private Account account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task() {
    }

    public Task(String title) {
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
