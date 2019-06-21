package model.dto;

/**
 *
 * @author Arith Alexis Villalba Bravo
 * @date 28/04/2016
 * @time 11:43:38 PM
 */
public class ProductDTO {

    private int id;
    private String name;
    private String amount;
    private double price;

    public ProductDTO(int id, String name, String amount, double price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
}