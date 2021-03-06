package ua.oop.khpi.veremchuk07;

import java.io.*;
import java.util.*;

import java.util.List;

public class BuyersGuide implements Serializable {
	/** Identify key of serialization */
	private static final long serialVersionUID = 2845790659809642584L;
	/** Keep the name of store */
	private String name;
	/** Keep the address of store */
	private String address;
	/** Keep the numbers of store */
	private List<String> numbers;
	/** Keep the specialization of store */
	private String specialization;
	/** Keep a work time  of store */
	private HashMap<String,String> workTime;

	public BuyersGuide(String name, String address, String spec, HashMap<String, String> WT, String... nums) {
		this.name = name;
		this.address = address;
		this.numbers = new ArrayList<>(nums.length);
		this.numbers.addAll(Arrays.asList(nums));
		this.specialization = spec;
		this.workTime = WT;
	}

	public BuyersGuide() {
		this.setName(null);
		this.setAddress(null);
		this.numbers = new ArrayList<>();
		this.setWorkTime(null);
		this.setSpecialization(null);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getNumbers() {
		return this.numbers;
	}

	public void setNumbers(final List<String> part) {
		if (this.numbers.size() == 0)
			this.numbers.addAll(part);
	}

	public String getSpecialization() {
		return this.specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public HashMap<String, String> getWorkTime() {
		return this.workTime;
	}

	public void setWorkTime(HashMap<String, String> workTime) {
		this.workTime = workTime;
	}

	/**
	 * Load a numbers of stores.
	 * @param CountNumbers - count of numbers
	 * @throws IOException - при
	 * некорректном считывании
	 */
	public void fillNumbers(final int CountNumbers) throws  IOException{
		BufferedReader reader = new BufferedReader(
						new InputStreamReader(System.in));
		System.out.format("Введите номера"
				+ " %s торговых точек.%n", CountNumbers);
		String number;
		this.numbers = new ArrayList<>();
		for (int i = 0; i < CountNumbers; i++) {
			System.out.format("Номер №%d: ", i + 1);
			number = reader.readLine();
			this.numbers.add(number);
		}
	}

	public static BuyersGuide generate () throws IOException {
		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		BuyersGuide TestStore = new BuyersGuide();
		System.out.print("Введите название торговой точки: ");
		TestStore.setName(in.nextLine());
		System.out.print("Введите адрес торговой точки (Город, улица, номер дома): ");
		TestStore.setAddress(in.nextLine());
		System.out.print("Введите кол-во номеров у торговой точки: ");
		int amount = in.nextInt();
		in.nextLine();
		TestStore.fillNumbers(amount);
		System.out.print("Введите специализацию торговой точки: ");
		TestStore.setSpecialization(in.nextLine());

		System.out.print("Введите кол-во рабочих дней: ");
		int countOfWorkDays = in.nextInt();
		TestStore.workTime = new HashMap<>();
		String workingDayName;
		String workingTime;
		for (int i = 0; i < countOfWorkDays ; i++) {
			System.out.println("Рабочий день №: "+ (i+1));
			System.out.print("Введите день: ");
			workingDayName = in2.nextLine();
			System.out.print("Введите время работы: ");
			workingTime = in2.nextLine();
			TestStore.workTime.put(workingDayName, workingTime);
			System.out.println();
		}
		return TestStore;
	}

	/**
	 * Overriding of method toString().
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Название торговой точки: ").append(this.getName()).append("\n");
		builder.append("Адрес: ").append(
				this.getAddress()).append("\n");
		builder.append("Номер(а): ");
		if (this.getNumbers() != null) {
			for (String number : this.getNumbers()) {
				builder.append(number).append(" ");
			}
		} else {
			builder.append("null");
		}
		builder.append("\nСпециализация: ").append(this.getSpecialization()).append("\n");
		builder.append("Время работы (график):\n");
		Set<String> keys = workTime.keySet();
		for(String key : keys) {
			builder.append("День: ").append(key).append("\n");
			builder.append("Рабочее время: ").append(workTime.get(key)).append("\n\n");
		}
		return builder.toString();
	}
}
