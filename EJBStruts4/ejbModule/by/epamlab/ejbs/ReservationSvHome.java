package by.epamlab.ejbs;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface ReservationSvHome extends EJBHome {
	public ReservationSvRemote create() throws RemoteException, CreateException;
}
