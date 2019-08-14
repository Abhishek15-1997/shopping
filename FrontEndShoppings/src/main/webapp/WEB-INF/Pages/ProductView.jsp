<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div>
<body>


	
<h1>View Product</h1>
	<table border="1">
		<tr>
			<th>Category Name</th>
			<th>Product Id</th>
			<th>Product name</th>
			<th>Product Description</th>
			<th colspan="2">Admin Operations</th>
		</tr>
		<c:forEach items="${myproducts}" var="prod">	
			<tr>
				<td>${prod.cat.categoryName }</td>
				<td>${prod.productId}</td>
				<td>${prod.productName }</td>
				<td>${prod.pdes }</td>
				<td><a href="updateProduct/${prod.productId}">Update Product</a></td>
				<td><a href="deleteProduct/${prod.productId}">Delete Product</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</div>
</html>