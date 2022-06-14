public class TransactionImpl implements Transaction {

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }

    @Override
    public String getFrom() {
        return this.from;
    }

    @Override
    public String getTo() {
        return this.to;
    }

    public TransactionStatus getStatus() {
        return this.status;
    }

    public void setStatus(TransactionStatus newStatus) {
        this.status = newStatus;

    }

    @Override
    public int compareTo(Transaction other) {
        // TODO Auto-generated method stub
        return this.from.compareTo(other.getFrom());
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.id) * 17;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TransactionImpl other)) {
            return false;
        }
        return this.id == other.id;
    }

}
