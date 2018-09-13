<%-- 
    Document   : home
    Created on : 13.09.2018, 12:05:55
    Author     : smit
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    
    <jsp:include page="menu.jsp" />
    
    <c:if test="${not empty pagination.getPagesSize()}">
        <div style="text-align: center">
            <ul class="pagination">
                <c:if test="${not empty pagination.getPreviosPageNumber()}">
                    <li><a href="?page=${pagination.getPreviosPageNumber()}"> previous </a></li>
                </c:if>

                <c:forEach var="pageNumber" items="${pagination.getPagesSize()}">
                    <li><a href="?page=${pageNumber}">${pageNumber}</a></li>
                </c:forEach>

                <c:if test="${not empty pagination.getNextPageNumber()}">
                    <li><a href="?page=${pagination.getNextPageNumber()}"> next </a></li>
                </c:if>

            </ul>
        </div>
    </c:if>
    
    <div class="panel panel-default" style="margin:25px 0">
        <div class="panel-body">
            <form class="form-inline" method="GET">
            <div class="form-group">
                <label for="search">Search by title: </label>
                <input type="text" class="form-control" id="search" name="search">
            </div>
            <button type="submit" class="btn btn-success">Search</button>
            </form>
        </div>
    </div>
    
    <table class="table table-hover">
    <thead>
      <tr>
        <th>id</th>
        <th>manage</th>
        <th>image</th>
        <th>title</th>
        <th>category</th>
        <th>description</th>
        <th>delete</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach var="itemRow" items="${itemsList.getRows()}">
            <c:forEach var="item" items="${itemRow.getObjects()}">
              <tr>
                <td>${item.getId()}</td>
                <td><a href="item_manager?id=${item.getId()}" class="btn btn-primary btn-sm">edit</a></td>
                <td>
                    <c:choose>
                        <c:when test="${item.imgFileExist()==true}">
                            <img src="${contextPath}/resources/img/${item.getImgFileName()}" class="img-responsive img-thumbnail" width="100px">
                        </c:when>    
                        <c:otherwise>
                            <img src="${contextPath}/resources/empty-photo.jpg" class="img-responsive img-thumbnail" width="100px">
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><b>${item.getTitle()}</b></td>
                <td>${item.getCategory()}</td>
                <td>${item.getDescription()}</td>
                <td><a href="delete?id=${item.getId()}" class="btn btn-danger btn-xs">delete</a></td>
              </tr>
          </c:forEach>
        </c:forEach>
    </tbody>
  </table>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
