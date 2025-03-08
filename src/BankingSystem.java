abstract class BankAccount {
    String accountNumber;
    double balance;

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Rs" + amount + ". New balance: Rs" + balance);
    }

    abstract void withdraw(double amount);
}

interface Transaction {
    void transfer(BankAccount source, BankAccount destination, double amount);
}

class SavingsAccount extends BankAccount implements Transaction {
    private static final double minBalance = 500.0;

    SavingsAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public void transfer(BankAccount source, BankAccount destination, double amount) {
        if (balance - amount >= minBalance) {
            balance -= amount;
            destination.deposit(amount);
            System.out.println("Transfer successful. New balance: Rs" + balance);
        } else {
            System.out.println("Insufficient balance for transfer (minimum Rs500).");
        }
    }

    @Override
    void withdraw(double amount) {
        if (balance - amount >= minBalance) {
            balance -= amount;
            System.out.println("Withdrawn Rs" + amount + ". New balance: Rs" + balance);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }
}

class CurrentAccount extends BankAccount implements Transaction {
    CurrentAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    void withdraw(double amount) {
        if (balance - amount < -5000) {
            System.out.println("Overdraft exceeded.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn Rs" + amount + ". New balance: Rs" + balance);
        }
    }

    @Override
    public void transfer(BankAccount source, BankAccount destination, double amount) {
        if (balance - amount < 500) {
            System.out.println("Cannot transfer");
        } else {
            balance -= amount;
            destination.deposit(amount);
            System.out.println("Amount transferred successfully");
            System.out.println("Current balance is: " + balance);
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("SA123", 1300.0);
        CurrentAccount currentAccount = new CurrentAccount("CA456", 300.0);

        savingsAccount.transfer(savingsAccount, currentAccount, 100.0);
        savingsAccount.withdraw(20.0);

        currentAccount.transfer(currentAccount, savingsAccount, 700.0);
        currentAccount.withdraw(70.0);
    }
}
