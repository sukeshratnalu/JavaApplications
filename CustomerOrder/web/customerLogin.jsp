<%--
  Created by IntelliJ IDEA.
  User: semanticbits
  Date: 13/3/18
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    form{
        text-align: center;
    }
</style>
<head>
    <title>Title</title>
</head>
<body>
<h1>Customer Login</h1>
<form name="LoginForm" method="post" action="/login">
    <b>User Name:</b> <br/><input type="text" name="name"/> <br/>
    <b>Password:</b> <br/><input type="password" name="password"/> <br/><br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
