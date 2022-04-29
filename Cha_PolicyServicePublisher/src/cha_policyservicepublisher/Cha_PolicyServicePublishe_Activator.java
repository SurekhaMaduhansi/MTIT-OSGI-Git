package cha_policyservicepublisher;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Cha_PolicyServicePublishe_Activator implements BundleActivator {

	private static BundleContext context;
	
	ServiceRegistration<?> PolcyServicePublisherReg;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Policy Service Start...");
		
		Hashtable<String ,String> props=new Hashtable<>();
		props.put(" Policy " , " University ");
			
		PolicyServicePublisher PolicyService = new PolicyServicePublisherIml();
			
		PolcyServicePublisherReg = bundleContext.registerService(PolicyServicePublisherIml.class.getName(),PolicyService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Cha_PolicyServicePublishe_Activator.context = null;
		System.out.println("Policy Service stop !!!...");
	}

}
