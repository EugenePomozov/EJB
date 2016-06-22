package form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ExitForm extends ActionForm {
	private static final long serialVersionUID = 1L;

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		request.getSession().setAttribute("user", null);
	}
}
