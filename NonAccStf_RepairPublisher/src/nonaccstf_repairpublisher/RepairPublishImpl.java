package nonaccstf_repairpublisher;

import java.util.HashMap;
import java.util.Map;

public class RepairPublishImpl implements RepairPublish{
	
	Map<String, String> MacMap = new HashMap<String, String>();
	
	RepairPublishImpl(){
		
		MacMap.put("kasun", "\n\tMr.Kasun Rajapaksha.\n\t0718910146\n\tArrival Times-> Monday-Wednesday -> 8am - 7pm ");
		MacMap.put("pasan", "\n\tMr.Pasan Bandara.\n\t0712340520\n\tArrival Times-> Monday-Friday -> 8am - 5pm ");
		MacMap.put("udara", "\n\ttMr.Udara Gamage.\n\t0776519953\n\tArrival Times-> Wednesday-Sunday -> 8am - 6pm ");
		MacMap.put("amila", "\n\ttMr.Amila Perera.\n\t0725678946\n\tArrival Times-> thursday-Saturday -> 8am - 4pm ");
	}

	@Override
	public void repairPublish(String mechanic) {
		// TODO Auto-generated method stub
		if(MacMap.containsKey(mechanic)) {
					
				System.out.println(MacMap.get(mechanic));
					
				}
				else {
					System.out.println("The Machanic, You searched for is not working inside the university");
				}	
	}

	@Override
	public String repairPublish() {
		// TODO Auto-generated method stub
		return null;
	}
}
