<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html:base />
	<title>
		<tiles:getAsString name="title" />
	</title>
<link rel='stylesheet' href='styles/bootstrap.min.css' type='text/css'
	media='all'>
<link rel='stylesheet' href='styles/bootstrap.css' type='text/css'>
<link rel='stylesheet' href='styles/main.css' type='text/css'>
</head>
<body>
<div id="container">	
	<nav class="navbar navbar-inverse ">
		<tiles:insert attribute="header" />
	 </nav>
	<div class="container-fluid">
		<div class="container">
			<tiles:insert attribute="tabs" />
		</div>
		<div class="container">
			<tiles:insert attribute="content" />
		</div>
	</div>
</div>		
<div id="footer">
	<div id="footercontent">
		<tiles:insert attribute="footer" />
	</div>
</div>
	
</body>
</html>