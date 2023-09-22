package browsefile;

import java.io.*;
import java.text.ParseException;
import java.util.*;
import manageproduct.Product;
import util.Validation;

public class FileProduct implements InterfaceProduct<Product>{
    
    @Override
    public boolean loadFromFile(String path, ArrayList<Product> list) {
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

                list.add(new Product(id, name, type, dateOfManufacture, expirationDate, quantity, price));
            }
            System.out.println("Import data successful!");
            return true;
        } catch (IOException | NumberFormatException | ParseException e) {
            System.err.println("Load file error!");
            return false;
        }
    }

    @Override
    public void saveToFile(String path, ArrayList<Product> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
