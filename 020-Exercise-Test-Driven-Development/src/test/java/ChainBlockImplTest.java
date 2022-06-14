import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainBlockImplTest {

    private static final Transaction TRANSACTION = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Marti",
                                                                       "SoftUni", 600);
    private ChainBlockImpl chainblockImpl;

    @Before
    public void setup() {
        this.chainblockImpl = new ChainBlockImpl();
    }

    @Test
    public void afterAddingTransactionChainblockShouldContainItById() {
        this.chainblockImpl.add(TRANSACTION);

        assertTrue(this.chainblockImpl.contains(TRANSACTION.getId()));
    }

    @Test
    public void afterAddingTransactionChainblockShouldContainItByTransaction() {
        this.chainblockImpl.add(TRANSACTION);
        assertTrue(this.chainblockImpl.contains(TRANSACTION));
    }

    @Test
    public void changingTransactionStatusShoudApplyNewStatus() {
        this.chainblockImpl.add(TRANSACTION);

        TransactionStatus newStatus = getNextStatusValue(TRANSACTION);

        this.chainblockImpl.changeTransactionStatus(TRANSACTION.getId(), newStatus);

        assertEquals(newStatus, TRANSACTION.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionStatusShouldThrowExceptionWithInvalidTransactionId() {
        this.chainblockImpl.add(TRANSACTION);
        this.chainblockImpl.changeTransactionStatus(TRANSACTION.getId() + 1, TRANSACTION.getStatus());
    }

    @Test
    public void removeTransactionByIdShouldRemoveTheTransaction() {
        this.chainblockImpl.add(TRANSACTION);
        this.chainblockImpl.removeTransactionById(TRANSACTION.getId());

        assertFalse(this.chainblockImpl.contains(TRANSACTION));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeTransactionByIdShouldThrowExceptionIfIdIsInvalid() {
        this.chainblockImpl.add(TRANSACTION);
        this.chainblockImpl.removeTransactionById(TRANSACTION.getId() + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByIdShouldThrowExceptionWhenEmpty() {
        this.chainblockImpl.getById(TRANSACTION.getId());

    }

    @Test(expected = IllegalArgumentException.class)
    public void getByIdShouldThrowExceptionWithInvalidId() {
        this.chainblockImpl.add(TRANSACTION);
        this.chainblockImpl.getById(TRANSACTION.getId() + 1);

    }

    @Test
    public void getByIdShouldReturnTheSameTransaction() {
        this.chainblockImpl.add(TRANSACTION);
        assertEquals(TRANSACTION, this.chainblockImpl.getById(TRANSACTION.getId()));

    }

    @Test(expected = IllegalArgumentException.class)
    public void getByTransactionStatusShouldThrowExceptionWhenNoTransactionsWithStatusParamArePresent() {
        this.chainblockImpl.add(TRANSACTION);
        TransactionStatus newStatus = getNextStatusValue(TRANSACTION);

        this.chainblockImpl.getByTransactionStatus(newStatus);
    }

    private TransactionStatus getNextStatusValue(Transaction transaction) {
        int ordinal = transaction.getStatus().ordinal() + 1;
        TransactionStatus[] values = TransactionStatus.values();
        TransactionStatus newStatus = values[ordinal % values.length];
        return newStatus;
    }

    @Test
    public void getByTransactionStatusShouldReturnCorrectCountOfTransactions() {
        int[] statusCounter = new int[TransactionStatus.values().length];
        fillWithTransactions(15, statusCounter);
        this.chainblockImpl.add(TRANSACTION);
        Iterable<Transaction> byTransactionStatus = this.chainblockImpl.getByTransactionStatus(TRANSACTION.getStatus());
        Iterator<Transaction> iter = byTransactionStatus.iterator();
        int counter = 0;
        while (iter.hasNext()) {
            Transaction transaction = iter.next();
            if (transaction.getStatus().equals(TRANSACTION.getStatus())) {
                counter++;
            }
        }
        int actual = statusCounter[TRANSACTION.getStatus().ordinal()];

        assertEquals(actual, counter);
    }

    private void fillWithTransactions(int count, int[] StatusCounter) {

        TransactionStatus[] statuses = TransactionStatus.values();

        for (int i = 1; i <= count; i++) {
            int id = i;
            int index = i % statuses.length;
            TransactionStatus status = statuses[index];
            if (StatusCounter != null) {
                StatusCounter[index]++;
            }
            String from = "From" + (char) ThreadLocalRandom.current().nextInt(48, 125);
            String to = "To" + (char) ThreadLocalRandom.current().nextInt(48, 125);
            double amount = ThreadLocalRandom.current().nextDouble(100, 10000);

            this.chainblockImpl.add(new TransactionImpl(id, status, from, to, amount));
        }
    }

    @Test
    public void getByTransactionStatusShouldReturnTheTransactionsInTheCorrectOrder() {
        int[] statusCounter = new int[TransactionStatus.values().length];
        fillWithTransactions(15, statusCounter);
        this.chainblockImpl.add(TRANSACTION);
        Iterable<Transaction> byTransactionStatus = this.chainblockImpl.getByTransactionStatus(TRANSACTION.getStatus());
        Iterator<Transaction> iter = byTransactionStatus.iterator();

        List<Double> amounts = new ArrayList<>();

        for (Transaction transaction : byTransactionStatus) {
            amounts.add(transaction.getAmount());
        }

        List<Double> sorted = amounts.stream().sorted((f, s) -> s.compareTo(f)).collect(Collectors.toList());

        assertEquals(sorted, amounts);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllSendersWithTransactionStatusShouldThrowExceptionWhenTransactionStatusIsAbsent() {
        this.chainblockImpl.add(TRANSACTION);
        TransactionStatus status = getNextStatusValue(TRANSACTION);

        this.chainblockImpl.getAllSendersWithTransactionStatus(status);
    }

    @Test
    public void getAllSendersWithTransactionStatusShouldReturnCorrectResult() {
        this.fillWithTransactions(15, null);
        Iterable<String> senders = this.chainblockImpl.getAllSendersWithTransactionStatus(TRANSACTION.getStatus());

        Iterable<Transaction> transactions = this.chainblockImpl.getByTransactionStatus(TRANSACTION.getStatus());

        List<String> orderedSenders = new ArrayList<>();

        for (String sender : senders) {
            orderedSenders.add(sender);
        }
        Collections.sort(orderedSenders);

        List<String> orderedTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            orderedTransactions.add(transaction.getFrom());
        }

        Collections.sort(orderedTransactions);

        assertEquals(orderedTransactions, orderedSenders);
    }

    @Test
    public void getAllSendersWithTransactionStatusShouldReturnCorrectResultSorted() {
        this.fillWithTransactions(15, null);
        Iterable<String> senders = this.chainblockImpl.getAllSendersWithTransactionStatus(TRANSACTION.getStatus());

        Iterable<Transaction> transactions = this.chainblockImpl.getByTransactionStatus(TRANSACTION.getStatus());

        List<String> aggregatedSenders = new ArrayList<>();

        for (String sender : senders) {
            aggregatedSenders.add(sender);
        }

        List<String> orderedTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            orderedTransactions.add(transaction.getFrom());
        }


        assertEquals(orderedTransactions, aggregatedSenders);
    }
}
