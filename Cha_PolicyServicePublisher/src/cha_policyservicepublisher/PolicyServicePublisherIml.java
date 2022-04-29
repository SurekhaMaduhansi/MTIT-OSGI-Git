package cha_policyservicepublisher;

import java.util.HashMap;
import java.util.Map;

public class PolicyServicePublisherIml implements PolicyServicePublisher{
	
	
	Map<String, String> PolicyMap=new HashMap<String,String>();
	
	PolicyServicePublisherIml(){
		
		PolicyMap.put("policy1" ,"\nThis is the policy 1\nYou should bring your id cards.\nYou should bring your vaccination card.\n");
		PolicyMap.put("Enteranace Policy" ,"\\n\\n When entering the university wear masks ----");
		PolicyMap.put("Things checked in the university Permises" , "\n\n Bring the vaccination card and Student ID --- ");
		PolicyMap.put("Students should brings" , "\n\n Students should wear masks in the university permisses ---");
		
	}

	@Override
	public void PolicyServicePublisher(String Policy) {
		// TODO Auto-generated method stub
		if(PolicyMap.containsKey(Policy)){
			
			System.out.println(PolicyMap.get(Policy));
			
		}
		
		else {
			System.out.println("The Policy entered is not yet published in the university");
		}
	}

	
}
