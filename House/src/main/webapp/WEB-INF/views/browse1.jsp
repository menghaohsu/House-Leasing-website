<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result Presentation</title>
 <script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
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
<table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>TITLE</b></td>
                <td><b>ADDRESS</b></td>
                <td><b>BEDROOMS</b></td>
                <td><b>BATHROOMS</b></td>
                <td><b>LIVINGROOMS</b></td>
                <td><b>ACCOMMODATE</b></td>
                <td><b>ZIPCODE</b></td>
            </tr>
            <c:forEach var="house" items="${advertList}">
                <tr>
                    <td><input type="text" name="title" value="${house.title}"/></td>
                    <td><input type="text" name="address" value="${house.address}"></td>
                    <td><input type="text" name="bedrooms" value="${house.bedrooms}"/></td>
                    <td><input type="text" name="bathrooms" value="${house.bathrooms}"/></td>
                    <td><input type="text" name="livingrooms" value="${house.livingrooms}"/></td>
                    <td><input type="text" name="accommodate" value="${house.accommodate}"/></td>
                    <td><input type="text" name="zipcode" value="${house.zipcode}"/></td>
                    <td><input type="button" value="Apply" onclick="addToDB(this,'${house.title}','${house.address}','${house.bedrooms}','${house.bathrooms}','${house.livingrooms}','${house.accommodate}','${house.zipcode}')"/></td>
                </tr>
            </c:forEach>
</table>

</body>
</html>