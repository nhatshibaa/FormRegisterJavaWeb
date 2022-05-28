<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.javawebday1.entity.Phone" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kaotu
  Date: 5/28/2022
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Phone> list = (List<Phone>) request.getAttribute("listphone");
    if(list == null){
        list = new ArrayList<>();
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>List Phone</h2>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Brand</th>
        <th>Price</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <%for (Phone phone : list) {
    %>
    <tr>
        <td><%=phone.getId()%></td>
        <td><%=phone.getName()%></td>
        <td><%=phone.getBrand()%></td>
        <td><%=phone.getPrice()%></td>
        <td><%=phone.getDescription()%></td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>
