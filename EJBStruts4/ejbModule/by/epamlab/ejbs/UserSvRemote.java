package by.epamlab.ejbs;


import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface UserSvRemote extends EJBObject {
	public String getReservation(String login, String password) throws RemoteException;
}
