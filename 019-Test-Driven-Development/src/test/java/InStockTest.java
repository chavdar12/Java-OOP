import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class InStockTest {

    private static final String[] LABELS = {"B", "D", "A", "C", "E"};

    private InStock instock;
    private Product product;

    @Before
    public void setup() {
        instock = new InStock();
        product = new Product("Cosmos", 3.14, 2);
    }

    @Test
    public void instockGetCOuntShouldReturnZeroOnEmptyInstock() {

        int count = instock.getCount();

        assertEquals(0, count);
    }

    @Test
    public void addingProductShouldAddIncreaseCount() {

        this.instock.add(product);

        assertEquals(1, instock.getCount());
    }

    @Test
    public void containsShouldReturnTrueWhenProductIsPresent() {

        this.instock.add(this.product);

        assertTrue(this.instock.contains(product));
    }

    @Test
    public void containsShouldReturnFalseWhenProductIsNotPresent() {

        this.instock.add(this.product);

        assertFalse(this.instock.contains(new Product("Cosmoss", 3.14, 2)));
    }

    @Test
    public void findShouldReturnCorrectProductAccordingToInsertionOrder() {
        fillWithProducts();
        int order = LABELS.length / 2;
        Product returnedProduct = this.instock.find(order);

        assertEquals(LABELS[order], returnedProduct.getLabel());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findWithInvalidIndexShouldThrowException() {
        fillWithProducts();
        this.instock.find(this.LABELS.length);
    }

    @Test
    public void changeQuantityShouldReplaceOldQuantityValue() {
        this.instock.add(product);
        this.instock.changeQuantity(product.getLabel(), 69);

        assertEquals(69, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityWithInvalidProductShouldThrowException() {
        this.instock.add(product);
        this.instock.changeQuantity("123", 23);
    }

    @Test
    public void findByLabelShouldReturnCorrectProduct() {
        this.instock.add(product);
        Product searchedProduct = this.instock.findByLabel(product.getLabel());
        assertEquals(product, searchedProduct);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabelWithInvalidLabelShouldThrowException() {
        this.instock.add(product);
        this.instock.findByLabel(this.product.getLabel() + "1");
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnEmptyCollectionWithOutOfRangeArgument() {
        fillWithProducts();
        List<Product> products = (List<Product>) this.instock.findFirstByAlphabeticalOrder(LABELS.length + 1);

        assertTrue(products.isEmpty());
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnCorrectCountOfProducts() {
        fillWithProducts();

        List<Product> products = (List<Product>) this.instock.findFirstByAlphabeticalOrder(LABELS.length);

        assertEquals(LABELS.length, products.size());
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnCorrectCountOfProductsWhenCountIsLessThanSize() {
        fillWithProducts();

        int count = LABELS.length / 2;

        List<Product> products = (List<Product>) this.instock.findFirstByAlphabeticalOrder(count);

        assertEquals(count, products.size());
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnElementsInCorrectOrder() {
        fillWithProducts();
        List<Product> products = (List<Product>) this.instock.findFirstByAlphabeticalOrder(LABELS.length);

        Arrays.sort(LABELS);

        String[] arr = new String[LABELS.length];
        int index = 0;

        for (Product product : products) {
            arr[index++] = product.getLabel();
        }

        assertArrayEquals(LABELS, arr);
    }

    @Test
    public void getIterableShouldReturnAllElements() {
        fillWithProducts();
        Iterator<Product> iterator = this.instock.iterator();

        String[] resNames = new String[LABELS.length];

        int index = 0;

        while (iterator.hasNext()) {
            resNames[index++] = iterator.next().getLabel();
        }

        assertArrayEquals(LABELS, resNames);
    }

    private void fillWithProducts() {
        for (int i = 0; i < LABELS.length; i++) {
            this.instock.add(new Product(LABELS[i], i, i));
        }

    }

}
