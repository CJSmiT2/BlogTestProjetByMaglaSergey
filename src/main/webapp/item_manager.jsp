<%-- 
    Document   : item_manager
    Created on : 13.09.2018, 13:12:05
    Author     : smit
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Manage item</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="menu.jsp" />
    
    <div class="container">
    <h3>Manage item</h3><br>
    <form class="form-horizontal" method="post" action="item_manager_action" enctype="multipart/form-data">
            <c:if test="${not empty item}">
                <input type="hidden" name="id" value="${item.getId()}">
            </c:if>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-group">
                <label class="control-label col-sm-2" for="title">Title: </label>
                <div class="col-sm-10">          
                    <input type="text" class="form-control" id="title" name="title" value="${item.getTitle()}" required="required">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="description">Description: </label>
                <div class="col-sm-10">          
                    <input type="text" class="form-control" id="description" name="description" value="${item.getDescription()}" required="required">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="category">Category: </label>
                <div class="col-sm-10">          
                    <input type="text" class="form-control" id="category" name='category' value="${item.getCategory()}" required="required">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="myImg">
                    <c:choose>
                        <c:when test="${item.imgFileExist()}">
                            <img src="${contextPath}/resources/img/${item.getImgFileName()}" class="img-responsive img-thumbnail" width="100px">
                        </c:when>    
                        <c:otherwise>
                            <img src="${contextPath}/resources/empty-photo.jpg" class="img-responsive img-thumbnail" width="100px">
                        </c:otherwise>
                    </c:choose>
                    
                </label>
                <div class="col-sm-10">          
                    <input type="file" name="myImg" id="myImg">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2"></label>
                <div class="col-sm-10">          
                    <button type="submit" class="btn btn-default">Save item</button>
                </div>
            </div>
        </form>
        </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
