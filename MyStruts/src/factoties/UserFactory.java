package factoties;

import ifaces.IUserDAO;
import impl.EjbUserImpl;
import impl.MemoryUserImpl;

public class UserFactory {
	public static IUserDAO getClassFromFactory() {
		//return  new MemoryUserImpl();
		return new EjbUserImpl();
	}
}
