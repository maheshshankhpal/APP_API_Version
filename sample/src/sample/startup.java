package sample;

import java.util.List;

public class startup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		FileOperations f= new FileOperations();
		
		new Logic().process(f.readData());
	}

}
