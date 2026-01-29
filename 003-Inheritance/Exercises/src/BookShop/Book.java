package BookShop;

public class Book {
    private String author;
    private String title;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    private String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    private String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        if (containsDigit(author)) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    @Override
    public String toString() {
        String sb = "Type: " + this.getClass().getSimpleName() +
                System.lineSeparator() +
                "Title: " + this.getTitle() +
                System.lineSeparator() +
                "Author: " + this.getAuthor() +
                System.lineSeparator() +
                "Price: " + this.getPrice() +
                System.lineSeparator();
        return sb;

    }

    public final boolean containsDigit(String s) {
        boolean containsDigit = false;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }
        return containsDigit;
    }
}