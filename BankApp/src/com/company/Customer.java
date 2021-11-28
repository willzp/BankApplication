package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private long ssn;
    private ArrayList<Account> accounts = new ArrayList<>();

    public Customer(String name, long ssn){
        this.name = name;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSsn() {
        return ssn;
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void removeAccount(Account account){
        accounts.remove(account);
    }

    public String getCustomer(){
        String customerInfo = "Customer name: " + name +
                "\nSocial Security Number: " + ssn +
                "\nAccounts:";
        for(int i=0; i<accounts.size(); i++) {
            customerInfo += "\n" + accounts.get(i).GetAccount();
        }
        return customerInfo;
    }
}
