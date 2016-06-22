<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
		
<ul class="nav nav-tabs">
	<li>
		<a data-toggle="tab" href="elements/Tab.do?method=reservationPage">
		<bean:message key="jsp.tabs.reservation" />
		</a>
	</li>
	
	<li>
		<a data-toggle="tab" href="elements/Tab.do?method=customerPage">
		<bean:message key="jsp.tabs.customer" />
		</a>
	</li>
	
	<li>
		<a data-toggle="tab" href="elements/Tab.do?method=fareFamilyPage">
		<bean:message key="jsp.tabs.fare" />
		</a>
	</li>
	
	<li>
		<html:link action="/Exit">	
		<bean:message key="jsp.tabs.exit" />
		</html:link>
	</li>
</ul>	