package com.company;

public class Account {
    private int balance = 0;
    private Long accountNbr;
    private String accountType = "Debit";

    public Account(long accountNbr){
        this.accountNbr = accountNbr;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Long getAccountNbr() {
        return accountNbr;
    }

    public void setAccountNbr(Long accountNbr) {
        this.accountNbr = accountNbr;
    }

    public String GetAccount(){
        return "Account number: " + accountNbr +
                "\nAccount type: " + accountType +
                "\nBalance: " + balance;
    }
}
