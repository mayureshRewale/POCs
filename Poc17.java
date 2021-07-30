import java.io.*;

public class Poc17 {
	 float engineDisplay;
	 int maxPower;
	 String fuelType,tyreType;

	  public Poc17(float engineDisplay, int maxPower, String fuelType, String tyreType) {
	  this.engineDisplay = engineDisplay;
	  this.maxPower = maxPower;
	  this.fuelType = fuelType;
	  this.tyreType = tyreType;
	 }

	 @Override
	 protected Object clone() throws CloneNotSupportedException {
	  return super.clone();
	 }

	public static void main(String[] args) throws CloneNotSupportedException {
		
		ObjectOutputStream os=null;
		  ObjectInputStream is=null;
		  String file="resources/pulsorDetails.txt";
		  Poc17 pulsor=new Poc17(172.2f,10,"Disel","Tubeless");
		  Poc17 pulsor1=(Poc17)pulsor.clone();
		  Poc17 pulsor2=(Poc17)pulsor.clone();
		  Poc17 pulsor3=(Poc17)pulsor.clone();
		  Poc17 pulsor4=(Poc17)pulsor.clone();
		  Poc17 pulsor5=(Poc17)pulsor.clone();

		  Poc17[] pulsorObj=new Poc17[5];
		  for(int i=0;i<5;i++) {
		   pulsorObj[i]=(Poc17)pulsor.clone();
		  }

		  try {
		   os=new ObjectOutputStream(new FileOutputStream(file));
		   for(Poc17 p:pulsorObj) {
		    os.writeObject(p);
		   }
		   is=new ObjectInputStream(new FileInputStream(file));
		   while(true) {
		    Poc17 p_details=(Poc17)is.readObject();
		    System.out.println("Engine Details: "+p_details.engineDisplay+"\t Maximum Power: "+p_details.maxPower+"\t Fuel Type: "+p_details.fuelType+"\t Tyre Type: "+p_details.tyreType);
		   }

		  } 
		  catch (FileNotFoundException e) {

		   e.printStackTrace();
		  } 
		  catch(ClassNotFoundException e) {
		   e.printStackTrace();
		  }
		  catch(EOFException eof) {
		   System.out.println("These were all information about the clones of Pulsor Bike");
		  }
		  catch(Exception e) {
		   e.printStackTrace();
		  }
		  finally {
		   try {
		   if(os!=null)
		    os.close();

		   if(is!=null)
		    is.close();
		   }
		   catch(Exception e) {
		    e.printStackTrace();
		   }
		  }

	}

}
