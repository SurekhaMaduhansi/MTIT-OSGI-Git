package std_laboratorypublisher;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Std_LaboratoryPub_Activator implements BundleActivator {

	private static BundleContext context;

	
	ServiceRegistration<?> LaboratoryPublisherRegistration;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {

		System.out.println("Laboratory Publisher Started !!");
		
		Hashtable<String,String> props = new Hashtable<>();
		props.put("Laboratory" , "University");
		
		LaboratoryPublish LabPublisherService = new LaboratoryPublishIml();
		
		LaboratoryPublisherRegistration = bundleContext.registerService(
				LaboratoryPublish.class.getName(), LabPublisherService, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {

		System.out.println("Laboratory Publisher Stopped !!");
		LaboratoryPublisherRegistration.unregister();
	}

}
