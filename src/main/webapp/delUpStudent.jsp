<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete student</title>
    <script>
        function maxDate() {
            var date = new Date();
            return date.getFullYear() - 10 + '-01-01';
        }
    </script>
</head>
<body>
<div align="center">
    <jsp:include page="menu.jsp"/>
    <br/>
    <form method="post" action="delUpStudent">
        <table >
            <tr>
                <td><input type="hidden" name="id" value="${requestScope.selectedStudent.id}" required="required"/></td>
            </tr>
            <tr>
                <td><label for="name">Name</label></td>
                <td><input id="name" type="text" name="name" value="${requestScope.selectedStudent.name}" autocomplete="on" required="required"/></td>
            </tr>
            <tr>
                <td><label for="surname">Surname</label></td>
                <td><input id="surname" type="text" name="surname" value="${requestScope.selectedStudent.surname}" autocomplete="on" required="required"/></td>
            </tr>
            <tr>
                <td><label for="date">Birthday (yyyy/mm/dd) (min age 10 years)</label></td>
                <td><input id="date" type="DATE" name="birthday" value="${requestScope.selectedStudent.birthday}" autocomplete="on" onclick="max = maxDate()" required="required"/></td>
            </tr>
            <tr>
                <td><label for="phone">Phone number (10 digits)</label></td>
                <td><input id="phone" type="text" name="phoneNumber" minlength="10" maxlength="10" value="${requestScope.selectedStudent.phoneNumber}" pattern="[0-9]{10}" autocomplete="on"/></td>
            </tr>
            <tr>
                <td><label for="email">Email</label></td>
                <td><input id="email" type="email" name="email" value="${requestScope.selectedStudent.email}" autocomplete="on"/></td>
            </tr>
            <tr>
                <td><label for="course">Course</label></td>
                <td>
                    <select id="course" name="selectedCourse">
                        <option selected="selected" value="${requestScope.selectedStudent.course.id}">${requestScope.selectedStudent.course.name}</option>
                        <c:forEach items="${sessionScope.courseList}" var="course">
                            <option value="${course.id}">${course.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="action" value="Update"/>
                    <input type="submit" name="action" value="Delete"/>
                </td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>
