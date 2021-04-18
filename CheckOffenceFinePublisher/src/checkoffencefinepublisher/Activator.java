package checkoffencefinepublisher;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator, ServiceListener {

	private CheckOffenceFineService service;
	private ServiceTracker checkOffenceFineServiceTracker;
	private BundleContext fContext;

	@Override
	public void start(BundleContext context) throws Exception {
		fContext = context;
		service = new CheckOffenceFineServiceImpl();

		Hashtable<String, ?> props = new Hashtable<>();
		// register the service
		context.registerService(CheckOffenceFineService.class.getName(), service, props);

		// create a tracker and track the service
		checkOffenceFineServiceTracker = new ServiceTracker<>(context, CheckOffenceFineService.class.getName(), null);
		checkOffenceFineServiceTracker.open();

		// have a service listener to implement the whiteboard pattern
		fContext.addServiceListener(this, "(objectclass=" + CheckOffenceFine.class.getName() + ")");

		// grab the service
		service = (CheckOffenceFineService) checkOffenceFineServiceTracker.getService();

		// register the dictionary
		System.out.println("stasjvdjahkvsdjlk");
		service.registerCheckOffenceFine(new CheckOffenceFineImpl());
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// close the service tracker
		checkOffenceFineServiceTracker.close();
		checkOffenceFineServiceTracker = null;

		service = null;
		fContext = null;
	}

	public void serviceChanged(ServiceEvent ev) {
		ServiceReference<?> sr = ev.getServiceReference();
		switch(ev.getType()) {
			case ServiceEvent.REGISTERED:
			{
				CheckOffenceFine ob = (CheckOffenceFine) fContext.getService(sr);
				service.registerCheckOffenceFine(ob);
			}
			break;
			case ServiceEvent.UNREGISTERING:
			{
				CheckOffenceFine ob = (CheckOffenceFine) fContext.getService(sr);
				service.unregisterCheckOffenceFine(ob);
			}
			break;
		}
	}


}
