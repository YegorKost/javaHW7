<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Select student</title>
</head>
<body>
<div align="center">
    <jsp:include page="menu.jsp"/>
    <br/>
    <form method="get" action="selectStudent">
        <table>
            <tr>
                <td>
                    <label for="stud">Select student</label>
                    <select id="stud" name="selectedStudent" required="required">
                        <c:forEach items="${sessionScope.studentList}" var="student">
                            <option value="${student.id}">id:${student.id} - ${student.name} ${student.surname} (email:${student.email}) - course: ${student.course.name} </option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <input type="submit" name="action" value="Select"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
