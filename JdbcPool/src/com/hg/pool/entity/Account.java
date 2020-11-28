package com.hg.pool.entity;
//id,cardNo,password,name,balance
public class Account {
    private int id;
    private String cardNo;
    private String password;
    private String name;
    private double balance;

    public Account() {
    }

    public Account(int id, String cardNo, String password, String name, double balance) {
        this.id = id;
        this.cardNo = cardNo;
        this.password = password;
        this.name = name;
        this.balance = balance;
    }

    public Account(String cardNo, String password, String name, double balance) {
        this.cardNo = cardNo;
        this.password = password;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", cardNo='" + cardNo + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
