<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Registration</title>
</head>
<body>

    <h2>Register Employee</h2>

    <!-- Error message -->
    <c:if test="${not empty error}">
        <p style="color:red"><c:out value="${error}"/></p>
    </c:if>

    <form action="${pageContext.request.contextPath}/employees" method="post">

        ID:
        <input type="text" name="id" value="<c:out value='${employee.id}'/>">
        <br><br>

        Name:
        <input type="text" name="name" value="<c:out value='${employee.name}'/>">
        <br><br>

        Department:
        <input type="text" name="department" value="<c:out value='${employee.department}'/>">
        <br><br>

        <button type="submit">Register</button>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/employees">Back to list</a>

</body>
</html>