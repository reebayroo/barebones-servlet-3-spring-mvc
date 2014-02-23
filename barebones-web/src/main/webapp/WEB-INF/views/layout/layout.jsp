<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!--[if lt IE 7]>  <html class="ie ie6 lte9 lte8 lte7"> <![endif]-->
<!--[if IE 7]><html class="ie ie7 lte9 lte8 lte7"> <![endif]-->
<!--[if IE 8]><html class="ie ie8 lte9 lte8"> <![endif]-->
<!--[if IE 9]><html class="ie ie9 lte9"> <![endif]-->
<!--[if gt IE 9]> <html> <![endif]-->
<!--[if !IE]><!-->
<!--<![endif]-->
<head>
<!-- setup request variables -->
<c:set var="currentMenu" scope="request">
	<tiles:insertAttribute name="current-menu" />
</c:set>
<c:set var="moduleScript" scope="request">
	<tiles:insertAttribute name="module-script" />
</c:set>
<c:set var="bodyClass" scope="request">
	<tiles:insertAttribute name='body-class' />
</c:set>
<c:set var="title" scope="request">
	<tiles:insertAttribute name='title' />
</c:set>
<title>${title}</title>
<%@ include file="inclusions.jsp"%>
</head>
<body class="${bodyClass}">
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="menu" />
	<section class="main">
	<tiles:insertAttribute name="messages" />
		<tiles:insertAttribute name="body" />
	</section>
	<tiles:insertAttribute name="footer" />


	<c:if test="${not empty moduleScript}">
		<custom:js src="/assets/javascript/modules/${moduleScript}" />
	</c:if>
</body>
</html>