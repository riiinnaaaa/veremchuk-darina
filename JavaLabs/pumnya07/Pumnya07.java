package JavaLabs.pumnya07;

import java.io.IOException;
import java.util.Scanner;

public final class Pumnya07 {
    private Pumnya07() {
    }
    /**
     * Точка входа.
     * @param args - аргументы функции
     * @throws IOException - при
     * некорректном считывании
     */
    public static void main(final String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Сколько мероприятий"
                       + " добавить? ");
        int size = scan.nextInt();
        scan.nextLine();
        SchedulerEvent[] events = new SchedulerEvent[size];
        for (int i = 0; i < events.length; i++) {
            System.out.format("МЕРОПРИЯТИЕ %d:%n", i + 1);
            events[i] = SchedulerEvent.generate();
        }
        for (int i = 0; i < events.length; i++) {
            System.out.format("%nМЕРОПРИЯТИЕ %d:%n", i + 1);
            System.out.println(events[i].toString());
        }
    }
}
