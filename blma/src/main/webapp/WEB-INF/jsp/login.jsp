<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Login page</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
  </head>

  <body>
    <div class="container" id="main-content">
      <c:if test="${param.error != null}">
          <div class="alert alert-danger">
            <p>Invalid username and password.</p>
          </div>
      </c:if>
      <c:if test="${param.logout != null}">
          <div class="alert alert-success">
            <p>You have been logged out successfully.</p>
          </div>
      </c:if>
      <form class="form-horizontal" action="<c:url value='/login' />" method='POST'>
        <div class="form-group">
          <label class="col-sm-2 control-label">Username</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" name="username" placeholder="user name">
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label">Password</label>
          <div class="col-sm-10">
            <input type="password" class="form-control" name="password" placeholder="Password">
          </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Sign in</button>
          </div>
        </div>
      </form>
    </div>
  </body>
</html>