import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class POC14 {

	public static void main(String[] args) {

		File fileRead, fileWrite = null;

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		int countLine = 0;
		int countWord = 0;
		String[] words;

		try {

			fileRead = new File("resources/Poc14Read.txt");
			fileWrite = new File("resources/Poc14Write.txt");

			fileReader = new FileReader(fileRead);
			bufferedReader = new BufferedReader(fileReader);

			fileWriter = new FileWriter(fileWrite);
			bufferedWriter = new BufferedWriter(fileWriter);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				words = line.split(" ");
				for (String word : words) {
					if (word.equals("java")) {
						while (line != null) {
							System.out.println(line);
							bufferedWriter.write(line + "\n");
						}

					}
					countWord++;
				}
				countLine++;

			}
			System.out.println("Words : " + countWord);
			System.out.println("Lines : " + countLine);
			bufferedWriter.flush();

		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			try {
				if (fileReader != null)
					fileReader.close();
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (Exception e) {
				System.out.println("Exception : " + e);
			}
		}

	}

}
