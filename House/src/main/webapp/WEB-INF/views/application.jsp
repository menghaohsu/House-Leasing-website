<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/homestyle.css" rel="stylesheet" type="text/css"  media="all" />
<title>Result Presentation</title>
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
<body style="background-image:url(resources/images/2.png)">
<!--  start-wrap -->
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
					    		<li><a href="index.jsp">Home</a></li>
					    		<li><a href="adduser.htm" target="contents">Register</a></li>
					            <c:choose> 
					    		<c:when test="${!empty sessionScope.userName}">
					    		<li><a href="login.htm?action=logout">Log out</a></li>
					    		</c:when>
					    		<c:otherwise>
					    		 <li><a href="login.htm?action=display">Log in</a></li>
					    		</c:otherwise>
					    		</c:choose>
					            <li><a href="browse.htm?action=display">Browse House</a></li>	
					            <li><a href="application.htm?action=action">Application Status</a></li>            
					            <div class="clear"> </div>
					        </ul>
					        <div class="clear"> </div>
						</div>
					</div>
						<!--  end-header -->
				<div class="content">
					<div style="float:right;" class="side-bar">
						<h4>Find Your Property</h4>
						<div class="side-bar-from">
							<form action="searchHouse.htm" method="get">
							<input type="hidden" name="action" value="searchByZipcode"/>
							<p>Zipcode:</p>
							<input type="text" name="zipcode"/>
							<input type="submit"  value="search"/>
							</form>
						</div>
					</div>
				</div>
				<div style="float:left;" class="gallery">
				<c:forEach var="apply" items="${applyList1}">
				<div class="grid2">
               
                    Title:<input type="text" name="title" value="${apply.title}" readonly="readonly"/></br>
                    Address:<input type="text" name="address" value="${apply.address}" readonly="readonly"/></br>
                    Bedrooms:<input type="text" name="bedrooms" value="${apply.bedrooms}" readonly="readonly"/></br>
                    Bathrooms:<input type="text" name="bathrooms" value="${apply.bathrooms}" readonly="readonly"/></br>
                    Livingrooms:<input type="text" name="livingrooms" value="${apply.livingrooms}" readonly="readonly"/></br>
                    Accommodate:<input type="text" name="accommodate" value="${apply.accommodate}" readonly="readonly"/></br>
                    Zipcode:<input type="text" name="zipcode" value="${apply.zipcode}" readonly="readonly"/></br>
                    Apply Status<input type="text" name="applyStatus" value="${apply.status}" readonly="readonly"/></br>
                    </div>
            </c:forEach>
            </div>
				<div class="clear"> </div>
	<div class="hr">
	</div>
</div>

</body>
</html>