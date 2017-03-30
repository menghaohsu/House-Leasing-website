<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//get the category list
        com.paul.spring.dao.CategoryDAO categorydao = new com.paul.spring.dao.CategoryDAO();
        java.util.List categoryList = categorydao.list();
        pageContext.setAttribute("categories", categoryList);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Advert Form</title>
</head>
<body>
<h2>Post a new House Here!</h2>
<form:form action="addadvert.htm" commandName="houseAdvert" method="post">
<table>

<tr>
    <td>Category:</td>
    <td>
        <form:select path="category_name">
            <c:forEach var="categ" items="${categories}">
                <form:option value="${categ.title}"/>
            </c:forEach>
        </form:select>
    </td>
                     
</tr> 
<tr>
	<td>title</td>
	<td><form:input path="title" size="30" /> <font color="red"><form:errors path="title"/></font></td>
</tr>
<tr>	
	<td>address</td>
	<td><form:input path="address" size="30" /> <font color="red"><form:errors path="address"/></font></td>
</tr>
<tr>
	<td>bedrooms</td>
	<td><form:input path="bedrooms" size="30" /> <font color="red"><form:errors path="bedrooms"/></font></td>
</tr>
<tr>
	<td>bathrooms</td>
	<td><form:input path="bathrooms" size="30" /> <font color="red"><form:errors path="bathrooms"/></font></td>
</tr>
<tr>
	<td>livingrooms</td>
	<td><form:input path="livingrooms" size="30" /> <font color="red"><form:errors path="livingrooms"/></font></td>
</tr>
<tr>
	<td>accommodate</td>
	<td><form:input path="accommodate" size="30" /> <font color="red"><form:errors path="accommodate"/></font></td>
</tr>
<tr>
	<td>zipcode</td>
	<td><form:input path="zipcode" size="30" /> <font color="red"><form:errors path="zipcode"/></font></td>
</tr>
<tr>
    <td colspan="2"><input type="submit" value="Create Advert" /></td>
</tr>

</table>
</form:form>

</body>
</html>