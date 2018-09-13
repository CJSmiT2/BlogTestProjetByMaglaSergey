<%-- 
    Document   : login
    Created on : 13.09.2018, 13:36:45
    Author     : smit
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>LogIn</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div style="width: 100%; max-width: 300px; margin: 250px auto">
    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2>LogIn</h2>
        <h5 class="text-success">(default: admin, admin)</h5>
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <br>
            <input name="username" 
                   type="text" 
                   class="form-control" 
                   placeholder="Username"
                   autofocus="true"/>
            <br>
            <input name="password" 
                   type="password" 
                   class="form-control" 
                   placeholder="Password"/>
            <span>${error}</span>
            
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
        </div>
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
