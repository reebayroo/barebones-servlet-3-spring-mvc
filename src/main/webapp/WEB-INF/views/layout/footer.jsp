<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags/"  prefix="custom"%>
 <footer>
	<p class="copyright">version: ${applicationScope.metadataProperties.version} - built: ${applicationScope.metadataProperties.buildDate} &#169; Copyright 2013, <a href="http://www.workwithgrid.com">Grid LLC.</a></p>
</footer>

<custom:js src="/assets/js/libs/jquery-1.9.1.min.js"/>
<custom:js src="/assets/js/libs/jquery.form.js"/>
<custom:js src="/assets/js/libs/jquery.validate.min.js"/>
<custom:js src="/assets/js/libs/additional-methods.min.js"/>
<custom:js src="/assets/js/libs/jquery.dataTables.min.js"/> 
<custom:js src="/assets/js/libs/bootstrap-datepicker.js"/> 
