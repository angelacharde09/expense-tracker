import java.util.*;

public class TransactionService {
    private Map<Integer, Transaction> transactions = new HashMap<>();

    public void addTransaction(Transaction t) {
        transactions.put(t.getId(), t);
    }

    public void deleteTransaction(int id) {
        transactions.remove(id);
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions.values());
    }
}