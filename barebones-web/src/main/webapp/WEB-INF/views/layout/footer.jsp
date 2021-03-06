<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags/"  prefix="custom"%>
 <footer>
	<p class="copyright">version: ${applicationScope.metadataProperties.version} - built: ${applicationScope.metadataProperties.buildDate}
	 &#169; Copyright 2013, <a href="/">${applicationScope.systemProperties.companyName}</a></p>
</footer>

<custom:js src="/assets/javascript/libs/jquery-1.9.1.min.js"/>
<custom:js src="/assets/javascript/libs/jquery.form.js"/>
<custom:js src="/assets/javascript/libs/jquery.validate.min.js"/>
<custom:js src="/assets/javascript/libs/additional-methods.min.js"/>
<custom:js src="/assets/javascript/libs/jquery.dataTables.min.js"/> 
<custom:js src="/assets/javascript/libs/bootstrap-datepicker.js"/> 
