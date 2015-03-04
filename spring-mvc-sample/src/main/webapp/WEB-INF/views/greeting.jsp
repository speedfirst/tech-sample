<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring4 MVC -HelloWorld</title>
</head>
<body>
<h1>Hello : ${name}</h1>
<h2>Hello Obj: ${hello.name} ${hello.date}</h2>
<h2>List</h2>
<ul>
    <c:forEach var="listValue" items="${lists}">
        <li>${listValue}</li>
    </c:forEach>
</ul>
</body>
</html>