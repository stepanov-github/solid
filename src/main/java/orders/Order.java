package orders;

import products.Product;

import java.util.HashMap;
import java.util.Map;

// Принцип единственной ответственности. Класс должен выполнять только те функции, для которых он логически предназначен.
public class Order {
    protected HashMap<Product, Integer> listProducts = new HashMap<Product, Integer>();
    private static Order order;

    private Order() {
    }

    public static Order getInstance() {
        if (order == null) order = new Order();
        return order;
    }

    public void addProduct(Product product, int count) {
        listProducts.put(product, count);
    }

    public void reducedProduct(Product product, int count) {
        if (listProducts.containsKey(product)) {
            int sum = listProducts.get(product) - count;
            if (sum > 0) {
                listProducts.put(product, sum);
            }
            listProducts.remove(product);
        }
    }

    public void removeProduct(Product product) {
        listProducts.remove(product);

    }

    public void printOrder() {
        System.out.println("Содержимое корзины:");
        int i = 1;
        double summa = 0;
        for (Map.Entry<Product, Integer> entry : listProducts.entrySet()) {
            Product key = entry.getKey();
            int count = entry.getValue();
            System.out.println(i + ". " + key.toString() +
                    ", Количество: " + count +
                    ", сумма: " + key.getPrice() * count);
            summa += key.getPrice() * count;
            i++;
        }
        System.out.println("Итоговая сумма покупок: " + summa);
    }

    //Правило DRY повторяющийся код вынесен в отдельный метод
    public Product findProduct(int article) {
        for (Map.Entry<Product, Integer> entry : listProducts.entrySet()) {
            Product key = entry.getKey();
            if (key.getArticle() == article) {
                return key;
            }
        }
        return null;
    }


}
