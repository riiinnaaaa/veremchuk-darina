package ua.oop.khpi.veremchuk08;

import ua.oop.khpi.veremchuk07.BuyersGuide;

import java.io.IOException;
import java.util.Scanner;

public class Veremchuk08 {
    static BuyersGuide [] stores = new BuyersGuide[0];
    static String choice = "";
    static Scanner in = new Scanner(System.in);

    /**
     * An entry point, the main method
     *
     * @param args - arguments
     */

    public static void main(String[] args) throws IOException {
        stores = new BuyersGuide[0];
        do {
            UI.mainMenu();
            choice = UI.getChoice();
            switch (choice) {
                case "1":
                    stores = UI.addStore(stores);
                    break;
                case "2":
                    System.out.print("Введите индекс"
                            + " удаляемой торговой точки: ");
                    int index = in.nextInt();
                    stores = UI.dropStore(stores, index);
                    break;
                case "3":
                    UI.printInfo(stores);
                    System.out.println();
                    break;
                case "4":
                    UI.saveToFile();
                    break;
                case "5":
                    try {
                        BuyersGuide[] newStores = UI.loadFromFile();
                        UI.printInfo(newStores);
                    } catch (IOException e) {
                        System.out.println(e.toString());
                    }
                    break;
                case "0":
                    System.out.println("Выход...");
                    break;
                default:
                    System.out.println("Введите номер одного из пунктов!\n");
            }
        } while (!choice.equals("0"));
    }
}


