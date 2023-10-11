package app;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;

    public Product(long id, String name, String category, double price) {
        super();
        this.setId(id);
        this.setName(name);
        this.setCategory(category);
        this.price = price;
    }

    public long getId() {
        return id;
    }
    private void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    private void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public double setPrice(double price) {
        return price;
    }

    public double sconto() {
        double initial = this.getPrice();
        double pricediscount = (initial * 10) / 100;

        return pricediscount;
    }

    @Override
    public String toString() {
        return "ID: " + id + " " + "Nome prodotto: " + " " + name + " " + "di categoria: " + category + " " + ", prezzo: " + price;
    }
}
