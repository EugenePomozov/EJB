<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-bean-el" prefix="bean-el"%>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="html-el"%>
<%@ taglib uri="/tags/reservation" prefix="reservation"%>
   
 <div class="container-fluid">
	<div class="navbar-header">
		<reservation:user/>
		<a class="navbar-brand" href="http://localhost:8080/MyStruts/elements/Tab.do?method=customerPage"><bean:write name="username" /></a>
	</div>
	  
	<div id="navbar" class="navbar-collapse collapse">
		<ul class="nav navbar-nav navbar-right">  
			<li> <html:link action="/Locale.do?method=english"><bean:message key="jsp.locale.en" /></html:link></li>
			<li> <html:link action="/Locale.do?method=russian"><bean:message key="jsp.locale.ru" /></html:link></li>
		</ul>
	</div>
</div> 