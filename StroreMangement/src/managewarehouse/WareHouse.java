package managewarehouse;

import java.util.*;
import manageproduct.Product;

public class WareHouse {
    private String id;
    private Date time;
    private ArrayList<Product> product;

    public WareHouse() {
        this.id = "";
    }

    public WareHouse(String id, Date time, ArrayList<Product> product) {
        this.id = id;
        this.time = time;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public ArrayList<Product> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return String.format("|%-6s|%-15s|%-15s|",
                                    id, time, product);
    }
    
}
