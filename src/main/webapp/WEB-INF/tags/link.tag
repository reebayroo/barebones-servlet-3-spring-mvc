<%--strip-whitespace-from-jsp-output not working
--%><%@ attribute name="href" required="true"%><%--
--%><%@ attribute name="rel" required="true"%><%--
--%><%@ attribute name="type" required="false"%><%--
--%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%--
--%><c:url value="${href}" var="fullUrl"/><%--
--%><c:if test="${not empty type}"><c:set var="typeAttr" value='type="${type}"'/></c:if><%--
--%><link rel="${rel}" ${typeAttr} href="${fullUrl}"/>