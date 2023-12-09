package Ex.Lambda.Streams;

import java.util.Date;

enum ItemType {ELECTRONICS, CLOTHING, FOOD, OTHER}
class Item {
    private String name;
    private ItemType type;
    private Date expirationDate;
    private double weight;

    public Item(String name, ItemType type, Date expirationDate, double weight) {
        this.name = name;
        this.type = type;
        this.expirationDate = expirationDate;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return " {ItemType=" + type +", ExpirationDate=" + expirationDate+"} ";
    }
    public String getName() {
        return name;
    }
    public ItemType getType() {
        return type;
    }
    public Date getExpirationDate() {
        return expirationDate;
    }
    public double getWeight() {
        return weight;
    }
}