package chancellor_subscriber;

import cha_lecattendencepublisher.LecAttendencePublisher;
import cha_lecattendencepublisher.LecAttendencePublisherIml;
import cha_policyservicepublisher.PolicyServicePublisher;
import cha_policyservicepublisher.PolicyServicePublisherIml;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Chancellor_Sub_Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	ServiceReference PolicyserviceReference;
	ServiceReference LecturerAttendanceReference;

	public void start(BundleContext bundleContext) throws Exception {
		Chancellor_Sub_Activator.context = bundleContext;
		
		System.out.println("--------Chancellor --------");
		
		try {
			
			while(true) {
				
				System.out.println("\n---- Welcome to the Channcellor Service ----");
				
				//Enter Passcode
				System.out.println("Enter Your Passcode: ");
				
				BufferedReader passcode_in = new BufferedReader(new InputStreamReader(System.in));
				String passcode=passcode_in.readLine();
				
				System.out.println("\n\n------Please select the service------");

				System.out.println("\n1) Check the Lecturer attendence");
				System.out.println("2) Check the policies");
				
				
				//Service Selecting
				System.out.println("\nEnter the selected Service : ");
				
				BufferedReader service_in = new BufferedReader(new InputStreamReader(System.in));
				int service =Integer.parseInt(service_in.readLine());
				
				if(service==0) {
					break;
				}
				
				//Lecturer attendence service
				else if(service == 1)
				{
					System.out.println("\n* Welcome to the Lecturer attendance Service (Check whether the Lecturer is present Today--) *");
					System.out.println("\nEnter a blank line to exit");
					String lecturer= "";

					BufferedReader lec = new BufferedReader(new InputStreamReader(System.in));


					while(true) {

					System.out.println("\nSearch for lecturer attendence here :");
					lecturer = lec.readLine();

					LecturerAttendanceReference = context.getServiceReference(LecAttendencePublisherIml.class.getName());
					LecAttendencePublisher lecService= (LecAttendencePublisher)context.getService(LecturerAttendanceReference);

					//Exiting the loop if user entered a bank line

					if(lecturer.length() == 0)
					{
						break;
					}

					//If there is no book then display no
					else if(lecService == null)
					{
						System.out.println("\n Sorry ... No Lectuter matching .....\n");
						//break;
					}

					else if(lecService.LecAttendencePublisher(lecturer))
					{
					System.out.println("\nThis Lecturer is Present Today----- \n");
					//break;

					}

					else {

					System.out.println("\nSorry this Lecturer is Absent Today------\n");
					//break;
						}
					}
				}
				
				//policy service
				else if(service == 2)
				{
					System.out.println("\n\n Welcome to Policy Service ");
					System.out.println("(Enter a blank line to exsit)");
					String policy ="";
					
					PolicyserviceReference = context.getServiceReference(PolicyServicePublisherIml.class.getName());
					PolicyServicePublisher policyService=(PolicyServicePublisher) context.getService(PolicyserviceReference);
					
					
					while(true) {
						
						System.out.println("\n\n View the policies in the University : ");
						BufferedReader policy_in = new BufferedReader(new InputStreamReader(System.in));
						policy=policy_in.readLine();
						
						
						if(policy.length() ==0) {
							
							break;
						}
						else {
							policyService.PolicyServicePublisher(policy);
						}
					}
					
				}
				
				else {
					System.out.println("Error!!");
					
				}
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Chancellor_Sub_Activator.context = null;
		System.out.println("Chancellor Subscriber service stopped !!");
	}

}
