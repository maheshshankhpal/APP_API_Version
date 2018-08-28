package sample;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Logic {
	
	Hashtable<String, OutputData> hashtable = new Hashtable<String, OutputData>(); 
	
	APPDetails split(String line) {
		APPDetails appDetails = new APPDetails();
		String[] data = line.split(",");
		
		appDetails.setAppName(data[0]);
		appDetails.setApiName(data[1]);
		appDetails.setApiVersion(Float.parseFloat(data[2]));

		return appDetails;
		
	}
	
	void process(List<APPDetails> listAppDetails) {
		for (APPDetails appDetails : listAppDetails) {
			OutputData data = new OutputData();
			data.setApiVersion(appDetails.getApiVersion());
			data.setAppName(appDetails.getAppName());
			
			 if(!hashtable.containsKey(appDetails.getApiName())) {
				 hashtable.put(appDetails.getApiName(), data );
			 }
			 else {
				 if(appDetails.getApiVersion() > (hashtable.get(appDetails.getApiName()).getApiVersion())) {
					 print(hashtable.get(appDetails.getApiName()).getAppName(),appDetails.getApiName(),hashtable.get(appDetails.getApiName()).getApiVersion());
					 
					 hashtable.put(appDetails.getApiName(), data);
				 }
				 else {
					 
					 if(appDetails.getApiVersion() == (hashtable.get(appDetails.getApiName()).getApiVersion())) {
						 data.setAppName(hashtable.get(appDetails.getApiName()).getAppName() + "," +appDetails.getAppName());
						 hashtable.put(appDetails.getApiName(),data);
					 }
					 else {
						 print(appDetails.getAppName(),appDetails.getApiName(),appDetails.getApiVersion());
					 }
					 
						// System.out.println(appDetails.getAppName());
					
					 
				 }
			 }
		}
		
		
	}
	
	void print(String appNames, String apiName, float f){
		for (String appName : appNames.split(",")) {
			System.out.println(appName+","+apiName+","+f);
		}
		
		
	}
}
