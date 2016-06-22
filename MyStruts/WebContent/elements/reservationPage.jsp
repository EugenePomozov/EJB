<%@ taglib uri="/tags/reservation" prefix="reservation"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

	<h1><bean:message key="jsp.reservation.reservation"/></h1>
	<h2>
		<bean:message key="jsp.reservation.code"/>
		<reservation:resCode source="user" />
	</h2>
	<h2>
		<bean:message key="jsp.reservation.description"/>
		<reservation:resDescr source="user" />
	</h2>

	<reservation:resComp prop="components" source="user"/>
	<table class="table table-striped table-hover table-condensed">
		<caption><bean:message key="jsp.reservation.components"/></caption>
		<thead>
			<tr>
				 <th><bean:message key="jsp.reservation.sequence"/></th>
				<th><bean:message key="jsp.reservation.typeCode"/></th>
				<th><bean:message key="jsp.reservation.dtCreation"/></th>
				<th><bean:message key="jsp.reservation.status"/></th>
			</tr>
		</thead>
		<logic:iterate name="components" id="comp">
			<tr>
				<td><bean:write name="comp" property="sequence" /></td>
				<td><bean:write name="comp" property="componentTypeCode" /></td>
				<td><bean:write name="comp" property="createDateTime" /></td>
				<td><bean:write name="comp" property="internalStatus" /></td>
			</tr>
		</logic:iterate>
	</table>