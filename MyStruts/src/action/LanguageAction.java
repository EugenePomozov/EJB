package action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import beans.User;

public class LanguageAction extends DispatchAction {
	
	public ActionForward english(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) 
		throws Exception {
			
			request.getSession().setAttribute(
					Globals.LOCALE_KEY, Locale.ENGLISH);
			
			//return mapping.findForward("success");
			return forward(mapping,request,response);
		}
	
	public ActionForward russian(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) 
		throws Exception {
			
			request.getSession().setAttribute(
					Globals.LOCALE_KEY, new Locale("ru"));
			
			//return mapping.findForward("success");
			return forward(mapping,request,response);
		}
	public ActionForward forward(ActionMapping mapping,HttpServletRequest request,HttpServletResponse response){
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();
		if (session.getAttribute("user")!=null){
			return mapping.findForward("success");
		} else {
			return mapping.findForward("failure");
		}
		
	}
}
