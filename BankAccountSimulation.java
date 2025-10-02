import java.util.ArrayList;
import java.util.Scanner;


class Account {
    protected String accountHolder;
    protected double balance;
    protected ArrayList<String> transactionHistory;

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + " | Balance: " + balance);
            System.out.println("✅ Deposit successful!");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + " | Balance: " + balance);
            System.out.println("✅ Withdrawal successful!");
        } else {
            System.out.println("❌ Invalid or insufficient funds.");
        }
    }

    public void showBalance() {
        System.out.println("💰 Current Balance: " + balance);
    }

    public void showTransactionHistory() {
        System.out.println("📜 Transaction History:");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

class SavingsAccount extends Account {
    private double interestRate = 0.05; // 5% interest

    public SavingsAccount(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        transactionHistory.add("Interest added: " + interest + " | Balance: " + balance);
        System.out.println("✅ Interest applied! New Balance: " + balance);
    }
}

// Current Account (with overdraft)
class CurrentAccount extends Account {
    private double overdraftLimit = 500;

    public CurrentAccount(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance + overdraftLimit) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + " | Balance: " + balance);
            System.out.println("✅ Withdrawal successful!");
        } else {
            System.out.println("❌ Withdrawal exceeds overdraft limit.");
        }
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter choice: ");
        int accType = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        Account account;
        if (accType == 1) {
            account = new SavingsAccount(name, initialBalance);
        } else {
            account = new CurrentAccount(name, initialBalance);
        }

        while (true) {
            System.out.println("\n===== Bank Menu =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            if (account instanceof SavingsAccount) {
                System.out.println("5. Apply Interest");
                System.out.println("6. Exit");
            } else {
                System.out.println("5. Exit");
            }

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (account instanceof SavingsAccount) {
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        account.deposit(sc.nextDouble());
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        account.withdraw(sc.nextDouble());
                        break;
                    case 3:
                        account.showBalance();
                        break;
                    case 4:
                        account.showTransactionHistory();
                        break;
                    case 5:
                        ((SavingsAccount) account).applyInterest();
                        break;
                    case 6:
                        System.out.println("👋 Exiting... Thank you!");
                        sc.close();
                        return;
                    default:
                        System.out.println("❌ Invalid option.");
                }
            } else {
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        account.deposit(sc.nextDouble());
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        account.withdraw(sc.nextDouble());
                        break;
                    case 3:
                        account.showBalance();
                        break;
                    case 4:
                        account.showTransactionHistory();
                        break;
                    case 5:
                        System.out.println("👋 Exiting... Thank you!");
                        sc.close();
                        return;
                    default:
                        System.out.println("❌ Invalid option.");
                }
            }
        }
    }
}
