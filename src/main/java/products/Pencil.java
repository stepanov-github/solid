package products;

public class Pencil extends Product {
    private String color;

    public Pencil(long article, String name, String manufacturer, double price, int rating, String color) {
        super(article, name, manufacturer, price, rating);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
