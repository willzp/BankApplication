package com.company;

import java.util.ArrayList;

public class Bank {
    private long accountNbr = 2000;
    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(String name, long ssn){
        Customer customer = new Customer(name, ssn);
        customers.add(customer);
    }

    public void removeCustomer(long ssn){
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            if(ssn == customer.getSsn()){
                customers.remove(i);
            }
        }
    }

    public void changeCustomerName(long ssn, String newName){
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            if(ssn == customer.getSsn()){
                customer.setName(newName);
            }
        }
    }
    public String GetCustomer(long ssn){
          for(int i = 0; i < customers.size(); i++){
              Customer customer = customers.get(i);
              if(ssn == customer.getSsn()){
                  return customer.getCustomer();
              }
          }
         return "Customer not found";
    }

    public String GetCustomers(){
        String allCustomersInfo = "";
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            String customerInfo = "\nKundens namn: " + customer.getName() + " Kundens personnummer: " + customer.getSsn();
            allCustomersInfo += customerInfo;
        }
        return allCustomersInfo;
    }

    public Account GetAccount(long ssn, long accountNbr){
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            if(ssn == customer.getSsn()){
                ArrayList<Account> accounts = customer.getAccounts();
                for(int j = 0; 1 < accounts.size(); j++){
                    Account account = accounts.get(j);
                    if(accountNbr == account.getAccountNbr()){
                        return account;
                    }
                }
            }
        }
        return null;
    }

    public String GetAccountInfo(long ssn, long accountNbr){
        Account account = GetAccount(ssn, accountNbr);
        if(account ==  null){
            return "Account not found";
        }
        return account.GetAccount();
    }

    public boolean Deposit(long ssn, long accountNbr, int amount){
        Account account = GetAccount(ssn, accountNbr);
        if(account == null){
            return false;
        }
        int balance = account.getBalance();
        account.setBalance(balance +amount);
        return true;
    }

    public boolean Withdraw(long ssn, long accountNbr, int amount){
        Account account = GetAccount(ssn, accountNbr);
        if(account == null){
            return false;
        }
        int balance = account.getBalance();
        account.setBalance(balance - amount);
        return true;
    }

    public boolean CloseAccount(long ssn, long accountNbr){
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            if(ssn == customer.getSsn()){
                ArrayList<Account> accounts = customer.getAccounts();
                for(int j = 0; 1 < accounts.size(); j++){
                    Account account = accounts.get(j);
                    if(accountNbr == account.getAccountNbr()){
                        customer.removeAccount(account);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean addAccount(long ssn){
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            if(ssn == customer.getSsn()){
                Account account = new Account(accountNbr++);
                customer.addAccount(account);
                return true;
            }
        }
       return false;
    }
}


