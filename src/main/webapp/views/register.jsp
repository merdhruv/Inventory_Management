<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<link rel="stylesheet" href="/inventory/resources/static/css/register.css">
</head>
<body>
	<div  class="form">
<h3>Inventory - Dealers Registration</h3> 
<form:form id="registrationform" action="saveUser" method="post" modelAttribute="user">
<br/>
<p class="contact"><label for="fname">Email</label></p>
<input id="email" name="email" placeholder="Enter Email" required tabindex="1" type="email">


<p class="contact"><label for="fname">First Name</label></p>
<input id="fname" name="fname" placeholder="Enter first name" required tabindex="2" type="text">

<p class="contact"><label for="lname">Last Name</label></p>
<input id="lname" name="lname" placeholder="Enter last name" required tabindex="3" type="text">

<p class="contact"><label for="password">Enter a password</label></p>
<input type="password" id="password" name="password" required tabindex="4">

<label for="birthday">Birthday:</label>
<input type="date" id="dob" name="dob" tabindex="5">

<p class="contact"><label for="phone">Mobile phone</label></p>
<input id="phone" name="phoneNo" placeholder="phone number" required tabindex="6" type="tel"
pattern="[0-9]{10}"> 

<br>
<input class="buttom" name="submit" id="submit" tabindex="9" value="Sign me up!" type="submit"> 
<br/><br/>
</form:form>
</div>
</body>
</html>