import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InStockQueryTests {
    private Instock stock;

    private static List<String> labels(Iterable<Product> products) {
        List<String> result = new ArrayList<>();
        products.forEach(p -> result.add(p.getLabel()));
        return result;
    }

    @Before
    public void setUp() {
        this.stock = new Instock();
        this.stock.add(new Product("a", 10, 1));
        this.stock.add(new Product("b", 30, 2));
        this.stock.add(new Product("c", 20, 1));
    }

    @Test
    public void findAllByPriceShouldReturnMatchingProducts() {
        Assert.assertEquals(List.of("c"), labels(this.stock.findAllByPrice(20)));
        Assert.assertEquals(List.of(), labels(this.stock.findAllByPrice(99)));
    }

    @Test
    public void findFirstMostExpensiveProductsShouldReturnDescendingByPrice() {
        Assert.assertEquals(List.of("b", "c"), labels(this.stock.findFirstMostExpensiveProducts(2)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findFirstMostExpensiveProductsShouldThrowWhenCountTooBig() {
        this.stock.findFirstMostExpensiveProducts(4);
    }

    @Test
    public void findAllByQuantityShouldReturnMatchingProducts() {
        Assert.assertEquals(List.of("a", "c"), labels(this.stock.findAllByQuantity(1)));
    }

    @Test
    public void iteratorShouldReturnAllProductsInInsertionOrder() {
        Assert.assertEquals(List.of("a", "b", "c"), labels(this.stock));
    }
}
