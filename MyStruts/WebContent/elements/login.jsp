<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<logic:messagesPresent>
	<div class="list alert alert-danger">
		<html:errors />
	</div>
</logic:messagesPresent>

<html:form action="/Login" focus="userName" method="post">
	<div class="loginform">
		<h3>
			<bean:message key="jsp.login.user" />
			<html:text property="userName" />
		</h3>
		<h3>
			<bean:message key="jsp.login.password" />
			<html:password property="password" />
		</h3>
		<button class="btn btn-info" type="submit">
			<bean:message key="jsp.login.button" />
		</button>
	</div>
</html:form>