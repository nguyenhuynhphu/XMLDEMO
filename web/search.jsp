<%-- 
    Document   : search
    Created on : Oct 31, 2020, 1:03:06 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search Student</h1>
        <a href="new.jsp">New</a>
        <form method="GET" action="LoginServlet">
            Search: <input type="text" name="searchValue"/>
            <input type="submit" value="Search" />
        </form>
    <c:if test="${not empty sessionScope.USERS}">
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>YOB</th>
                    <th>Course</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="dto" items="${sessionScope.USERS}" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${dto.name}</td>
                    <td>${dto.gender}</td>
                    <td>${dto.yob}</td>
                    <td>
                <c:forEach var="course" items="${dto.courses}">
                    <p>${course.name}</p>
                    <p>${course.mark}</p>
                </c:forEach>
                </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>
</body>
</html>
