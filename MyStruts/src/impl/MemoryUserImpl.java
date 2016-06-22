package impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.SAXException;

import beans.User;
import factoties.ReservationFactory;
import ifaces.IReservationDAO;
import ifaces.IUserDAO;

public class MemoryUserImpl implements IUserDAO {
	private static Map<String, Map<String, User>> users = new HashMap<String, Map<String, User>>();

	static {
		Map<String, User> user = new HashMap<String, User>();
		
		IReservationDAO reservationDAO = ReservationFactory.getClassFromFactory();
		try {
			user.put(
					"user",
					new User("user", reservationDAO.getReservation("0004257753")));
			users.put("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(String login, String password) {
		if (users.containsKey(login)) {
			Map<String, User> map = users.get(login);
			if (map.containsKey(password)) {
				return map.get(password);
			}
		}
		return null;
	}

	@Override
	public boolean checkUserName(String login) {
			return users.containsKey(login);
	}
}
