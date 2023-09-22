package main;

import manageproduct.ManagerProduct;
import report.Report;
import ui.Menu;
import util.Validation;

public class StroreMangement {

    public static void main(String[] args) {
        ManagerProduct mp = new ManagerProduct();
        Report r = new Report();
        mp.loadFromFile("./product.dat");
        
        Menu m = new Menu();
        int choice;
        do {
            System.out.println("");
            System.out.println("       +------Welcome to the Warehouse Management app------+");
            System.out.println("       |1. Manage products                                 |");
            System.out.println("       |2. Manage Warehouse                                |");
            System.out.println("       |3. Report                                          |");
            System.out.println("       |4. Store data to file                              |");
            System.out.println("       |5. Close the application                           |");
            System.out.println("       +---------------------------------------------------+");
            choice = Validation.getInt("Input your choice: ", "Please input [1..5]", 1, 5);
            switch (choice) {
                case 1:
                    m.menuManageProduct(mp);
                    break;
                case 2:
                    m.menuManageWarehouse(mp);
                    break;
                case 3:
                    m.menuReport(r, mp);
                    break;
                case 4:
                    mp.saveToFile("./product.dat");
                    break;
                case 5:
                    System.out.println("Thank you for using the product ^^.");
                    break;
            }
        } while (choice != 5);

    }

}
