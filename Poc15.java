import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Poc15 {

	/*
	 * static File fileRead;
	 * 
	 * static File fileWrite = null;
	 * 
	 * static FileReader fileReader = null; static BufferedReader bufferedReader =
	 * null;
	 * 
	 * static FileWriter fileWriter = null; static BufferedWriter bufferedWriter =
	 * null;
	 * 
	 * static String emailPath = "resources/Poc15Email.txt"; static String
	 * domainPath = "resources/Poc15Domain.txt";
	 */

	public static void main(String[] args) {

		/*
		 * Accept the email id's from user and store these in to a file named as
		 * emails.txt. Copy domain only from this emails.txt and write into another file
		 * named as domains.txt. Pass these file names from command line only.
		 */

		File fileRead = null, fileWrite = null;

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		String emailPath = "resources/Poc15Email.txt";
		String domainPath = "resources/Poc15Domain.txt";

		System.out.println("Enter Email : ");
		Scanner sc = new Scanner(System.in);

		String uEmail = sc.nextLine();

		writeEmail(uEmail, emailPath, fileWrite, fileWriter, bufferedWriter);
		writeDomain(uEmail, domainPath, emailPath, fileWrite, fileWriter, bufferedWriter, fileRead, fileReader, bufferedReader);

	}

	public static void writeDomain(String uEmail, String domainPath, String emailPath,File fileWrite, FileWriter fileWriter,
			BufferedWriter bufferedWriter, File fileRead, FileReader fileReader, BufferedReader bufferedReader) {
		
		try {
			System.out.println("writeDomain");
			fileWrite = new File(domainPath);
			fileWriter = new FileWriter(fileWrite);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			fileRead = new File(emailPath);
			fileReader = new FileReader(fileRead);
			bufferedReader = new BufferedReader(fileReader);
			
			String line = null;
			
			while((line = bufferedReader.readLine()) != null) {
				//line.indexOf("@");
				//line.substring(line.indexOf("@"));
				
				bufferedWriter.write((line.substring(line.indexOf("@"))) + "\n");
				System.out.println((line.substring(line.indexOf("@"))) + " Done\n");
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public static void writeEmail(String email, String emailPath, File fileWrite, FileWriter fileWriter, BufferedWriter bufferedWriter) {
		
		try {
			System.out.println("writeEmail");
			fileWrite = new File(emailPath);
			fileWriter = new FileWriter(fileWrite);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(emailPath + "\n");
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
