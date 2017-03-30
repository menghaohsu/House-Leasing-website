<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Apply</title>
 <script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
<script>
    var xmlHttp;
    xmlHttp = GetXmlHttpObject();
    var q=null;
    var query=null;

    function approve(thisNode, title, applyBy){
        if (xmlHttp == null)
        {
            alert("Your browser does not support AJAX!");
            return;
        }

        q = "action=approve&title="+title+"&applyBy="+applyBy;

        xmlHttp.onreadystatechange = function stateChanged()
        {
            if (xmlHttp.readyState == 4)
            {
                thisNode.disabled = true;

            }
        };
        xmlHttp.open("POST", "showapply.htm", true);
        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttp.send(q);
        return false;
    }
    
     function disapprove(thisNode, title, applyBy){
        if (xmlHttp == null)
        {
            alert("Your browser does not support AJAX!");
            return;
        }

        query ="action=disapprove&title="+title+"&applyBy="+applyBy;

        xmlHttp.onreadystatechange = function stateChanged()
        {
            if (xmlHttp.readyState == 4)
            {
                thisNode.disabled = true;
                
                
            }
        };
        xmlHttp.open("POST", "showapply.htm", true);
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
                <td><b>APPLYBY</b></td>
            </tr>
            <c:forEach var="apply" items="${applyList}">
                <tr>
                    <td><input type="text" name="title" value="${apply.title}"/></td>
                    <td><input type="text" name="address" value="${apply.address}"></td>
                    <td><input type="text" name="bedrooms" value="${apply.bedrooms}"/></td>
                    <td><input type="text" name="bathrooms" value="${apply.bathrooms}"/></td>
                    <td><input type="text" name="livingrooms" value="${apply.livingrooms}"/></td>
                    <td><input type="text" name="accommodate" value="${apply.accommodate}"/></td>
                    <td><input type="text" name="zipcode" value="${apply.zipcode}"/></td>
                    <td><input type="text" name="applyBy" value="${apply.applyBy}"/></td>
                    <td><input type="button" value="approve" onclick="approve(this,'${apply.title}','${apply.applyBy}')"/></td>
                    <td><input type="button" value="disapprove" onclick="disapprove'${apply.title}','${apply.applyBy}')"/></td>
                </tr>
            </c:forEach>
 </table>

</body>
</html>