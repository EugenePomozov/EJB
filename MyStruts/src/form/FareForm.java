package form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

//import beans.FareFamily1;
import beans.User;
import by.epamlab.beans.reservations.FareFamily;

public class FareForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private FareFamily fareFamily;

	public FareFamily getFareFamily() {
		return fareFamily;
	}

	public void setFareFamily(FareFamily fareFamily) {
		this.fareFamily = fareFamily;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		fareFamily = user.getReservation().getFareFamily();
	}
}
