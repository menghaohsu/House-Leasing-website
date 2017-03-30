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
<script>
    var xmlHttp;
    xmlHttp = GetXmlHttpObject();
    var query=null;

    function addToDB(thisNode, title, address, bedrooms, bathrooms, livingrooms, accommodate, zipcode){
    	
    	
    	
    	
    	
	    	if (xmlHttp == null)
	        {
	            alert("Your browser does not support AJAX!");
	            return;
	        }
	    	var n="${userName}";
	    	if(n==""){

	        	alert("Please login first!");
	        }else{
		        query = "action=addDB&title="+title+"&address="+address+"&bedrooms="+bedrooms+"&bathrooms="+bathrooms+"&livingrooms="+livingrooms+"&accommodate="+accommodate+"&zipcode="+zipcode;
		        thisNode.value = "SAVED";
	            thisNode.disabled = true;
	        }
	        xmlHttp.onreadystatechange = function stateChanged()
	        {
	            if (xmlHttp.readyState == 4)
	            {
	                
	            }
	        };
	        xmlHttp.open("POST", "applyHouse.htm", true);
	        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	        xmlHttp.send(query);
	        return false;
        

    }


    function GetXmlHttpObject()
    {
        var xmlHttp = null;
        try
        {
            // Firefox, Opera 8.0+, Safari
            xmlHttp = new XMLHttpRequest();
        } catch (e)
        {
            // Internet Explorer
            try
            {
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e)
            {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        return xmlHttp;
    }
</script>

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
				
				<c:forEach var="house" items="${advertList}">
				<div class="grid1">
                
                    Title:<input type="text" name="title" value="${house.title}" readonly="readonly"/></br>
                    Address:<input type="text" name="address" value="${house.address}" readonly="readonly" /></br>
                    Bedrooms:<input type="text" name="bedrooms" value="${house.bedrooms}" readonly="readonly"/></br>
                    Bathrooms:<input type="text" name="bathrooms" value="${house.bathrooms}" readonly="readonly"/></br>
                    Livingrooms:<input type="text" name="livingrooms" value="${house.livingrooms}" readonly="readonly"/></br>
                    Accommadate:<input type="text" name="accommodate" value="${house.accommodate}" readonly="readonly"/></br>
                    Zipcode:<input type="text" name="zipcode" value="${house.zipcode}" readonly="readonly"/></br>
                    <input type="button" value="Apply" onclick="addToDB(this,'${house.title}','${house.address}','${house.bedrooms}','${house.bathrooms}','${house.livingrooms}','${house.accommodate}','${house.zipcode}')"/>
                </div>
            	</c:forEach>
				
				</div>
				<div class="clear"> </div>
	<div class="hr">
	</div>
</div>
</div>


</body>
</html>