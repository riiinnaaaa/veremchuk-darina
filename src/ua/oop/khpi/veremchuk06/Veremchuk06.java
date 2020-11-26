package ua.oop.khpi.veremchuk06;

import ua.oop.khpi.MyAnotherHelper.MySecondHelper;
import ua.oop.khpi.veremchuk03.Helper;
import ua.oop.khpi.veremchuk06.UI.UserChoice;

import java.io.*;
import java.util.Comparator;


public class Veremchuk06  {
	private Veremchuk06()  {
		/**
		 *      * An entry point - main method.
		 *      * @param args - arguments of main method
		 *      * @throws IOException - input/output exceptions
		 *      * @throws ClassNotFoundException - if class doesn't found
		 */
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException  {
		MyContainerMod container = new MyContainerMod();
		UserChoice choice;
		do {
			UI.mainMenu();
			choice = UI.enterChoice();
			System.out.println();
			if (choice == null) {
				System.out.println("An error has occurred.");
				continue;
			}
			switch (choice) {
				case AddValue:
					System.out.println("Adding new value...");
					System.out.print("Enter value: ");
					container.add(UI.getString());
					System.out.println();
					break;
				case RemoveValue:
					System.out.println("Removing value...");
					System.out.print("Enter value: ");
					if (container.remove(UI.getString())) {
						System.out.println("Success.\n");
					} else {
						System.out.println("Value not found.\n");
					}
					break;
				case Clear:
					System.out.println("Clearing...");
					container.clear();
					System.out.println("Done!\n");
					break;
				case ShowAll:
					System.out.println("All elements: ");
					System.out.println(container.toString() + "\n");
					break;
				case ContainCheck:
					System.out.println("Checking for contain...");
					System.out.print("Enter value: ");
					if (container.contains(UI.getString())) {
						System.out.println("Value contains in container.\n");
					} else {
						System.out.println("Value does not exist.\n");
					}
					break;
				case RunMyHelper:
					System.out.println( "A value of container elements to task:");
					System.out.println(container.toString() + "\n");
					final String[] lines =  Helper.DivString(container.toString());
					for (final String line : lines) {
						System.out.print( "A world: ");
						Helper.printSymbols(line);
						System.out.print( "Result: ");
						Helper.printSymbolNumbers(line);
			}
					System.out.println();
			break;
			case RunAnotherHelper:
				System.out.print("Enter text: ");
				String text = UI.getString();
				System.out.print("Enter word: ");
				String word = UI.getString();
				System.out.print("Enter sentence: ");
				String sentence = UI.getString();
				MySecondHelper builder = new MySecondHelper(text, word, sentence);
				container.add(text);
				container.add(word);
				container.add(sentence);
				container.add(builder.execute());
				System.out.println("Result: " + container.last() + "\n");
				break;
			case Compare:
					System.out.println("Compare: ");
					container.compare();
					System.out.println();
					break;
				case SortByLength:
					System.out.println("Sorting...");
					container.sort(Comparator.comparingInt(String::length));
					System.out.println("Result: "
							+ container.toString() + "\n");
					break;
				case Search:
					System.out.print("Enter searched string: ");
					String searchedStr = UI.getString();
					System.out.println("Searching...");
					int[] strIndexes = container.search(searchedStr);
					for (int i : strIndexes) {
						System.out.print(i + " ");
					}
					System.out.println();
					break;
				case Serialize:
					System.out.println("Serialization...");
					ObjectOutputStream oos = new ObjectOutputStream(
							new FileOutputStream("DataFile.dat"));
					oos.writeObject(container);
					oos.close();
					System.out.println("Done!\n");
					break;
				case Deserialize:
					System.out.println("Deserialization...");
					ObjectInputStream ois = new ObjectInputStream(
							new FileInputStream("DataFile.dat"));
					MyContainerMod getContainer =
							(MyContainerMod) ois.readObject();
					ois.close();
					System.out.println(getContainer.toString() + "\n");
					break;
				case Exit:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("An error has occurred.");
			}
		} while (UI.getChoice() != UserChoice.Exit);
	}

}


