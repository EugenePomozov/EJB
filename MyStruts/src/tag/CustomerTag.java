package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import beans.User;
import by.epamlab.beans.reservations.customer.Customer;

public class CustomerTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	private String prop;		//customer
	private String source;	//user
	
	public void setSource(String source) {
		this.source = source;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}

	public int doStartTag() throws JspException {
		User user = (User) pageContext.getAttribute(source,
				PageContext.SESSION_SCOPE);
		Customer customer = user.getReservation().getCustomer();
		pageContext.getRequest().setAttribute(prop, customer);
		return SKIP_BODY;
	}
}
