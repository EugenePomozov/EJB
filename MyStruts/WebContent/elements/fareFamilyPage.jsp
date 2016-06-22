<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

	<html:form action="/fareFamilyPage">
		<nested:nest property="fareFamily">
			<h2>
				<b><bean:message key="jsp.fare.code" /></b>
				<nested:write property="fareFamilyCode" />
			</h2>

			<h4>
				<bean:message key="jsp.fare.components" />
			</h4>
			
			<ul>
				<nested:iterate property="ancillaryAirComponent">
					<li><nested:write property="ancillaryAirComponent" /></li>
				</nested:iterate>
			</ul>
		</nested:nest>
	</html:form>