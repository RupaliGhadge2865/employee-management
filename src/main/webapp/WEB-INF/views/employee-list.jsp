<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
</head>
<body>

    <!-- Registration nantar success message + details -->
    <c:if test="${not empty message}">
        <div style="color:green">
            <h3><c:out value="${message}"/></h3>
            <p>
                ID: ${registered.id} <br>
                Name: <c:out value="${registered.name}"/> <br>
                Department: <c:out value="${registered.department}"/>
            </p>
        </div>
    </c:if>

    <h2>Employee List</h2>

    <table border="1" cellpadding="6">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
        </tr>
        <c:forEach var="e" items="${employees}">
            <tr>
                <td>${e.id}</td>
                <td><c:out value="${e.name}"/></td>
                <td><c:out value="${e.department}"/></td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="${pageContext.request.contextPath}/employees/new">Register New Employee</a>

</body>
</html>