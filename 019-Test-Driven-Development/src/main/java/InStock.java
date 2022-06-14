import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InStock implements ProductStock {
    private Map<String, Product> products;

    public InStock() {
        this.products = new LinkedHashMap<>();
    }

    @Override
    public void add(Product product) {
        this.products.put(product.getLabel(), product);
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.products.containsKey(product.getLabel());
    }

    @Override
    public Product find(int index) {
        Product product = this.products.entrySet().stream().skip(index).map(Map.Entry::getValue).findFirst()
                .orElse(null);
        if (product == null) {
            throw new IndexOutOfBoundsException();
        } else {
            return product;
        }
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        if (this.products.get(product) == null) {
            throw new IllegalArgumentException();
        }
        this.products.get(product).setQuantity(quantity);
    }

    @Override
    public Product findByLabel(String label) {
        if (!this.products.containsKey(label)) {
            throw new IllegalArgumentException();
        }
        return this.products.get(label);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        Iterable<Product> foundProducts = new ArrayList<>();
        if (count <= this.products.size()) {
            foundProducts = this.products.values().stream().sorted(Product::compareTo).limit(count)
                    .collect(Collectors.toList());
        }

        return foundProducts;

    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Product> iterator() {
        return this.products.values().iterator();
    }
}
