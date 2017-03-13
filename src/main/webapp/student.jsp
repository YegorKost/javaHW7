<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
<div align="center">
    <jsp:include page="menu.jsp"/>
    <br/>
    <table border="1" cellpadding="5" cellspacing="1">
        <tr><td colspan="6" align="center">Students of Soft-group Academy</td></tr>
        <tr>
            <td>Name</td>
            <td>Surname</td>
            <td>Phone number</td>
            <td>Birthday</td>
            <td>email</td>
            <td>Course</td>
        </tr>
        <c:forEach items="${sessionScope.studentList}" var="student" >
            <tr>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.surname}"/></td>
                <td><c:out value="${student.phoneNumber}"/></td>
                <td><c:out value="${student.birthday}"/></td>
                <td><c:out value="${student.email}"/></td>
                <td><c:out value="${student.course.name}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
