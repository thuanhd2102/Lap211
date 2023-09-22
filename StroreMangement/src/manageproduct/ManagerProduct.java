package manageproduct;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import ui.Menu;
import util.Validation;

public class ManagerProduct {

    public static ArrayList<Product> p;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ManagerProduct() {
        p = new ArrayList<>();
    }

    public void loadFromFile() {

    }

    public boolean loadFromFile(String path) {
        File f = new File(path);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String line;
            while ((line = bfr.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String name = st.nextToken().trim();
                String type = st.nextToken().trim();
                String productDateStr = st.nextToken().trim();
                String expirationDateStr = st.nextToken().trim();
                int quantity = Integer.parseInt(st.nextToken().trim());
                double price = Double.parseDouble(st.nextToken().trim());

                Date dateOfManufacture = Validation.dF.parse(productDateStr);
                Date expirationDate = Validation.dF.parse(expirationDateStr);

                p.add(new Product(id, name, type, dateOfManufacture, expirationDate, quantity, price));
            }
            System.out.println("Import data successful!");
            return true;
        } catch (IOException | NumberFormatException | ParseException e) {
            System.err.println("Load file error!");
            return false;
        }
    }

    public void addProductLong() {
        String check;
        do {
            String productID = Validation.checkDuplicateID("Input ID (L/SXXXX): ", "Please enter the correct sytax"
                    + " (L/SXXXX). X is a digit", "^(L|l|S|s)\\d{4}$", p);
            String productNamme = Validation.getString("Input the product name: ", "This field is required");
            String type = Validation.getString("Input the product type: ", "This field is required");
            int quantity = Validation.getInt("Input the product quanlity: ", "Enter the appropriate value", 0, Integer.MAX_VALUE);
            double price = Validation.getDouble("Input price: ", "Enter the appropriate value", 0, Double.MAX_VALUE);
            Date dateOfManufacture = Validation.getDate("Input the manufacturing date (DD/MM/YYYY): ", "Invalid date format. Please re-enter.");
            Date expirationDate = Validation.getDate("Input the expiration date (DD/MM/YYYY): ", "Invalid date format. Please re-enter.");
            p.add(new Product(productID, productNamme, type, dateOfManufacture, expirationDate, quantity, price));
            System.out.println("Data import successful!");

            check = Validation.getFormat("Do you want to continue creating new product? (Y/N): ", "Only (Y/N)", "(Y|y|N|n)");
        } while (!check.equalsIgnoreCase("N"));
    }

    public Product searchProduct(String id) {
        if (p.isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < p.size(); i++) {
                if (p.get(i).getProductID().equalsIgnoreCase(id)) {
                    return p.get(i);
                }
            }
        }
        return null;
    }

    public void updateProduct() {
        if (p.isEmpty()) {
            System.out.println("The list is emty.");
        } else {
            showProduct();
            String searchID = Validation.getFormat("Input ID do you want to update (L/SXXXX): ", "Please enter the correct sytax"
                    + " (L/SXXXX). X is a digit", "^(L|l)\\d{4}$").toUpperCase();
            Product pr = searchProduct(searchID);
            if (pr == null) {
                System.out.println("Product " + searchID + " is not in the list");
            } else {
                selectUpdate(pr);
            }
        }
    }

    private void selectUpdate(Product pr) {
        Menu m = new Menu();
        int choice;
        do {
            m.menuUpdate();
            choice = Validation.getInt("Input the data you want to update: ", "Please enter [1..8]", 1, 8);
            switch (choice) {
                case 1:
                    System.out.println("Before product update product name: ");
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                            " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
                    System.out.println(pr);
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    String afterPN = Validation.getString("Input name you want to update: ", "This field is required!");
                    pr.setProductName(afterPN);
                    System.out.println("Update successful!");
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                            " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
                    System.out.println(pr);
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+\n");
                    break;
                case 2:
                    System.out.println("Before product update type: ");
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                            " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
                    System.out.println(pr);
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    String afterType = Validation.getString("Input type you want to update: ", "This field is required!");
                    pr.setType(afterType);
                    System.out.println("Update successful!");
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                            " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
                    System.out.println(pr);
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+\n");
                    break;
                case 3:
                    System.out.println("Before product update quantity: ");
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                            " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
                    System.out.println(pr);
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    int afterQuantity = Validation.getInt("Input quantity you want to update: ", "Enter the appropriate value", 0, Integer.MAX_VALUE);
                    pr.setQuantity(afterQuantity);
                    System.out.println("Update successful!");
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                            " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
                    System.out.println(pr);
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+\n");
                    break;
                case 4:
                    System.out.println("Before product update price: ");
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                            " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
                    System.out.println(pr);
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    double afterPrice = Validation.getDouble("Input price you want to update: ", "Enter the appropriate value", 0, Double.MAX_VALUE);
                    pr.setPrice(afterPrice);
                    System.out.println("Update successful!");
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                            " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
                    System.out.println(pr);
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+\n");
                    break;
                case 5:
                    System.out.println("Before product update manufacturing date: ");
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                            " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
                    System.out.println(pr);
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    Date afterdateOM = Validation.getDate("Input the manufacturing date (DD/MM/YYYY): ", "Invalid date format. Please re-enter.");
                    pr.setDateOfManufacture(afterdateOM);
                    System.out.println("Update successful!");
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                            " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
                    System.out.println(pr);
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+\n");
                    break;
                case 6:
                    System.out.println("Before product update expiration date: ");
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                            " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
                    System.out.println(pr);
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    Date afterdateEx = Validation.getDate("Input the expiration date (DD/MM/YYYY): ", "Invalid date format. Please re-enter.");
                    pr.setExpirationDate(afterdateEx);
                    System.out.println("Update successful!");
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                    System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                            " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
                    System.out.println(pr);
                    System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+\n");
                    break;
                case 7:
                    break;
            }
        } while (choice != 7);
    }

    public void showProduct() {
        if (p.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
            System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                    " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
            System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");

            for (Product pr : p) {
                System.out.println(pr);
            }
            System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
            System.out.println("There are: " + p.size() + " products in the list");
        }
    }

    public void reportProduct(Product pr) {
        System.out.println(pr);
    }

    public void deleteProduct() {
        if (p.isEmpty()) {
            System.out.println("The list is emty.");
        } else {
            showProduct();
            String searchID = Validation.getFormat("Input ID do you want to delete (L/SXXXX): ", "Please enter the correct sytax"
                    + " (L/SXXXX). X is a digit", "^(L|l)\\d{4}$").toUpperCase();
            Product pr = searchProduct(searchID);
            if (pr == null) {
                System.out.println("Product with " + pr + " ID is not in the list");
            } else {
                System.err.println("This is the product you want to remove: ");
                System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                        " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
                System.out.println(pr);
                System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
                String check = Validation.getFormat("Are you sure you want to remove? (Y/N): ", "Only (Y/N)", "Y|y|N|n");

                if (check.equalsIgnoreCase("Y")) {
                    p.remove(pr);
                    System.out.println("Remove ID: " + pr.getProductID() + " successful!");
                }
            }
        }
    }
    
    public boolean saveToFile(String path) {
        if (path.isEmpty())
            System.out.println(path + " is emty.");
        try {
            FileWriter fw = new FileWriter(new File(path));
            for (Product pr : p) {
                fw.write(pr.showScreen() + "\n");
            }
            fw.close();
            System.out.println("\u001B[1mSave to file cars.txt successfull.\u001B[0m");
            return true;
        } catch (Exception e) {
            System.out.println("Error saving file " + path + " error!");
            return false;
        }
    }
}
