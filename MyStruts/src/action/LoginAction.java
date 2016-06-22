/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import beans.User;
import factoties.UserFactory;
import form.LoginForm;
import ifaces.IUserDAO;

import org.apache.struts.action.ActionForward;

/**
 *
 * @author Eugene Pomozov
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       // LoginForm loginForm = (LoginForm) form;
    	LoginValidation loginForm = (LoginValidation) form;
        IUserDAO userDAO = UserFactory.getClassFromFactory();
        User user = userDAO.getUser(loginForm.getUserName(), loginForm.getPassword());
      
        if (user!=null) {
        	request.getSession().setAttribute("user", user);
            return mapping.findForward(SUCCESS);
        } else {
        	return mapping.findForward(FAILURE);
        }
    }
}
