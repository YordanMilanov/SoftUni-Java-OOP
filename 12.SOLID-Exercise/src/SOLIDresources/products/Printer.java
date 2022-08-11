package SOLIDresources.products;

import SOLIDresources.CalorieCalculator;

import java.util.List;

public class Printer {


    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";


    public void print(String format, double amount) {
        System.out.printf((AVERAGE) + "%n", amount);
    }
}
