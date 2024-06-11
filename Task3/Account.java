import java.util.*;

public class Account {
    private String accountId;
    private String pin;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountId, String pin) {
        this.accountId = accountId;
        this.pin = pin;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public boolean authenticate(String pin) {
        return this.pin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public boolean transfer(String recipientId, double amount) {
        Account recipient = Bank.getAccount(recipientId);
        if (recipient != null && amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add(new Transaction("Transfer to " + recipientId, amount));
            recipient.getTransactionHistory().add(new Transaction("Transfer from " + accountId, amount));
            return true;
        }
        return false;
    }
}
