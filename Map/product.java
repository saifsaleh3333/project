public class product {
  private String name;
  private double price;
  
  public product (String name, double price) {
    this.name = name;
    this.price = price;
}
  
  public String getName() {
    return name;
  }
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public String toString() {
    return "product name" + name + price;
  }
}