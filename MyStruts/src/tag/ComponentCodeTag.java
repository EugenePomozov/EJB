package tag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import beans.User;
import by.epamlab.beans.reservations.ResComponent;

public class ComponentCodeTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	private String prop;		//components
	private String source;		//user
	

	public int doStartTag() throws JspException {
		User user = (User) pageContext.getAttribute(source,
				PageContext.SESSION_SCOPE);
		List<ResComponent> list = user.getReservation().getReservationComponents();
		pageContext.getRequest().setAttribute(prop, list);
		return SKIP_BODY;
	}


	public void setProp(String prop) {
		this.prop = prop;
	}


	public void setSource(String source) {
		this.source = source;
	}
}
