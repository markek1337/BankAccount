package com.bank;

public class BankAccountApp {

    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount("393443425", 1000);
        // BankAccount acc2 = new BankAccount("543199248", 2000);
        // BankAccount acc3 = new BankAccount("124595724", 3000);

        acc1.setName("Mark");
        System.out.println(acc1.getName());
        acc1.setSurename("Petrov");
        System.out.println(acc1.getSurename());
        acc1.makeDeposit(400);
        acc1.makeDeposit(500);
        acc1.payBill(1000);
        acc1.accure();
        System.out.println(acc1.toString());
        System.out.println("Hello from Github!");

    }
}

class BankAccount implements  IInterest {

    // Properties of BankAccount (Instance variables)
    private String accountNumber;   // ID + random 2-digit number + first 2 of SSN
    private static String routingNumber = "0045400657";
    private String name;
    private String surename;
    private static int iD = 1000;   // Internal ID
    private String SSN;
    private double balance;

    // Constructor (String SSN - local variable)
    public BankAccount (String SSN, double initDeposit) {
        balance = initDeposit;
        this.SSN = SSN;
        iD++;
        setAccountNumber();
        showBalance();
    }

    private void setAccountNumber () {
        int random = (int) (Math.random() * 100);
        accountNumber = iD + "" + random + SSN.substring(0, 2);
        System.out.println("Your account number: " + accountNumber);
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setSurename (String surename) {
        this.surename = surename;
    }

    public String getSurename () {
        return surename;
    }

    public void payBill (double amount) {
        balance = balance - amount;
        System.out.println("Paying Bill: " + amount + "$");
        showBalance();
    }

    public void makeDeposit (double amount) {
        balance = balance + amount;
        System.out.println("Deposition: " + amount + "$");
        showBalance();
    }

    public void showBalance () {
        System.out.println("Your Balance: " + balance + "$");
    }

    @Override
    public void accure () {
        balance = balance * (1 + rate/100);
        showBalance();
    }

    @Override
    public String toString () {
        return "[Name: " + name + "]\n[Account Number: " + accountNumber + "]\n" + "[Routing Number: " + routingNumber + "]\n" + "[Balance: " + balance + "$" +"]";
    }
}
