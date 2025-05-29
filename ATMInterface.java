import java.util.*;

class ATM {
    private double balance;
    private List<String> transactionHistory;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public double checkBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            System.out.println("Collect the cash: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void printMiniStatement() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user ID and PIN during runtime (no fixed values)
        System.out.print("Enter User ID: ");
        String enteredId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        int enteredPin = scanner.nextInt();

        // Login always succeeds (because user defines their own ID/PIN)
        System.out.println("Account Authorized for User ID: " + enteredId);

        ATM atm = new ATM(10000.0);

        while (true) {
            System.out.println("\n1. View Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + atm.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = scanner.nextDouble();
                    atm.withdraw(withdrawAmt);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = scanner.nextDouble();
                    atm.deposit(depositAmt);
                    break;
                case 4:
                    atm.printMiniStatement();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

