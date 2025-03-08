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


public class BankingSystem {


             public static void main(String[] args) {
                 SavingsAccount savingsAccount = new SavingsAccount("SA123", 1300.0);
                 CurrentAccount currentAccount = new CurrentAccount("CA456", 300.0);

                 savingsAccount.transfer(savingsAccount, currentAccount, 100.0);
                 savingsAccount.withdraw(20.0);

                 currentAccount.transfer(savingsAccount, currentAccount, 700.0);
                 currentAccount.withdraw(70.0);

             }
         }



