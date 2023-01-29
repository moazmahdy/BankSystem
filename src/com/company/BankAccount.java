package com.company;

public class BankAccount {

    private int accountId;
    private static int accountIdGenerator = 1;
    private double balance;
    Client client;

    public BankAccount(double balance) {
        this.balance = balance;
        accountId = accountIdGenerator;
        accountIdGenerator++;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BankAccount() {
        balance = 0;
        accountId = accountIdGenerator;
        accountIdGenerator++;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withDraw(double cash) {
        if (cash > balance || cash < 0) {
            System.out.println("you cant do this operation");
        } else {
            balance -= cash;
        }
    }

    public void deposit(double cash) {
        if (cash < 0) {
            System.out.println("you cant do this opration");
        } else {
            balance += cash;
        }
    }

    public void view () {
        System.out.println("account id: " + accountId);
        System.out.println("name: " + client.getName());
        System.out.println("balance: " + balance);
        System.out.println("---------------------------");
    }

}
