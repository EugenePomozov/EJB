package impl;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;


import beans.User;
import ifaces.IReservationDAO;
import ifaces.IUserDAO;
import by.epamlab.ejbs.UserSvRemote;
import by.epamlab.ejbs.UserSvHome;
import factoties.ReservationFactory;


public class EjbUserImpl implements IUserDAO {

	@Override
	public User getUser(String login, String password) {
		try {
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.PROVIDER_URL, "localhost:1099");
			//return new InitialContext(properties);
			// Get an initial context
			InitialContext jndiContext = new InitialContext(properties);
			// Get a reference to the Bean
			Object ref = jndiContext.lookup("UserSv");
			// Get a reference from this to the Bean's Home interface
			UserSvHome home = (UserSvHome) PortableRemoteObject.narrow(ref, UserSvHome.class);
			// Create an UserSv object from the Home interface
			UserSvRemote user = home.create();
			String reservationFile = user.getReservation(login, password);
			if (!reservationFile.isEmpty()) {
				IReservationDAO reservationDAO = ReservationFactory.getClassFromFactory();
				return new User(login, reservationDAO.getReservation(reservationFile));
			}
		} catch (Exception e) {
			System.out.println("\nEjbUserImpl > getUser:\n" + e.getMessage() + "\n");
		}
		return null;
	}

	@Override
	public boolean checkUserName(String login) {
		// TODO Auto-generated method stub
		return true;
	}
}
