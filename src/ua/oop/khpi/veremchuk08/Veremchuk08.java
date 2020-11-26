package ua.oop.khpi.veremchuk08;

import ua.oop.khpi.veremchuk07.BuyersGuide;

import java.io.IOException;
import java.util.Scanner;

public class Veremchuk08 {
    private Veremchuk08(){}
    /**
     * An entry point, the main method
     *
     * @param args - arguments
     */
    public static void main(String[] args) throws IOException {
        BuyersGuide [] stores = new BuyersGuide[0];
        Scanner in = new Scanner(System.in);
        String choice;
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
                    UI.saveToFile(stores);
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
                    System.out.println("Введите номер"
                            + " одного из пунктов!\n");
            }
        } while (!choice.equals("0"));
    }
}


