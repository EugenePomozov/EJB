package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import beans.User;

public class CustomerEmailTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	private String prop;
	private String source;
	
	public void setProp(String prop) {
		this.prop = prop;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int doStartTag() throws JspException {
		
		User user = (User) pageContext.getAttribute(source,	PageContext.SESSION_SCOPE);
		by.epamlab.beans.reservations.customer.Email email = user.getReservation().getCustomer().getEmail();
		pageContext.getRequest().setAttribute(prop, email);
		return SKIP_BODY;
	}
}
