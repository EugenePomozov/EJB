<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<tiles:insert definition="start">
	<tiles:put name="title">
		<bean:message key="jsp.login.title" />
	</tiles:put>
</tiles:insert>