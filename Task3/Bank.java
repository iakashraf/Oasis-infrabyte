
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static Map<String, Account> accounts = new HashMap<>();

    public static void addAccount(Account account) {
        accounts.put(account.getAccountId(), account);
    }

    public static Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public static boolean authenticate(String accountId, String pin) {
        Account account = accounts.get(accountId);
        return account != null && account.authenticate(pin);
    }
}
