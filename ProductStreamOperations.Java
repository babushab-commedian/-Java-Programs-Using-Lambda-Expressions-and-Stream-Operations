import java.util.*;
import java.util.stream.*;
import java.util.Comparator;

class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " | " + category + " | Price: " + price;
    }
}

public class ProductStreamOperations {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 75000, "Electronics"),
            new Product("Phone", 50000, "Electronics"),
            new Product("Shoes", 4000, "Fashion"),
            new Product("Shirt", 2000, "Fashion"),
            new Product("Refrigerator", 30000, "Appliances"),
            new Product("Washing Machine", 25000, "Appliances")
        );

        // Group products by category
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
        System.out.println("Grouped by Category:");
        grouped.forEach((cat, list) -> {
            System.out.println(cat + " -> " + list);
        });

        // Most expensive product in each category
        Map<String, Optional<Product>> expensive = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));
        System.out.println("\nMost Expensive Product in Each Category:");
        expensive.forEach((cat, prod) -> {
            System.out.println(cat + " -> " + prod.orElse(null));
        });

        // Average price of all products
        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}
