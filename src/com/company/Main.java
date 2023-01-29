package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    static ArrayList<Client> clients = new ArrayList<Client>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        creatFakeAccounts();
        while (true) {

            System.out.println("Enter the number of the operation you want do it");
            System.out.println("1 to creat new account");
            System.out.println("2 to show all accounts details");
            System.out.println("3 to show one account details");
            System.out.println("4 to withDraw");
            System.out.println("5 to deposit");
            System.out.println("6 to remove account");
            System.out.println("7 to exit");

            int option = input.nextInt();
            if (option == 1) {
                //creat account
            } else if (option == 2) {
                // print all accounts details
                printAllAccounts();
            } else if (option == 3) {
                // print 1 account details
                printAccountDetails();
            } else if (option == 4) {
                // withdraw
                withdraw();
            } else if (option == 5) {
                //deposit
                deposit();
            } else if (option == 6) {
                // remove account
                removeAccount();
            } else if (option == 7) {
                return;
            }
        }
    }

    public static void creatFakeAccounts() {
        for (int i = 1; i <= 10; i++) {
            BankAccount account = new BankAccount(i * 1000);
            Client client = new Client("account " + i, "add" + i, 12354688);
            accounts.add(account);
            account.setClient(client);
            clients.add(client);
            client.setAccount(account);
        }
    }

    public static void creatAccount() {
        System.out.println("Enter name , address and phone number");
        String name = input.next();
        String address = input.next();
        int phoneNumber = input.nextInt();
        Client client = new Client(name, address, phoneNumber);
        System.out.println("Enter account type");
        System.out.println("1 to creat basic bank account");
        System.out.println("2 to creat saving bank account");
        int option = input.nextInt();
        BankAccount account = null;
        if (option == 1) {
            System.out.println("Enter starting balance");
            double balance = input.nextDouble();
            account = new BankAccount(balance);

        } else if (option == 2) {
            System.out.println("Enter starting balance");
            double balance = input.nextDouble();
            System.out.println("Enter minimum balance balance");
            double minimumBalance = input.nextDouble();
            if (minimumBalance > balance) {
                System.out.println("you can not do it");
                return;
            }
            account = new SavingBankAccount(minimumBalance, balance);
        }
        client.setAccount(account);
        account.setClient(client);
        accounts.add(account);
        clients.add(client);
    }

    public static void printAllAccounts() {
        for (int i = 0; i < accounts.size(); i++) {
            BankAccount a = accounts.get(i);
            a.view();
        }
    }

    private static void printAccountDetails() {
        System.out.println("Enter account id");
        int accountId = input.nextInt();
        BankAccount account = getAccount(accountId);
        if (account == null) {
            System.out.println("Enter a valid account id");
            return;
        }
        account.view();
    }

    public static BankAccount getAccount(int accountId) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accountId == accounts.get(i).getAccountId()) {
                return accounts.get(i);
            }
        }
        return null;
    }

    public static void withdraw() {
        System.out.println("Enter account id");
        int accountId = input.nextInt();
        BankAccount account = getAccount(accountId);
        if (account == null) {
            System.out.println("Enter a valid account id");
            return;
        }
        System.out.println("Enter cash");
        double cash = input.nextDouble();
        account.withDraw(cash);
    }

    public static void deposit() {
        System.out.println("Enter account id");
        int accountId = input.nextInt();
        BankAccount account = getAccount(accountId);
        if (account == null) {
            System.out.println("Enter a valid account id");
            return;
        }
        System.out.println("Enter cash");
        double cash = input.nextDouble();
        account.deposit(cash);
    }

    public static void removeAccount() {
        System.out.println("Enter account id");
        int accountId = input.nextInt();
        BankAccount account = getAccount(accountId);
        if (account == null) {
            System.out.println("Enter a valid account id");
            return;
        }
        accounts.remove(accountId);
        clients.remove(account.getClient());
    }

}

