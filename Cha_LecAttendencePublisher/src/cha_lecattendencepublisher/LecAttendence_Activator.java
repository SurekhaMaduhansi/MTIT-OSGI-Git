package cha_lecattendencepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class LecAttendence_Activator implements BundleActivator {

	private static BundleContext context;
	
	ServiceRegistration<?> LecServicePublisher;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {

		//System.out.println("Policy Service Start...");
		
		LecAttendencePublisherIml lecService = new LecAttendencePublisherIml();
		
		LecServicePublisher = bundleContext.registerService(LecAttendencePublisherIml.class.getName(),lecService, null);
		LecAttendence_Activator.context = bundleContext;
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		LecAttendence_Activator.context = null;
	}

}
