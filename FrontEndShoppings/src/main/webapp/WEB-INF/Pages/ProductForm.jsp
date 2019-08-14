<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

	<form:form action="${pageContext.request.contextPath}/addProduct" modelAttribute="ProductObj" method="post">
	<table>
	<c:if test="${ ProductObj.productId ne 0}">
				
				<tr>
					<td>Product Id : </td>
					<td><form:input type="text" path="ProductId" readonly="true"/>
				</tr>
				</c:if>
			
	
	<tr>
		<td>Product name :</td><td><form:input path="ProductName"/></td>
		
	</tr>
	
	<tr>
		<td>Product Description :</td><td><form:input path="Pdes"/></td>
		
	</tr>
	
	<c:if test="${ProductObj.catId eq 0 }">
	<tr>
	
	
		<td>Product Category
		<form:select path="CatId"  >
			<c:forEach items="${categorylists }" var="cat1">
			<form:option value="${cat1.categoryId}"><c:out value="${cat1.categoryName }"></c:out></form:option>
			</c:forEach>
		</form:select></td>
				
	</tr>
	</c:if>
	<tr>
	 <td>  <input type="submit" value="add product"></td>
		
	</tr>
	</table>
	
	</form:form>
	
</body>
</html>