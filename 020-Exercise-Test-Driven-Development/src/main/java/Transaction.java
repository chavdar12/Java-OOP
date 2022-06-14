public interface Transaction extends Comparable<Transaction> {
    int getId();

    double getAmount();

    String getFrom();

    String getTo();

    TransactionStatus getStatus();

    void setStatus(TransactionStatus newStatus);
}
