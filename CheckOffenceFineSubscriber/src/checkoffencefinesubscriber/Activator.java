package checkoffencefinesubscriber;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import checkoffencefinepublisher.CheckOffenceFineService;
import checkoffencefinepublisher.CheckOffenceFine;

public class Activator implements BundleActivator {

	private BundleContext m_context;
	
	private ServiceTracker m_tracker;


	public void start(BundleContext bundleContext) throws Exception {
		m_context = bundleContext;
		
		m_tracker = new ServiceTracker (
			m_context,
			m_context.createFilter(
				"(&(objectClass" + CheckOffenceFineService.class.getName() + ")"),
			null);
		m_tracker.open();
				
		try
		{
			System.out.println("Enter a blank licence ID to exit");
			String licenceId = "";
			int offenceId;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while (true) {
				
				System.out.println("Enter Drivers Licence ID: ");
				licenceId = br.readLine();
				
				System.out.println("Enter offence ID: ");
				offenceId = br.read();
				
				CheckOffenceFineService offence = (CheckOffenceFineService) m_tracker.getService();
				
					if(licenceId.length() == 0) {
						break;
					}
					else {
						offence.getFineForOffence(offenceId, licenceId);
					}
			}
			
		}catch (Exception ex) {}
		
	}

	public void stop(BundleContext bundleContext) throws Exception {

	}

}
