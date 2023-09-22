package managewarehouse;

import java.util.*;
import util.Validation;

public class ManagerWareHouse implements IManager{

    public ArrayList<WareHouse> wh;

    public void ManagerWareHouse() {
        wh = new ArrayList<>();
    }

    @Override
    public void createProduct() {
//        int code = wh.size() + 1;
//        String id = String.format("IM%05d", code);
//        String check;
//        do {
//            String idProduct = Validation.checkDuplicateID("Input ID (L/SXXXX): ", "Please enter the correct sytax"
//                    + " (L/SXXXX). X is a digit", "^(L|l|S|s)\\d{4}$", wh);
//            check = Validation.getFormat("Do you want to continue creating new product? (Y/N): ", "Only (Y/N)", "(Y|y|N|n)");
//        } while (!check.equalsIgnoreCase("N"));
    }
}
