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
<link href="resources/css/homestyle.css" rel="stylesheet" type="text/css"  media="all" />
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
<script src="resources/js/jquery.blueberry.js"></script>
		<script>
		$(window).load(function() {
			$('.blueberry').blueberry();
		});
		</script>
</head>
<body>
<!--  start-wrap -->
<body style="background-image:url(resources/images/2.png)">
		<div class="wrap">
		<div style="text-align:center">
		<img src="resources/images/1.png" title="img1" style="width:256px;height:128px;"/>
		</div>
			<!--  start-header -->
			<div class="header">

			
				<div class="clear"> </div>
				<div class="info">
					<p>Browse Online or Call Us â <span>1(888) 555-4689</span></p>
				</div>
				<div class="clear"> </div>
					<div style="margin-bottom:20px;" class="menu-main">
						<div class="menu">
							<ul>
					            <li><a href="addcategory.htm" target="contents">Add Category</a></li>
        						<li><a href="addadvert.htm" target="contents">Post Advert</a></li>
        						<li><a href="showapply.htm?action=display" target="contents">Show Apply</a></li>
        						<li><a href="login.htm?action=logout" target="contents">Log out</a></li>	            
					            <div class="clear"> </div>
					        </ul>
					        <div class="clear"> </div>
						</div>
					</div>
						<!--  end-header -->
				<div style="float:left;" class="gallery">
				
				<h2>Add a New Category</h2>

<form:form action="addcategory.htm" commandName="category" method="post">

<table>
<tr>
    <td>Category Title:</td>
    <td><form:input path="title" size="30" /> <font color="red"><form:errors path="title"/></font></td>
</tr>


<tr>
    <td colspan="2"><input type="submit" value="Create Category" /></td>
</tr>
</table>

</form:form>
				
				</div>
				<div class="clear"> </div>
	<div class="hr">
	</div>
</div>
</div>

</body>
</html>