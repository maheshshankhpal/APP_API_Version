package sample;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class FileOperations {
	public ArrayList<APPDetails> readData() {
		ArrayList<APPDetails> list = new ArrayList<APPDetails>();
		
		 try {
			
			 String fileName = "C:\\Users\\dm365\\Documents\\workspace-sts-3.9.5.RELEASE\\sample\\src\\sample\\input.txt";

			 BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))); 
			 
			 String line = buffReader.readLine();
			 
			 while (line != null) { 
				 list.add(new Logic().split(line));
				 line = buffReader.readLine(); 
			 }
			 
			 buffReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}
