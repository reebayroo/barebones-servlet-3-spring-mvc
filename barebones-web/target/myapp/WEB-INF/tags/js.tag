<%@ attribute name="src" required="true"%><%--
strip-whitespace-from-jsp-output not working 
--%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%--
 
--%><c:url var="fullsrc" value="${src}?v=${applicationScope.metadataProperties.version}"/><script type="text/javascript" src="${fullsrc}"></script>