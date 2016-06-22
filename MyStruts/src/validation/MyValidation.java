package validation;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;

import beans.User;
import factoties.UserFactory;
import ifaces.IUserDAO;

public class MyValidation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static boolean checkPassword(Object bean,
										ValidatorAction va,
										Field field,
										ActionMessages errors,
										Validator validator,
										HttpServletRequest request){
		
		String password = ValidatorUtils.getValueAsString(bean, field.getProperty());
		String userName = ValidatorUtils.getValueAsString(bean, "userName");
	

	        IUserDAO userDAO = UserFactory.getClassFromFactory();
	        User user = userDAO.getUser(userName, password);
	        	
	        if (user!=null){
	        	return false;
	        }
	        errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
		return true;
		
	}
	public static boolean checkUserName(Object bean,
										ValidatorAction va,
										Field field,
										ActionMessages errors,
										Validator validator,
										HttpServletRequest request){
		
		 String userName = ValidatorUtils.getValueAsString(bean, field.getProperty());
		 IUserDAO userDAO = UserFactory.getClassFromFactory();
		 	if(userDAO.checkUserName(userName)){
		 		return false;
		 	}
		 	errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
		 return true;	
	}

}
