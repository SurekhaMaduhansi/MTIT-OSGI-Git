package nonaccstf_repairpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class RepairActivator implements BundleActivator {

	ServiceRegistration repairPublishRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Repair Publisher Start");
		
		RepairPublish repairPublisherService = new RepairPublishImpl();
		
		repairPublishRegistration = context.registerService(RepairPublish.class.getName(), repairPublisherService, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Repair Publisher Stop");
		
		repairPublishRegistration.unregister();
	}

}
