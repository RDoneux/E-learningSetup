package settings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Constants {

	public static String font = "lucida Console";
	public static String masterFile = "L:\\COURSE STORE\\Totara Courses";

	private static File file = new File("settings/constants.txt");

	public static void loadSettings() {

		if (!file.exists()) {
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();

				saveSettings();

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {

			try {
				Scanner scan = new Scanner(file);

				font = scan.nextLine();
				masterFile = scan.nextLine();

				scan.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}

	}

	public static void saveSettings() {

		BufferedWriter write;
		try {
			write = new BufferedWriter(new FileWriter(file));

			write.write(font);
			write.newLine();
			write.write(masterFile);

			write.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
