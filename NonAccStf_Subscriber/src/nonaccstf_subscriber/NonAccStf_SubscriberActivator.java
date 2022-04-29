package nonaccstf_subscriber;

import nonaccstf_cleaningpublisher.CleaningPublish;
import nonaccstf_repairpublisher.RepairPublish;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class NonAccStf_SubscriberActivator implements BundleActivator {
	
	ServiceReference serviceReference01;
	ServiceReference serviceReference02;

	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("\n****Start of Non Academic Staff Subscriber****");
		
		try {
			
			while(true) {
				
				System.out.println("\n---Welcome to the Non Academic staff Services---\n");
				
				//Enter Name
				System.out.println("Enter Your Name :");
				
				BufferedReader Name_in = new BufferedReader(new InputStreamReader(System.in));
				String name_in = Name_in.readLine();
				
				//Enter Id Number
				System.out.println("Enter Your ID number :");
				
				BufferedReader ID_in = new BufferedReader(new InputStreamReader(System.in));
				String id_in = ID_in.readLine();
				
				System.out.println("\n-----Please select the service -----");
				
				System.out.println("\nClearing Service -> [1]");
				System.out.println("Repair Service -> [2]\n");
				
				//Service selecting
				System.out.println("Enter the selected service :");
				
				BufferedReader Task_in = new BufferedReader(new InputStreamReader(System.in));
				int task_in = Integer.parseInt(Task_in.readLine());
				
				//Exiting the loop if user entered a blank line
				if(task_in == 0) {
					break;
				}
				
				//Cleaning Publisher
				else if(task_in == 1) {
					
					System.out.println("\n---Hello!! Welcome to the Clearing Service---");
					System.out.println("\nEnter a blank line to exit");
					
					String place = ""; 
					
					BufferedReader Place_in = new BufferedReader(new InputStreamReader(System.in));
					//String place_in = Place_in.readLine();
					
					System.out.println("\nSearch place here(place1-place20) :");
					place = Place_in.readLine();
					
					boolean isContinue = true;
					
					while(isContinue) {
						
     					serviceReference01 = context.getServiceReference(CleaningPublish.class.getName());
						CleaningPublish cleaningPublish = (CleaningPublish)context.getService(serviceReference01);
						
						//Exiting the loop if user entered a blank line
						
						if(place.length() == 0)
						{
							break;
						}	
						
						//If there is no room then display no
						else if(cleaningPublish == null){
							System.out.println("\nSorry Clearing service is not available\n");						
						}
						else if(cleaningPublish.cleaningPublish(place)){
							System.out.println("\nThe place is available now\n");	
						}
						else {		
							System.out.println("\nSorry this place is not available\n");	
						}	
						
						BufferedReader ans = new BufferedReader(new InputStreamReader(System.in));
						System.out.println("Do you want to continue: Yes/No :");
						String answer = ans.readLine();
				
						if(answer.equalsIgnoreCase("No")) {
							isContinue=false;
						}else if(answer.equalsIgnoreCase("Yes")) {
							
							System.out.println("\nSearch place here(place1-place20) :");
							place = Place_in.readLine();
						}					
					}
				}
				
				//Repair Service
				else if(task_in == 2) {
					
					System.out.println("\n---Hello!! Welcome to the Repair Service---");
					System.out.println("(Enter a blank line to exit)");
					String mechanic = ""; 
					
					serviceReference02 = context.getServiceReference(RepairPublish.class.getName());
					RepairPublish repairPublish = (RepairPublish)context.getService(serviceReference02);
					
					while(true) {
						
						System.out.println("\nSearch the mechanic you want to find here :");
						BufferedReader doc_in = new BufferedReader(new InputStreamReader(System.in));
						mechanic = doc_in.readLine();
						
						if(mechanic.length()==0){
							
							break;
						}
						
						else {
							repairPublish.repairPublish(mechanic);
						}
					  System.out.println("\n(Enter a blank line to exit)");
					}
				}else{
						System.out.println("\n**Pleace Enter valid Service Number**");
					}
				}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		
       System.out.println("Good Bye !!!");
	
	}

}
