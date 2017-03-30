
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>The Free Platinum-Realtors for Website Template | Building :: w3layouts</title>	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="resources/css/homestyle.css" rel="stylesheet" type="text/css"  media="all" />
<title>RealEsate for Website Template | Home :: w3layouts</title>
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
					<p>Browse Online or Call Us – <span>1(888) 555-4689</span></p>
				</div>
				<div class="clear"> </div>
					<div style="margin-bottom:20px;" class="menu-main">
						<div class="menu">
							<ul>
					    		<li><a href="index.jsp">Home</a></li>
					    		<li><a href="adduser.htm" target="contents">Register</a></li>
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
				<form:form action="adduser.htm" commandName="user" method="post">

<table>
<tr>
    <td>First Name:</td>
    <td><form:input path="firstName" size="30" /> <font color="red"><form:errors path="firstName"/></font></td>
</tr>

<tr>
    <td>Last Name:</td>
    <td><form:input path="lastName" size="30" /> <font color="red"><form:errors path="lastName"/></font></td>
</tr>


<tr>
    <td>User Name:</td>
    <td><form:input path="name" size="30" /> <font color="red"><form:errors path="name"/></font></td>
</tr>

<tr>
    <td>Password:</td>
    <td><form:password path="password" size="30" /> <font color="red"><form:errors path="password"/></font></td>
</tr>

 <tr>
    <td>Email Id:</td>
    <td><form:input path="email.emailId" size="30" /> <font color="red"><form:errors path="email.emailId"/></font></td>
</tr> 

<tr>
    <td colspan="2"><input type="submit" value="Create User" /></td>
</tr>
</table>

</form:form>
				</div>
				</div>
	<div class="clear"> </div>
	<div class="hr">
	</div>
	
</div>