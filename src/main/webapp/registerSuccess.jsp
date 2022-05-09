<%--
  Created by IntelliJ IDEA.
  User: kaotu
  Date: 5/7/2022
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<head>
    <title>Success</title>
</head>
<body>
<div class="w3-panel w3-green">
    <h3>Register Success!</h3>
    <p>Email: <%=request.getParameter("email")%>
    </p>
    <p>Password: <%=request.getParameter("psw")%>
    </p>
</div>
</body>
</html>
