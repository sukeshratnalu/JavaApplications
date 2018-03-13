<%--
  Created by IntelliJ IDEA.
  User: semanticbits
  Date: 8/3/18
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    form{
        text-align: center;
    }
</style>
<body>

    <h1>Add Customer Details</h1>
    <form name="customerForm" method="post" action="/customers">
    <b>Name:</b> <br/><input type="text" name="name"/> <br/>
    <b>Password:</b> <br/><input type="password" name="password"/> <br/>
    <b>Mobile No:</b>  <br/><input type="text" name="mobileNo"/> <br/>
    <b>Gmail:</b> <br/><input type="text" name="gmail"/> <br/>
    <b>Address:</b> <br/><input type="text" name="address"/> <br/>
    <b>PIN:</b> <br/><input type="text" name="pin"/> <br/><br/><br/>
        <input type="submit" value="Submit" />
    </form>

</body>
</html>
