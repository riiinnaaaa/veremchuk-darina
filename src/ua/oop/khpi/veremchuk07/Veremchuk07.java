package ua.oop.khpi.veremchuk07;

import java.io.IOException;
import java.util.Scanner;

public class Veremchuk07 {
    /**
     * An entry point, the main method
     *
     * @param args - arguments of function
     */
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Сколько торговых точек"
                + " добавить? ");
        int size = scan.nextInt();
        scan.nextLine();
        BuyersGuide[]  stores = new BuyersGuide[size];
        for (int i = 0; i < stores.length; i++) {
            System.out.format("Торговая точка %d:%n", i + 1);
            stores[i] = BuyersGuide.generate();
        }
        System.out.println();
        for (int i = 0; i < stores.length; i++) {
            System.out.format("Торговая точка %d:%n", i + 1);
            System.out.println(stores[i].toString());
        }
    }
}
