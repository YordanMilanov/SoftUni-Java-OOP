import java.util.Scanner;

public class Rhombus_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //size of the rhombus
        int size = Integer.parseInt(scanner.nextLine());

        PrintTopHalf(size);

        PrintBottomHalf(size);
    }

    //2. then we take the for cycle for printing the top half and extract it to method to make it more readable
    private static void PrintTopHalf(int size) {
        for (int startCount = 1; startCount <= size; startCount++) {
            printRow(size, startCount);
        }
    }

    //3. then we take the for cycle for printing the bottom half and extract it to method to make it more readable
    private static void PrintBottomHalf(int size) {
        for (int startCount = size - 1; startCount > 0; startCount--) {
            printRow(size, startCount);
        }
    }


    //1.the abstraction here is that we take the printing code out in external method because it repeats twice
    // and repeats twice the same thing
    private static void printRow(int size, int startCount) {
        for (int i = 0; i < size - startCount; i++) {
            System.out.print(' ');
        }
        for (int i = 0; i < startCount - 1; i++) {
            System.out.print("* ");
        }

        System.out.println('*');
    }
}
