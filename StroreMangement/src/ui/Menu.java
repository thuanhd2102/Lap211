package ui;

import manageproduct.*;
import util.Validation;
import report.Report;

public class Menu {

    public void menuManageProduct(ManagerProduct p) {
        System.out.println("");
        System.out.println("             +-------Manage products-------+");
        System.out.println("             |1. Add a product.            |");
        System.out.println("             |2. Update product infomation.|");
        System.out.println("             |3. Delete product.           |");
        System.out.println("             |4. Show all product.         |");
        System.out.println("             |5. Exit.                     |");
        System.out.println("             +-----------------------------+");
        int choice = Validation.getInt("Input your choice: ", "Please enter [1..5]", 1, 5);
        switch (choice) {
            case 1:
                p.addProductLong();
                break;
            case 2:
                p.updateProduct();
                break;
            case 3:
                p.deleteProduct();
                break;
            case 4:
                p.showProduct();
                break;
            case 5:
                break;
        }
    }

    public void menuManageWarehouse(ManagerProduct mp) {
        System.out.println("Manage Warehouse");
        System.out.println("1. Create an import receipt.");
        System.out.println("2. Create an export receipt.");
    }

    public void menuReport(Report r, ManagerProduct mp) {
        int choice;
        do {
            System.out.println("");
            System.out.println("             +--------------------------------Report--------------------------------+");
            System.out.println("             |1. Products that have expired.                                        |");
            System.out.println("             |2. The products that the strore is selling.                           |");
            System.out.println("             |3. Products that are running out of stock (sorted in ascending order).|");
            System.out.println("             |4. Import/export receipt of a product.                                |");
            System.out.println("             |5. Exit.                                                              |");
            System.out.println("             +----------------------------------------------------------------------+");
            choice = Validation.getInt("Input your choice: ", "Please enter [1..5]", 1, 5);
            switch (choice) {
                case 1:
                    r.expiredProducts(mp.p);
                    break;
                case 2:
                    r.sellingProduct(mp.p);
                    break;
                case 3:
                    r.areRunningOutStock(mp.p);
                    break;
                case 4:
                    r.saveToFileProduct();
                case 5:
                    break;
            }

        } while (choice != 5);

    }

    public void menuUpdate() {
        System.out.println("1. Update for product name.");
        System.out.println("2. Update for type.");
        System.out.println("3. Update for quantity.");
        System.out.println("4. Update for price.");
        System.out.println("5. Update for date of manufacture.");
        System.out.println("6. Update for expiration date.");
        System.out.println("7. Exit.");
    }
}
