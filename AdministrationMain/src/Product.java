/**
 * Created by Dominik on 30.07.17.
 */
public class Product {

    private String name;
    private double price;
    private double amount;
    private double priceInvest;
    private double sellPrice;

    public Product(){
        this.name = "";
        this.price = 0;
        this.amount = 0;
        this.priceInvest = 0;
        this.sellPrice = 0;
    }

    public Product(String name, double price, int amount, double priceInvest, double sellPrice) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.priceInvest = priceInvest;
        this.sellPrice = sellPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPriceInvest(double priceInvest) {
        this.priceInvest = priceInvest;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount = sellPrice - (price + priceInvest);
    }

    public double getPriceInvest() {
        return priceInvest;
    }

    public double getSellPrice() {
        return sellPrice;
    }
}
