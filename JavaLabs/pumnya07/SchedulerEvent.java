package JavaLabs.pumnya07;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SchedulerEvent implements Serializable {
    /** Идентификационный ключ сериализации. */
    private static final long serialVersionUID = -7434874844481140344L;
    /** Хранение даты мероприятия. */
    private String date;
    /** Хранение времени начала мероприятия. */
    private String time;
    /** Хранение длительности мероприятия. */
    private float duration;
    /** Хранение места проведения. */
    private String eventVenue;
    /** Хранение описания мероприятия. */
    private String description;
    /** Хранение участников мероприятия. */
    private List<String> participants;
	
	
    public SchedulerEvent(String date, String time, float dur, String eventVenue, String descr, String... part) {
        this.date = date;
        this.time = time;
        this.duration = dur;
        this.eventVenue = eventVenue;
        this.description = descr;
        this.participants = new ArrayList<>(part.length);
        this.participants.addAll(Arrays.asList(part));
    }
	
    public SchedulerEvent() {
        this.setDate(null);
        this.setDate(null);
        this.setTime(null);
        this.setDescription(null);
        this.setDuration(0);
        this.setVenue(null);
        this.participants = new ArrayList<>();
    }
    /**
     * Получение даты.
     * @return дату
     */
    public String getDate() {
        return this.date;
    }
    /**
     * Установка даты.
     * @param d - дата, которую нужно установить
     */
    public void setDate(final String d) {
        if (this.checkDate(d)) {
            this.date = d;
        }
    }
    /**
     * Проверка даты.
     * @param d - дата
     * @return - true, если дата подходит формату
     */
    private boolean checkDate(final String d) {
        if (d == null) {
            return false;
        }
        final String df = "dd.MM.yyyy";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(df);
            sdf.setLenient(false);
            sdf.parse(d);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    /**
     * Получение времени.
     * @return время
     */
    public String getTime() {
        return this.time;
    }
    /**
     * Установка времени.
     * @param t - время, которое нужно установить
     */
    public void setTime(final String t) {
        if (checkTime(t)) {
            this.time = t;
        }
    }
    /**
     * Проверка времени.
     * @param t - время
     * @return - true, если время подходит формату
     */
    private boolean checkTime(final String t) {
        if (t == null) {
            return false;
        }
        final String tf = "HH:mm";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(tf);
            sdf.setLenient(false);
            sdf.parse(t);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    /**
     * Получение длительности мероприятия.
     * @return длительность
     */
    public float getDuration() {
        return this.duration;
    }
    /**
     * Установка длительности.
     * @param dur - длительность,
     *           которую нужно установить
     */
    public void setDuration(final float dur) {
        this.duration = dur;
    }
    /**
     * Получение места проведения.
     * @return место проведения
     */
    public String getVenue() {
        return this.eventVenue;
    }

    /**
     * Установка места проведения.
     * @param venue - место проведения
     */
    public void setVenue(final String venue) {
        if (this.checkVenue(venue)) {
            this.eventVenue = venue;
        }
    }
    /**
     * Проверка на корректность
     * ввода места проведения.
     * @param venue - место проведения
     * @return true, если строка
     * удовлетворяет регулярному выражению
     */
    public boolean checkVenue(final String venue) {
        if (venue == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(
                "^[А-Я][а-я]+(\\s[А-Я]*[а-я]+)*[.?!]?");
        Matcher matcher = pattern.matcher(venue);
        return matcher.matches();
    }
    /**
     * Получение описания мероприятия.
     * @return описание
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Установка описания мероприятия.
     * @param desc - описание
     */
    public void setDescription(final String desc) {
        if (this.checkDesc(desc)) {
            this.description = desc;
        }
    }
    /**
     * Проверка на корректность
     * ввода описания.
     * @param desc - описание
     * @return true, если строка
     * удовлетворяет регулярному выражению
     */
    private boolean checkDesc(final String desc) {
        if (desc == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(
                "^[А-Я][а-я]+(\\s?[А-Я]?[а-я]+)+[.!?]$");
        Matcher matcher = pattern.matcher(desc);
        return matcher.matches();
    }
    /**
     * Получение участников мероприятия.
     * @return массив участников
     */
    public List<String> getParticipants() {
        return this.participants;
    }
    /**
     * Сеттер для участников.
     * @param part - набор участников
     */
    public void setParticipants(final List<String> part) {
        if (this.participants.size() == 0)
            this.participants.addAll(part);
    }
    /**
     * Установка участников мероприятия.
     * @param partAmount - количество участников
     * @return список участников
     * @throws IOException - при
     * некорректном считывании
     */
    public void fillParticipants(final int partAmount)
            throws IOException {
        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(System.in));
        System.out.format("Введите имена"
                + " %s участников.%n", partAmount);
        String name;
        this.participants = new ArrayList<>();
        for (int i = 0; i < partAmount; i++) {
            System.out.format("Участник №%d: ", i + 1);
            name = reader.readLine();
            if (checkName(name)) {
                this.participants.add(name);
            } else {
                i--;
            }
        }
    }
    /**
     * Проверка на корректность
     * ввода имени участника.
     * @param name - имя
     * @return true, если строка
     * удовлетворяет регулярному выражению
     */
    private boolean checkName(final String name) {
        if (name == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(
                "^[А-Я][а-я]*(\\s([А-Я]|[а-я])*)?");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    /**
     * Создание мероприятия.
     * @return новое мероприятие
     * @throws IOException - при
     * некорректном считывании
     */
    public static SchedulerEvent generate() throws IOException {
        Scanner in = new Scanner(System.in);
        SchedulerEvent se = new SchedulerEvent();
        System.out.print("Введите дату "
                + "мероприятия (дд.мм.гггг): ");
        se.setDate(in.nextLine());
        System.out.print("Введите время начала"
                + " мероприятия (чч:мм): ");
        se.setTime(in.nextLine());
        System.out.print("Введите длительность"
                + " мероприятия (в часах): ");
        se.setDuration(Float.parseFloat(in.nextLine()));
        System.out.print("Введите место проведения: ");
        se.setVenue(in.nextLine());
        System.out.print("Введите описание"
                + " мероприятия: ");
        se.setDescription(in.nextLine());
        System.out.print("Введите количество"
                + " участников: ");
        int amount = in.nextInt();
        in.nextLine();
        se.fillParticipants(amount);
        return se;
    }
    /**
     * Чтение данных из файла.
     * @param filename - имя файла
     * @return готовый объект класса
     */
    public static SchedulerEvent[] readFromFile(final String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        Scanner scan = new Scanner(fr);
        List<String> lst = new ArrayList<>();
        SchedulerEvent[] se = new SchedulerEvent[16];
        int i = 0;
        int temp = 0;
        while(scan.hasNextLine()) {
            se[i] = new SchedulerEvent();
            se[i].setDate(scan.nextLine());
            se[i].setTime(scan.nextLine());
            se[i].setDuration(Integer.parseInt(scan.nextLine()));
            se[i].setVenue(scan.nextLine());
            se[i].setDescription(scan.nextLine());
            temp = Integer.parseInt(scan.nextLine());
            while(temp > 0) {
                lst.add(scan.nextLine());
                temp--;
            }
            se[i++].setParticipants(lst);
            lst.clear();
        }
        scan.close();
        fr.close();
        return se;
    }
    /**
     * Создание мероприятия по-умолчанию.
     * @param isNull - определяет как создать объект
     * @return новое мероприятие
     */
    public static SchedulerEvent generate(final boolean isNull) {
        SchedulerEvent se = new SchedulerEvent();
        if (isNull) {
            se.setDate(null);
            se.setDate(null);
            se.setTime(null);
            se.setDescription(null);
            se.setDuration(0);
            se.setVenue(null);
            return se;
        } else {
            se.setDate("31.07.2001");
            se.setTime("11:20");
            se.setDescription("Мой день рождения!");
            se.setDuration(1.2f);
            se.setVenue("День Рождения!");
            se.setParticipants(
                    new ArrayList<>(Arrays.asList("Алекс", "Мама", "Доктора")));
            return se;
        }
    }
    /**
     * Переопределение toString().
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Дата: ").append(this.getDate()).append("\n");
        builder.append("Время начала: ").append(
                this.getTime()).append("\n");
        builder.append("Длительность (часы): ").append(
                this.getDuration()).append("\n");
        builder.append("Место проведения: ").append(
                this.getVenue()).append("\n");
        builder.append("Описание: ").append(
                this.getDescription()).append("\n");
        builder.append("Участники: ");
        if (this.getParticipants() != null) {
            for (String name : this.getParticipants()) {
                builder.append(name).append(" ");
            }
        } else {
            builder.append("null");
        }
        return builder.append("\n").toString();
    }
    /**
     * Переопледеление метода equals().
     * @param obj входной объект
     * @return true при полном сходстве
     */
    @Override
    public boolean equals(Object obj) {
        return (this.toString().equals(obj.toString()));
    }
}
