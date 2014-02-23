<%--strip-whitespace-from-jsp-output not working
--%><%@ attribute name="href" required="true"%><%--
--%><%@ attribute name="cssClass" required="false"%><%--
--%><%@ attribute name="text" required="true"%><%--
--%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%--
--%><c:url value="${href}" var="fullUrl"/><%--
--%><a href="${fullUrl}" class="${cssClass}">${text}</a>