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
<body style="background-image:url(resources/images/2.png)">
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
					            <li><a href="addcategory.htm" target="contents" >Add Category</a></li>
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
				<c:forEach var="apply" items="${applyList}">
				<div class="grid1">
                
                    Title:<input type="text" name="title" value="${apply.title}" readonly="readonly"/></br>
                    Address:<input type="text" name="address" value="${apply.address}" readonly="readonly"></br>
                    Bedrooms:<input type="text" name="bedrooms" value="${apply.bedrooms}" readonly="readonly"/></br>
                    Bathrooms:<input type="text" name="bathrooms" value="${apply.bathrooms}" readonly="readonly"/></br>
                    Livingrooms:<input type="text" name="livingrooms" value="${apply.livingrooms}" readonly="readonly"/></br>
                    Accommodate:<input type="text" name="accommodate" value="${apply.accommodate}" readonly="readonly"/></br>
                    Zipcode:<input type="text" name="zipcode" value="${apply.zipcode}" readonly="readonly"/></br>
                    Apply by:<input type="text" name="applyBy" value="${apply.applyBy}" readonly="readonly"/></br>
                    <input type="button" value="approve" onclick="approve(this,'${apply.title}','${apply.applyBy}')"/>
                    <input type="button" value="disapprove" onclick="disapprove(this,'${apply.title}','${apply.applyBy}')"/>
                
                </div>
            </c:forEach>
				
				<div class="clear"> </div>
	<div class="hr">
	</div>
</div>
</div>
</div>