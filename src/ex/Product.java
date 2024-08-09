package ex;

public class Product {
   private final String name;
   private final Double price;
   private final Integer quantity;

   public Product(String name, Double price, Integer quantity) {
      this.name = name;
      this.price = price;
      this.quantity = quantity;
   }

   public final String getName() {
      return name;
   }

   public final Double getPrice() {
      return price;
   }

   public final Integer getQuantity() {
      return quantity;
   }

   public final Double getTotalValue() {
      return this.price * this.quantity;
   }

}
