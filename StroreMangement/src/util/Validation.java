package util;

import java.text.SimpleDateFormat;
import java.util.*;
import manageproduct.Product;
import managewarehouse.WareHouse;

public class Validation {

    public static final SimpleDateFormat dF = new SimpleDateFormat("dd/MM/yyyy");
    private static Scanner sc = new Scanner(System.in);

    /**
     * This is a function that checks an integer requiring the user to enter an
     * integer If it is not an integer, the function will ask the user to enter
     * again
     *
     * The two variables lowerBound and upBound are used to block values from
     * entering outside the specified range
     *
     * The variable error will show the user message error.
     *
     * @param msg
     * @param error
     * @param lowerBound
     * @param upBound
     * @return
     */
    public static int getInt(String msg, String error, int lowerBound, int upBound) {
        if (lowerBound > upBound) {
            int t = lowerBound;
            lowerBound = upBound;
            upBound = t;
        }

        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    /**
     * This is a function that checks a real number, requiring the user to enter
     * a real number If it is not a real number, the function will ask the user
     * to re-enter
     *
     * The two variables lowerBound and upBound are used to block values from
     * entering outside the specified range
     *
     * The variable error will show the user message error.
     *
     * @param msg
     * @param error
     * @param lowerBound
     * @param upBound
     * @return
     */
    public static double getDouble(String msg, String error, double lowerBound, double upBound) {
        if (lowerBound > upBound) {
            double t = lowerBound;
            lowerBound = upBound;
            upBound = t;
        }

        double n;
        while (true) {
            try {
                System.out.print(msg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    /**
     * The function is used to request input of a string and check if the string
     * meets the pattern condition If not, the function will request input again
     * and report an error.
     *
     * @param msg
     * @param error
     * @param format
     * @return
     */
    public static String getFormat(String msg, String error, String format) {
        String s;
        boolean match;
        while (true) {
            try {
                System.out.print(msg);
                s = sc.nextLine().trim();
                match = s.matches(format);
                if (s.isEmpty() || match == false) {
                    throw new Exception();
                }
                return s;
            } catch (Exception e) {
                System.err.println(error);
            }

        }
    }

    /**
     * This is a function that checks a string of characters If the user leaves
     * it blank, the request field will re-enter
     *
     * And the variable error will show the user message error.
     *
     * @param msg
     * @param error
     * @return
     */
    public static String getString(String msg, String error) {
        String s;
        while (true) {
            try {
                System.out.print(msg);
                s = sc.nextLine();
                if (s.isEmpty()) {
                    throw new Exception();
                }
                return s;
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    /**
     * The function processes date input and checks to see if the date is
     * reasonable If it is reasonable, it returns the date value Otherwise, it
     * will report an error and force the user to re-enter.
     *
     * @param msg
     * @param error
     * @return
     */
    public static Date getDate(String msg, String error) {
        while (true) {
            try {
                System.out.print(msg);
                String dateString = sc.nextLine().trim();
                String[] dateParts = dateString.split("/");
                if (dateParts.length != 3) {
                    throw new Exception();
                }

                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);

                if (isValidDate(day, month, year)) {
                    Date date = dF.parse(dateString);
                    return date;
                } else {
                    System.err.println("Invalid day or month. Please input again.");
                }
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    /**
     * The function checks the date for day, month, year and converts them from
     * date to number and checks if the date is valid.
     *
     * @param date
     * @return
     */
    private static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }

        return !(day < 1 || day > checkMonth(month, year));
    }

    /**
     * Function to check the month, the function uses an array of numbers so
     * that when passing the month in, the month will correspond to the numbers
     * in the array, and the leap year will return 29Function to check the
     * month, the function uses an array of numbers so that when passing the
     * month in, the month will correspond to the numbers in the array, and the
     * leap year will return 29
     *
     * @param month
     * @param year
     * @return
     */
    private static int checkMonth(int month, int year) {
        int[] dM = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return dM[month];
    }

    /**
     * The function will check if the year is a leap year.
     *
     * @param year
     * @return
     */
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * The function is used to check if there is the same ProductID If it is the
     * same, it returns false If it is correct, it returns true.
     *
     * @param p
     * @param id
     * @return
     */
    private static boolean isDuplicateProduct(ArrayList<Product> p, String id) {
        for (Product pr : p) {
            if (pr.getProductID().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This function prompts the user to enter a product ID and checks for
     * duplicates within the given ArrayList of products.
     *
     * @param inputMsg
     * @param error
     * @param p
     * @param format
     * @return
     */
    public static String checkDuplicateID(String inputMsg, String error, String format, ArrayList<Product> p) {
        while (true) {
            String productID = getFormat(inputMsg, error, format);

            if (!productID.matches(format)) {
                continue;
            }
            if (isDuplicateProduct(p, productID) == false) {
                System.out.println("Duplicated productID. Please input another one!");
                continue;
            }
            return productID;
        }
    }
}