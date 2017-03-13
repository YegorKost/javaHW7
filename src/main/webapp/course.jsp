<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Courses</title>
</head>
<body>
<div align="center">
    <jsp:include page="menu.jsp"/>
    <br/>
    <table border="1" cellpadding="5" cellspacing="1" width="30%">
        <tr>
            <td colspan="2" align="center">Available courses</td>
        </tr>
        <tr>
            <td width="50%">Id</td>
            <td width="50%">Course</td>
        </tr>
        <c:forEach items="${sessionScope.courseList}" var="course" >
            <tr>
                <td><c:out value="${course.id}"/></td>
                <td><c:out value="${course.name}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
