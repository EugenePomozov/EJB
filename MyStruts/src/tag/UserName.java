package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;


import beans.User;

public class UserName extends TagSupport {
	private static final long serialVersionUID = 1L;


	
	public int doStartTag() throws JspException {
		User user = (User) pageContext.getAttribute("user",	PageContext.SESSION_SCOPE);
		if(user==null){
			pageContext.getRequest().setAttribute("username", "");
		}else{
			pageContext.getRequest().setAttribute("username", user);
		}
		return SKIP_BODY;
	}
}
