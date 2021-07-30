import java.io.*;
import java.io.Serializable;
import java.util.*;

public class Poc16 implements Serializable, Comparable<Poc16> {

	int empId, esal, dno;
	String empName;

	public Poc16(int empId, int esal, int dno, String empName) {
		this.empId = empId;
		this.esal = esal;
		this.dno = dno;
		this.empName = empName;
	}

	public static void main(String[] args) {

		Map<String, Integer> empMSal = new TreeMap<String, Integer>();
		ArrayList<Poc16> ai = new ArrayList<Poc16>();
		
		ObjectOutputStream os = null;
		ObjectInputStream is;
		String file = "resources/emp.db";

		String emp_name;
		int emp_id, emp_sal, d_no;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Poc16[] emp = new Poc16[5];
		
		try {
			for (int i = 0; i < emp.length; i++) {
				System.out.println("Enter Employee ID: ");
				emp_id = Integer.parseInt(br.readLine());
				
				System.out.println("Enter Employee Name: ");
				emp_name = br.readLine();
				
				System.out.println("Enter Employee Salary: ");
				emp_sal = Integer.parseInt(br.readLine());
				
				System.out.println("Enter Department Number: ");
				d_no = Integer.parseInt(br.readLine());
				
				emp[i] = new Poc16(emp_id, emp_sal, d_no, emp_name);
			}

			os = new ObjectOutputStream(new FileOutputStream(file));
			is = new ObjectInputStream(new FileInputStream(file));

			for (Poc16 ep : emp) {
				os.writeObject(ep);
			}

			while (true) {

				Poc16 empRead = (Poc16) is.readObject();
				if (empRead.dno == 10) {
					ai.add(empRead);
				}

			}

		} catch (EOFException eof) {
			System.out.println("The Following Information Inlcudes: ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			Collections.sort(ai, Collections.reverseOrder());
			int sal = ai.get(0).esal;
			for (Poc16 a : ai) {
				if (a.esal == sal)
					System.out.println("Employee Name: " + a.empName + "\t Employee Salary: " + a.esal);
			}

			try {
				if (os != null) {
					os.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public int compareTo(Poc16 e) {
		if (this.esal > e.esal)
			return 1;
		else if (this.esal < e.esal)
			return -1;
		else
			return 0;
	}

}
