public  class SavingsAccount extends BankAccount implements Transaction {
    private static final double minBalance = 500.0;

    public SavingsAccount(String accountNumber, double balance) {
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
            System.out.println("Insufficient balance for transfer(minimum 500).");
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
