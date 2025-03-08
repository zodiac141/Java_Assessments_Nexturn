public class CurrentAccount extends BankAccount implements Transaction {
        public CurrentAccount(String accountNumber, double balance) {
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
            if(balance -amount< 500){
              System.out.println("Cannot transfer");
            }
            else{
                balance = balance - amount;
                destination.deposit(amount);
                System.out.println("Amount transferred successfully");
                System.out.println("Current balance is : " + balance);
            }
        }
    }
