package nicolasvicente_comp101130899_ex1;

import java.nio.file.FileSystemNotFoundException;

public class Account {

    private double balance;

    public Account (double initialBalance) {
        this.balance = initialBalance;
    }


    public synchronized void deposit (double amount) {
        balance += amount;
        System.out.println("Deposit: " + amount + ", New balance: " + balance);
    }


    public synchronized void withdraw (double amount) {
        if (balance >= amount ) {
            balance -= amount;
            System.out.println("Withdrawal: " + amount + ", New balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }



    }

}
