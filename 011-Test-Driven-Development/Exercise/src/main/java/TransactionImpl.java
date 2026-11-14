public class TransactionImpl implements Comparable<TransactionImpl> {

    private final int id;
    private final TransactionStatus status;
    private final String from;
    private final String to;
    private final double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public int compareTo(TransactionImpl o) {
        return 0;
    }
}
