package Ex.Lambda.Streams;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();

        // Generate items
        for (int i = 0; i < 2; i++) {
            stock.generateItem();
        }

        // Print the stock details
        System.out.println("All Items: " + stock.getItemsSortedAlphabetically().toString());
        System.out.println("Expired Items: " + stock.getExpiredItems());
        System.out.println("Closest Expiry Item: " + stock.getClosestExpiryItem());
        System.out.println("Item by Name: " + stock.getItemByName("Item1"));
        System.out.println("Items Above Weight: " + stock.getItemsAboveWeight(40));
        System.out.println("Items Sum by Type: " + stock.getItemsSumByType());
    }
}
