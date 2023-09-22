package manageproduct;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {

    private String productID;
    private String productName;
    private String type;
    private Date dateOfManufacture;
    private Date expirationDate;
    private int quantity;
    private double price;

    public Product() {
        this.productID = "";
        this.productName = "";
        this.type = "";
    }

    public Product(String productID, String productName, String type, Date dateOfManufacture, Date expirationDate, int quantity, double price) {
        this.productID = productID;
        this.productName = productName;
        this.type = type;
        this.dateOfManufacture = dateOfManufacture;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateOfManufactureStr = sdf.format(dateOfManufacture);
        String expirationDateStr = sdf.format(expirationDate);
        return String.format("   |%-6s|%-20s| %-5s|    %-15s|    %-15s|   %-5d|%8.3f|",
                productID, productName, type, dateOfManufactureStr, expirationDateStr, quantity, price);
    }
    
    public String showScreen() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateOfManufactureStr = sdf.format(dateOfManufacture);
        String expirationDateStr = sdf.format(expirationDate);
        return String.format("|%-6s|%-20s| %-5s|    %-15s|    %-15s|   %-5d|%8.3f|",
                productID, productName, type, dateOfManufactureStr, expirationDateStr, quantity, price);
    }    
}
