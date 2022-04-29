package std_librarypublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Std_LibraryPub_Activator implements BundleActivator {

	private static BundleContext context;
	
	ServiceRegistration LibraryPublisherRegistration;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {

		System.out.println("Library Publisher Started");
		
		LibraryPublish LibPublisherService = new LibraryPublishIml();
		
		LibraryPublisherRegistration = bundleContext.registerService(
				LibraryPublish.class.getName(), LibPublisherService, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {

		System.out.println("Library Publisher Stopped !!");
		LibraryPublisherRegistration.unregister();
	}

}
