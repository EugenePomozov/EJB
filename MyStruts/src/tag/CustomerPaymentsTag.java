package tag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import beans.User;

public class CustomerPaymentsTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	private String prop;		//payments
	private String source;		//user

	public int doStartTag() throws JspException {
		User user = (User) pageContext.getAttribute(source,
				PageContext.SESSION_SCOPE);
		List<by.epamlab.beans.reservations.customer.Payment> payments = user.getReservation().getCustomer()
				.getPayments();
		pageContext.getRequest().setAttribute(prop, payments);
		return SKIP_BODY;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
