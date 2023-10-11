package app;

public class Customer {
    private long id;
    private String name;
    private int tier;

    public Customer(long id, String name, int tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + name + ", Livello: " + tier;
    }
    public String getCustomer() {
        return name + tier;
    }

    public int getTier() {
        return tier;
    }
}
