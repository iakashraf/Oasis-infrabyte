import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Bank.addAccount(new Account("user1", "1234"));
        Bank.addAccount(new Account("user2", "5678"));

        while (true) {
            System.out.print("Enter user ID: ");
            String userId = scanner.next();
            System.out.print("Enter PIN: ");
            String pin = scanner.next();

            if (Bank.authenticate(userId, pin)) {
                Account account = Bank.getAccount(userId);
                ATM atm = new ATM(account);
                atm.start();
                break;
            } else {
                System.out.println("Invalid user ID or PIN. Please try again.");
            }
        }

        scanner.close();
    }
}
