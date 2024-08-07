package products;


//Принцип открытости/закрытости - программные сущности должны быть открыты для
//расширения, но закрыты для модификации
// Добавлние нового товара легко реализуется с помощью наследования класса Product
public class Product {
    private long article;
    private String name;
    private String manufacturer;
    private double price;
    private int rating;
    private final int MAXRATING = 100; // правило Magic

    public Product(long article, String name, String manufacturer, double price, int rating) {
        this.article = article;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        if (rating <= MAXRATING) {
            this.rating = rating;
        } else this.rating = MAXRATING;
    }

    public long getArticle() {
        return article;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "{" +
                "артикул: " + article +
                ", название: '" + name + "'" +
                ", производитель: '" + manufacturer + "'" +
                ", рейтинг: " + rating +
                ", цена: " + price +
                '}';
    }
}
