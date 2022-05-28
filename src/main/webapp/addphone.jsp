<%@ page import="com.example.javawebday1.entity.Phone" %><%--
  Created by IntelliJ IDEA.
  User: kaotu
  Date: 5/28/2022
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Phone phone = (Phone) request.getAttribute("phone");
%>
<html>
<head>
    <title>ASM - T2010A</title>
</head>
<body>
<h2>Create Phone</h2>
<form action="/phone/add" method="post">
    <div>
        <input type="text" name="id" placeholder="ID" value="<%=phone.getId()%>">
    </div>
    <div>
        <input type="text" name="name" placeholder="Name" value="<%=phone.getName()%>">
    </div>
    <div>
        <select name="brand">
            <option value="apple">Apple</option>
            <option value="samsung">Samsung</option>
            <option value="nokia">Nokia</option>
            <option value="other">Othes</option>
        </select>
    </div>
    <div>
        <input type="text" name="price" placeholder="Price" value="<%=phone.getPrice()%>">
    </div>
    <div>
        <input type="text" name="description" placeholder="Description" value="<%=phone.getDescription()%>">
    </div>
    <div>
        <input type="submit" value="Save">
        <input type="reset" value="Reset">
    </div>
</form>
</body>
</html>
