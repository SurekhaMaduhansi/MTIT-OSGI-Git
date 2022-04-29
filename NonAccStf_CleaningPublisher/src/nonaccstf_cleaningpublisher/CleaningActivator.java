package nonaccstf_cleaningpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class CleaningActivator implements BundleActivator {
	
	ServiceRegistration cleaningPublishRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Cleaning Publisher Start");
		
		CleaningPublish cleanPublisherService = new CleaningPublishImpl();
		
		cleaningPublishRegistration = context.registerService(CleaningPublish.class.getName(), cleanPublisherService, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Clearing Publisher Stop");
		
		cleaningPublishRegistration.unregister();
	}

}
