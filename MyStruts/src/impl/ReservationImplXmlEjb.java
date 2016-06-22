package impl;

import java.io.File;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import ifaces.IReservationDAO;
import beans.EjbReservation;
import beans.Reservation;
import by.epamlab.ejbs.ReservationSvHome;
import by.epamlab.ejbs.ReservationSvRemote;


public class ReservationImplXmlEjb implements IReservationDAO {

	public Reservation getReservation(String fileName) {
		try {
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.PROVIDER_URL, "localhost:1099");
			//return new InitialContext(properties);
			// Get an initial context
			InitialContext jndiContext = new InitialContext(properties);
			Object ref = jndiContext.lookup("ReservationSv");
			ReservationSvHome home = (ReservationSvHome) PortableRemoteObject.narrow(ref, ReservationSvHome.class);
			ReservationSvRemote reservation = home.create();
			File file = reservation.getFile(fileName);
			return new EjbReservation(reservation.getCode(file), reservation.getDescription(file), file);
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>ERROR>>>>>>>>>>>>\nReservationImplXmlEjb > getReservation:\n" + e.getMessage() + "\n");
		}
		return null;
	}
}
