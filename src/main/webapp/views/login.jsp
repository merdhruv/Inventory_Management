<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
<link rel="stylesheet" href="/inventory/resources/static/css/login.css">
</head>
<body>
	<div class="form">

  <span href="#" class="button" id="toggle-login">Inventory Management System</span>

<div id="login">
  <div id="triangle"></div>
  <h1>Dealer Log in</h1>
 <form:form id="eloginform" action="loginUser" method="post" modelAttribute="euser">
    <input type="text" placeholder="Email" name="email"/>
    <input type="password" placeholder="Password" name="password" />
    <input type="submit" value="Log in" />
 </form:form>
</div>
  
</div>
<div style="color: red; margin:auto; text-align: center;
		background-color:aqua; width:25%; padding:10px;font-weight:bold;">
	${error}</div>
</body>
</html>