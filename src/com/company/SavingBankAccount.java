package com.company;

public class SavingBankAccount extends BankAccount{
    private double minimumBalance;

    public SavingBankAccount(double minimumBalance , double balance)
    {
        super(balance);
        this.minimumBalance = minimumBalance;
    }
    public SavingBankAccount(double balance)
    {
        super(balance);
        this.minimumBalance = 1000;
    }
    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withDraw(double cash) {
        if ((getBalance() - cash) < minimumBalance){
            System.out.println("you cant do this operation");
        } else {
            super.withDraw(cash);
        }
    }

    @Override
    public void deposit(double cash) {
        if (cash < 100){
            System.out.println("you cant do this operation");
        } else {
            super.deposit(cash);
        }
    }
}
