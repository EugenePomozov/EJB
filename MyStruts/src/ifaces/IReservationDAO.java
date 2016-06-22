package ifaces;

import java.io.IOException;

import org.xml.sax.SAXException;

import beans.Reservation;

public interface IReservationDAO {
	Reservation getReservation(String fileName)throws IOException, SAXException;
}
