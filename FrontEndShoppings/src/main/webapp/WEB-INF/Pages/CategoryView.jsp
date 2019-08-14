<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div>
<body>


	
<h1>View Categories</h1>
	<table border="1">
		<tr>
			<th>Category Name</th>
			<th>Category Desc</th>
			<th colspan="2">Admin Operations</th>
		</tr>
		<c:forEach items="${categories}" var="category">	
			<tr>
				<td>${category.categoryName}</td>
				<td>${category.des }</td>
				<td><a href="updateCategory/${category.categoryId}">Update</a></td>
				<td><a href="deleteCategory/${category.categoryId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</div>
</html>