package Ex.Lambda.Streams;

import java.util.*;
import java.util.stream.Collectors;

class Stock {
    private List<Item> items = new ArrayList<>();

    // Generate item and add to list
    public void generateItem() {
        Random random = new Random();
        String itemName = "Item" + random.nextInt(10);
        ItemType itemType = ItemType.values()[random.nextInt(ItemType.values().length)];
        Date expirationDate = new Date(System.currentTimeMillis() + random.nextInt(30) * 24 * 60 * 60 * 1000L); //give a random date up than current date
        double weight = random.nextDouble() * 100;
        Item newItem = new Item(itemName, itemType, expirationDate, weight);
        //Item newItem2 = new Item(itemName, itemType, new Date(System.currentTimeMillis()- ( 24 * 60 * 60 * 1000L)), weight); // for an Expired Items Date
        items.add(newItem);
        //items.add(newItem2);// add the Expired Items Date to the list
        items.sort(Comparator.comparing(Item::getExpirationDate)); // Sort by expiration date
    }

    // Get a list of expired items
    public List<Item> getExpiredItems() {
        Date currentDate = new Date();
        return items.stream()
                .filter(item -> item.getExpirationDate().before(currentDate))
                .collect(Collectors.toList());
    }

    // Get the item with the closest expiry date
    public Item getClosestExpiryItem() {
        Date currentDate = new Date();
        return items.stream()
                .min(Comparator.comparingLong(item -> Math.abs(item.getExpirationDate().getTime() - currentDate.getTime())))
                .orElse(null);
    }

    // Get a list of items sorted alphabetically
    public List<Item> getItemsSortedAlphabetically() {
        return items.stream()
                .sorted(Comparator.comparing(Item::getName))
                .collect(Collectors.toList());
    }

    // Get one item by name
    public Item getItemByName(String itemName) {
        return items.stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst()
                .orElse(null);
    }

    // Get a list of names of items above a certain weight
    public List<String> getItemsAboveWeight(double weightThreshold) {
        return items.stream()
                .filter(item -> item.getWeight() > weightThreshold)
                .map(Item::getName)
                .collect(Collectors.toList());
    }

    // Get sum all the items according to their type
    public Map<ItemType, Integer> getItemsSumByType() {
        return items.stream()
                .collect(Collectors.groupingBy(Item::getType, Collectors.summingInt(item -> 1)));
    }
}
