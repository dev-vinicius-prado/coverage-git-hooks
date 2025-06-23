package br.com.devviniciusprado;

public class BankAccount {
  private double balance;
  private String accountNumber;

  public BankAccount(double balance, String accountNumber) {
    this.balance = balance;
    this.accountNumber = accountNumber;
  }

  public void deposit(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Deposit amount must be positive");
    }
    balance += amount;
  }

  public void withdraw(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Amount must be positive");
    }
    if (amount > balance) {
      throw new IllegalArgumentException("Insufficient funds");
    }
    balance -= amount;
  }

  public double getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public boolean canAfford(double amount) {
    return balance >= amount && amount > 0;
  }

  public void transfer(BankAccount target, double amount) {
    this.withdraw(amount);
    target.deposit(amount);
  }
}
