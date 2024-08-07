import orders.Order;
import products.Book;
import products.Pencil;
import products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static List<Product> catalog;

    public static void main(String[] args) {

        //- принцип замены Барбары Лисков. Наследуй только тогда, когда можешь играть роль за предка
        // Book и Pencil играют роль предка (Product)
        catalog = new ArrayList<>();
        catalog.add(new Book(101, "Сказки", "Росиздат", 400, 60, "Андерсен"));
        catalog.add(new Book(102, "Рассказы", "Росиздат", 600, 90, "Пушкин"));
        catalog.add(new Book(103, "Басни", "Издательство МИР", 300, 50, "Крылов"));
        catalog.add(new Pencil(202, "Карандаш малыш", "Промторг", 30, 76, "Красный"));
        catalog.add(new Pencil(203, "Карандаш малыш", "Промторг", 30, 68, "Синий"));
        catalog.add(new Pencil(204, "Карандаш", "Рослес", 20, 96, "Зеленый"));
        catalog.add(new Pencil(205, "Карандаш", "Рослес", 20, 88, "Синий"));

        Scanner scan = new Scanner(System.in);
        Order order = Order.getInstance();
        while (true) {
            printMenu();
            int input = scan.nextInt();
            switch (input) {
                case 1: {
                    printCatalog();
                    input = scan.nextInt();
                    if (input > 0 && input <= catalog.size()) {
                        System.out.println("введите количество:");
                        int count = scan.nextInt();
                        order.addProduct(catalog.get(input - 1), count);
                    }


                }
                break;
                case 2: {
                    order.printOrder();
                    System.out.println("Выберите действие: \n" +
                            "1. Удалить товар из корзины \n" +
                            "2. Изменить количество товара \n" +
                            "3. Оформить заказ. \n" +
                            "4. Возврат в основное меню.");
                    input = scan.nextInt();
                    switch (input) {

                        case 1: {
                            System.out.println("Введите артикул товара в корзине");
                            int num = scan.nextInt();
                            order.removeProduct(order.findProduct(num));
                        }
                        break;
                        case 2: {
                            System.out.println("Введите артикул товара в корзине");
                            int num = scan.nextInt();
                            System.out.println("Введите новое количество");
                            int count = scan.nextInt();
                            order.addProduct(order.findProduct(num), count);
                        }
                        break;
                        case 3: {
                            System.out.println("Ваш заказ оформлен:");
                            order.printOrder();
                            return;
                        }
                        case 4:
                            break;

                    }
                }
                break;
                case 3:
                    return;

            }


        }

    }


    public static void printMenu() {
        System.out.println("Выберите номер пункта меню:");
        System.out.println("1. Каталог товаров \n" +
                "2. Корзина \n" +
                "3. Выход из программы");
    }

    public static void printCatalog() {
        System.out.println("Товары доступные для заказа:");
        int i = 1;
        for (Product product : catalog) {
            System.out.println(i + ". " + product.toString()); //Принцип инверсии зависимостей - зависьте от абстракций, а не от имплементаций
            i++;
        }
        System.out.println("Выберите номер товара для добавления в корзину или введите 0 для возврата в основное меню");

    }

}
