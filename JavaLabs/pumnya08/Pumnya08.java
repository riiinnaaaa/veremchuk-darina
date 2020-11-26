package JavaLabs.pumnya08;

import JavaLabs.pumnya07.SchedulerEvent;

import java.io.IOException;
import java.util.Scanner;

public final class Pumnya08 {
    private Pumnya08() {
    }
    /**
     * Точка входа, главный метод.
     * @param args - аргументы главного метода
     * @throws IOException - при неудачной
     * работе с файлами
     */
    public static void main(final String[] args) throws IOException {
        SchedulerEvent[] events = new SchedulerEvent[0];
        Scanner in = new Scanner(System.in);
        String choice;
        do {
            Dialog.mainMenu();
            choice = Dialog.getChoice();
            switch (choice) {
                case "1":
                    events = Dialog.addEvent(events);
                    break;
                case "2":
                    System.out.print("Введите индекс"
                            + " удаляемого мероприятия: ");
                    int index = in.nextInt();
                    events = Dialog.dropEvent(events, index);
                    break;
                case "3":
                    Dialog.printInfo(events);
                    System.out.println();
                    break;
                case "4":
                    Dialog.saveToFile(events);
                    break;
                case "5":
                    try {
                        SchedulerEvent[] newEvents = Dialog.loadFromFile();
                        Dialog.printInfo(newEvents);
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
