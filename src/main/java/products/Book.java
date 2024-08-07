package products;

public class Book extends Product {
    private String author;

    public Book(long article, String name, String manufacturer, double price, int rating, String author) {
        super(article, name, manufacturer, price, rating);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
