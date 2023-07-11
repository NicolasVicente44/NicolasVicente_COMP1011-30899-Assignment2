package nicolasvicente_comp101130899_ex1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        //initial account
        Account account = new Account((1000.00));
        ArrayList<Transaction> transactions = new ArrayList<>();

        //transaction objects
        transactions.add(new Transaction(account, "deposit", 500.0));
        transactions.add(new Transaction(account, "withdraw", 200.0));
        transactions.add(new Transaction(account, "withdraw", 800.0));


        ExecutorService executorService = Executors.newFixedThreadPool(transactions.size());




        //execution of the threads
        for (Transaction transaction : transactions) {
            executorService.execute(transaction);
        }


        //shutdown the executor service
        executorService.shutdown();
    }

}
