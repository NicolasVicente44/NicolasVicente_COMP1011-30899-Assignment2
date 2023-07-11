package nicolasvicente_comp101130899_ex1;

public class Transaction implements Runnable {
    public Account account;
    public String transactionType;
    public double amount;

    public Transaction (Account account, String transactionType, double amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    @Override
    public void run () {
        if (transactionType.equals("deposit")) {
            account.deposit(amount);
        } else if (transactionType.equals("withdraw")) {
            account.withdraw(amount);
        }
    }
}
