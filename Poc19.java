import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Poc19 {
	int id;
	String mobile;
	String name, email;

	public Poc19(int id, String mobile, String name, String email) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.name = name;
		this.email = email;
	}

	public static void main(String[] args) {
		
		String mobExp1 = "^[+][0-9]{2}[-]{1}.*\\d{10}";

		Scanner sc = new Scanner(System.in);

		List<Poc19> students = new ArrayList<Poc19>();
		/*students.add(new Poc19(100, "9283746579", "Tony", "tony@gmail.com"));
		students.add(new Poc19(101, "5637495736", "Steve", "steve@gmail.com"));
		students.add(new Poc19(102, "4837462524", "Bruce", "bruce@yahoo.com"));
		students.add(new Poc19(103, "9174536475", "Thor", "thor@yahoo.com"));*/

		System.out.println("Enter Details For 5 students :");
		int sId;
		String sMob, sName, sEmail;
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter ID :");
			sId = sc.nextInt();
			
			System.out.println("Enter Mobile :");
			sMob = sc.nextLine();
			while(!sMob.matches(mobExp1)) {
				sMob = sc.nextLine();
			}
			
			
			System.out.println("Enter name :");
			sName = sc.nextLine();
			
			System.out.println("Enter Email :");
			sEmail = sc.nextLine();
			
			students.add(new Poc19(sId, sMob, sName, sEmail))
		}
		
		Set<Poc19> obj = students.stream()
				.filter(st ->st.mobile.matches("^[98]"))
				.map(st -> st.name, st.id)
				.collect(Collectors.toSet());
		System.out.println("Set : " + obj);

		long count = students.stream().filter(student -> student.email.contains("gmail")).count();

		System.out.println(count);

	}

}
