package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product prodotto1 = new Product(123456, "Harry Potter", "Books", 19.99);
        Product prodotto2 = new Product(234567, "Lord Of The Rings", "Books", 17.99);
        Product prodotto3 = new Product(345678, "Paperinik", "Books", 4.99);
        Product prodotto4 = new Product(456789, "Cicciobello", "Baby", 24.99);
        Product prodotto5 = new Product(567890, "Carillon", "Baby", 21.99);
        Product prodotto6 = new Product(678901, "Peluche", "Baby", 1.99);
        Product prodotto7 = new Product(789012, "Cintura", "Boys", 5.99);
        Product prodotto8 = new Product(890123, "Portafoglio", "Boys", 19.99);
        Product prodotto9 = new Product(901234, "Camicia", "Boys", 9.99);

        List<Product> listaProdotti = new ArrayList<>();
        listaProdotti.add(prodotto1);
        listaProdotti.add(prodotto2);
        listaProdotti.add(prodotto3);
        listaProdotti.add(prodotto4);
        listaProdotti.add(prodotto5);
        listaProdotti.add(prodotto6);
        listaProdotti.add(prodotto7);
        listaProdotti.add(prodotto8);
        listaProdotti.add(prodotto9);

        System.err.println("Libri filtrati: ");
        List<Product> libriFiltrati = listaProdotti.stream().filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100).toList();

        for (Product product : libriFiltrati) {
            System.out.println("Nome: " + product.getName() + ", Prezzo: " + product.getPrice());
        }

        Customer cliente1 = new Customer(111111, "Davide", 1);
        Customer cliente2 = new Customer(222222, "Andrea", 2);
        Customer cliente3 = new Customer(333333, "Manuele", 2);

        List<Product> babyFiltrati = listaProdotti.stream().filter(product -> product.getCategory().equals("Baby")).toList();

        List<Order> ordini = new ArrayList<>();
        Order ordine1 = new Order(4161, "Success", LocalDate.now(), LocalDate.now().plusDays(2), babyFiltrati, cliente1);
        Order ordine2 = new Order(8322, "Pending", LocalDate.now(), LocalDate.now().plusDays(3), babyFiltrati, cliente2);
        Order ordine3 = new Order(12483, "Pending", LocalDate.of(2023, 10, 11), LocalDate.now().plusDays(3), babyFiltrati, cliente3);

        ordini.add(ordine1);
        ordini.add(ordine2);
        ordini.add(ordine3);
        System.err.println("Baby Filtrati: ");

        for (Order product : ordini) {
            System.out.println("Id: " + product.getId() + ", Stato dell'ordine: " + product.getStatus() + "Data di acquisto: " + product.getOrderDate() + ", Data di consegna prevista: " + product.getDeliveryDate() + ", Cliente: " + product.getCustomer() + ", Prodotti acquistati: " + babyFiltrati);
        }

        List<Product> boysProducts = listaProdotti.stream().filter(product -> product.getCategory().equals("Boys")).toList();
        System.err.println("Prodotti Boys Filtrati: ");
        for (Product product : boysProducts) {
            System.out.println("Nome: " + product.getName() + ", Prezzo: " + product.getPrice());
        }
        System.err.println("Prodotti Boys con sconto del 10%: ");
        for (Product product : boysProducts) {
            double prezzoScontato = product.getPrice() * 0.9;
            product.setPrice(prezzoScontato);
            System.out.println("Nome: " + product.getName() + ", Prezzo scontato: " + product.getPrice());
        }

        List<Order> ordiniFiltrati = ordini.stream().filter(order -> order.getCustomer().getTier() == 2 && order.getOrderDate().isAfter(LocalDate.of(2023, 10, 11)) && order.getOrderDate().isBefore(LocalDate.of(2023, 10, 13))).toList();
        for (Order order : ordiniFiltrati) {
            System.err.println("Id: " + order.getId() + ", Stato dell'ordine: " + order.getStatus() + ", Data di ricezione dell'ordine: " + order.getOrderDate() + ", Data di consegna dell'ordine: " + order.getDeliveryDate() + ", Cliente: " + order.getCustomer() + ", Prodotti acquistati: " + order.getProducts());
        }
    }
}