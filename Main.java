import app.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> prodotti = new ArrayList<>();
        Product p1 = new Product(124, "Harry Potter", "Books", 17.99);
        Product p2 = new Product(346, "The Lord Of The Rings", "Books", 14.50);
    }
}
