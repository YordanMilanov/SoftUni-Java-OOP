package SOLIDresources;

import SOLIDresources.products.*;

import java.util.List;
import java.util.stream.Collectors;

public class CalorieCalculator {

    private final Printer printer;
    private static final String SUM_FORMAT = "Sum: %f";
    private static final String SUM_AVERAGE = "Average: %f";


    public CalorieCalculator() {
        this.printer = new Printer();
    }

    public double sum(List<Product> products) {

       final double sum = products.stream()
                .map(Product::getAmountOfCalories)
                .reduce(0.0, Double::sum);
       printer.print(SUM_FORMAT, sum);

       return sum;
    }

    public double average(List<Product> products) {
         final double amount = sum(products) / products.size();
         this.printer.print(SUM_AVERAGE, amount);
         return amount;
    }

}
