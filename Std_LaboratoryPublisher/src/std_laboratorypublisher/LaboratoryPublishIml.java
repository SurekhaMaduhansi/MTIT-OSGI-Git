package std_laboratorypublisher;

import java.util.HashMap;
import java.util.Map;

public class LaboratoryPublishIml implements LaboratoryPublish{
	
	Map<String, String> LabMap = new HashMap<String, String>();
	
	LaboratoryPublishIml(){
		
		LabMap.put("mtit", "\n\tWeekEnd: BC01 Lab\n\tWeekDay: Lab1");
		LabMap.put("iup", "\n\tWeekEnd: Pc01 Lab\n\tWeekDay: Lab5");
		LabMap.put("sqa", "\n\tWeekEnd: Auditorium \n\tWeekDay: Lab3");
		LabMap.put("research project", "\n\tWeekEnd: Lab 5\n\tWeekDay: BC05 Lab");
		LabMap.put("machine learning", "\n\tWeekEnd: BC01 Lab\n\tWeekDay: Lab1");
	}
	
	@Override
	public void LaboratoryPublish(String lab) {
		
		if(LabMap.containsKey(lab)) {
			
			System.out.println(LabMap.get(lab));
			
		}
		else {
			System.out.println("\nThe Laboratory you searched for is not available");
		}
	}

}
