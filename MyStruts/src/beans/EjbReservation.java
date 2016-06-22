package beans;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import by.epamlab.beans.reservations.FareFamily;
import by.epamlab.beans.reservations.ResComponent;
import by.epamlab.beans.reservations.customer.Customer;
import by.epamlab.ejbs.CustomerSv;
import by.epamlab.ejbs.CustomerSvHome;
import by.epamlab.ejbs.FareFamilySv;
import by.epamlab.ejbs.FareFamilySvHome;
import by.epamlab.ejbs.ReservationCompSv;
import by.epamlab.ejbs.ReservationCompSvHome;


public class EjbReservation extends Reservation {
	private File file;

	public EjbReservation() {
	}

	public EjbReservation(String code, String description, File file) {
		super(code, description, null);
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public FareFamily getFareFamily() {
		FareFamily fareFamily = super.getFareFamily();
		if (fareFamily == null) {
			try {
				Properties properties = new Properties();
				properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
				properties.put(Context.PROVIDER_URL, "localhost:1099");
				// Get an initial context
				InitialContext jndiContext = new InitialContext(properties);
				Object ref = jndiContext.lookup("FareFamilySv");
				FareFamilySvHome home = (FareFamilySvHome) PortableRemoteObject.narrow(ref, FareFamilySvHome.class);
				FareFamilySv fareFamilySv = home.create();
				fareFamily = fareFamilySv.getFareFamily(file);
			} catch (Exception e) {
				System.out.println(
						">>>>>>>>>>>ERROR>>>>>>>>>>>>\nEjbReservation > getFareFamily():\n" + e.getMessage() + "\n");
			}
		}
		return fareFamily;
	}

	@Override
	public Customer getCustomer() {
		Customer customer = super.getCustomer();
		if (customer == null) {
			try {
				Properties properties = new Properties();
				properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
				properties.put(Context.PROVIDER_URL, "localhost:1099");
				// Get an initial context
				InitialContext jndiContext = new InitialContext(properties);
				Object ref = jndiContext.lookup("CustomerSv");
				CustomerSvHome home = (CustomerSvHome) PortableRemoteObject.narrow(ref, CustomerSvHome.class);
				CustomerSv customerSv = home.create();
				customer = customerSv.getCustomer(file);
			} catch (Exception e) {
				System.out.println(
						">>>>>>>>>>>ERROR>>>>>>>>>>>>\nEjbReservation > getCustomer():\n" + e.getMessage() + "\n");
			}
		}
		return customer;
	}

	@Override
	public List<ResComponent> getReservationComponents() {
		return getComponents(super.getCode(), null);
	}

	public List<ResComponent> getResComponents(String code, String componentTypeCode) {
		return getComponents(code, componentTypeCode);
	}

	private List<ResComponent> getComponents(String code, String componentTypeCode) {
		List<ResComponent> resComponents = super.getReservationComponents();
		try {
			if (resComponents == null) {
				Properties properties = new Properties();
				properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
				properties.put(Context.PROVIDER_URL, "localhost:1099");
				// Get an initial context
				InitialContext jndiContext = new InitialContext(properties);
				Object ref = jndiContext.lookup("ReservationCompSv");
				ReservationCompSvHome home = (ReservationCompSvHome) PortableRemoteObject.narrow(ref,
						ReservationCompSvHome.class);
				ReservationCompSv components = home.create();
				if (componentTypeCode == null) {
					resComponents = components.getReservationComponents(code, file);
				} else {
					resComponents = components.getReservationComponents(code, componentTypeCode, file);
				}
			}
		} catch (Exception e) {
			System.out.println(
					">>>>>>>>>>>ERROR>>>>>>>>>>>>\nEjbReservation > getComponents():\n" + e.getMessage() + "\n");
		}
		return resComponents;
	}
}
