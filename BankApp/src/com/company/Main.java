package com.company;

import java.util.Scanner;

public class Main {

    public void RunApplication(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Welcome, choose an option:\n 1. Show customers \n 2. Select customer \n 3. Add customer \n 4. Remove customer");
            String userInput = scanner.nextLine();
            if(userInput.equals("1")){
                System.out.println("Customers:" + bank.GetCustomers());
            }
            if(userInput.equals("2")){
                System.out.println("Write customers social security number");
                String customerSsn = scanner.nextLine();
                System.out.println(bank.GetCustomer(Long.parseLong(customerSsn)));
                System.out.println("Choose an option: \n1. Withdraw \n2. Deposit \n3. Add account \n4. Remove account");
                String chosenOption = scanner.nextLine();
                if(chosenOption.equals("1")){
                    System.out.println("Write account number");
                    String account = scanner.nextLine();
                    System.out.println("Write amount to withdraw");
                    String amount = scanner.nextLine();
                    bank.Withdraw(Long.parseLong(customerSsn), Long.parseLong(account), Integer.parseInt(amount));
                    System.out.println("Withdrawn " + amount);
                }
                if(chosenOption.equals("2")){
                    System.out.println("Write account number");
                    String account = scanner.nextLine();
                    System.out.println("Write amount to deposit");
                    String amount = scanner.nextLine();
                    bank.Deposit(Long.parseLong(customerSsn), Long.parseLong(account), Integer.parseInt(amount));
                    System.out.println("Deposited " + amount);
                }
                if(chosenOption.equals("3")){
                    bank.addAccount(Long.parseLong(customerSsn));
                    System.out.println("New account added");
                }
                if(chosenOption.equals("4")){
                    System.out.println("Write account number");
                    String account = scanner.nextLine();
                    bank.CloseAccount(Long.parseLong(customerSsn), Long.parseLong(account));
                    System.out.println("Closed account");
                }
            }
            if(userInput.equals("3")){
                System.out.println("Write customers name");
                String customerName = scanner.nextLine();
                System.out.println("Write customers social security number");
                String customerSsn = scanner.nextLine();
                bank.addCustomer(customerName, Long.parseLong(customerSsn));
                System.out.println("Added " + customerName + " to the bank");
            }
            if(userInput.equals("4")){
                System.out.println("Write customers social security number");
                String customerSsn = scanner.nextLine();
                bank.removeCustomer(Long.parseLong(customerSsn));
                System.out.println(customerSsn + " has been removed from the bank");
            }
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        Bank bank = new Bank();
        main.RunApplication(bank);
    }
}
