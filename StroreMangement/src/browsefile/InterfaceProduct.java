package browsefile;

import java.util.ArrayList;

public interface InterfaceProduct<T> {
    boolean loadFromFile(String path, ArrayList<T> list);
    void saveToFile(String path, ArrayList<T> list);
}
