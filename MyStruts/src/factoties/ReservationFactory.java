package factoties;

import ifaces.IReservationDAO;
import impl.ReservationImplXml;
import impl.ReservationImplXmlEjb;

public class ReservationFactory {
	public static IReservationDAO getClassFromFactory() {
		//return new ReservationImplXml();
		return new ReservationImplXmlEjb();
	}
}
