<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

	<form:form action="${pageContext.request.contextPath}/addCategory" modelAttribute="CategoryObj" method="post">
	<table>
	
			<c:if test="${ CategoryObj.categoryId ne 0}">
				
				<tr>
					<td>Category Id : </td>
					<td><form:input type="text" path="categoryId" readonly="true"/>
				</tr>
				
				</c:if>
	
	<tr>
		<td>category name :</td><td><form:input path="categoryName"/></td>
		
	</tr>
	
	<tr>
		<td>Category Description :</td><td><form:input path="des"/></td>
		
	</tr>

	<tr>
	 <td>  <input type="submit" value="${btnLabel }"></td>
		
	</tr>
	</table>
	
	</form:form>
	
</body>
</html>