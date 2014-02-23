<%-- Usage
	<custom:menu key="users" href="/users/" text="System"/>
--%><%@ attribute name="href" required="true"%><%--
--%><%@ attribute name="text" required="true"%><%--
--%><%@ attribute name="key" required="true"%><%--
--%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%--
--%><c:url value="${href}" var="fullUrl"/><%--
--%><a href="${fullUrl}" class="item ${currentMenu eq key ? 'active' : '' }">${text}</a>
