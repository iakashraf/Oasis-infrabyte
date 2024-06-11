import java.util.*;

public class ATM {
    private Account currentAccount;
    private Scanner scanner;

    public ATM(Account currentAccount) {
        this.currentAccount = currentAccount;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using our ATM.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showTransactionHistory() {
        List<Transaction> transactions = currentAccount.getTransactionHistory();
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (currentAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        currentAccount.deposit(amount);
        System.out.println("Deposit successful. Amount deposited: " + amount);
    }

    private void transfer() {
        System.out.print("Enter recipient account ID: ");
        String recipientId = scanner.next();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        if (currentAccount.transfer(recipientId, amount)) {
            System.out.println("Transfer successful. Amount transferred: " + amount);
        } else {
            System.out.println("Transfer failed. Insufficient balance or invalid recipient.");
        }
    }
}

