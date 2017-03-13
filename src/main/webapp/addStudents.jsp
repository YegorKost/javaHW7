<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add students</title>
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
    <form method="post" action="addStudent">
        <table>
            <tr>
                <td><label for="name">Name</label></td>
                <td><input id="name" type="text" name="name" required="required"/></td>
            </tr>
            <tr>
                <td><label for="surname">Surname</label></td>
                <td><input id="surname" type="text" name="surname" required="required"/></td>
            </tr>
            <tr>
                <td><label for="date">Birthday (yyyy/mm/dd) (min age 10 years)</label></td>
                <td><input id="date" type="DATE" name="birthday" onclick="max = maxDate()" required="required"/></td>
            </tr>
            <tr>
                <td><label for="phone">Phone number (10 digits)</label></td>
                <td><input id="phone" type="text" name="phoneNumber" minlength="10"  maxlength="10" pattern="[0-9]{10}"/></td>
            </tr>
            <tr>
                <td><label for="email">Email</label></td>
                <td><input id="email" type="email" name="email"/></td>
            </tr>
            <tr>
                <td><label for="course">Course</label></td>
                <td>
                    <select id="course" name="selectedCourse" required="required">
                        <c:forEach items="${sessionScope.courseList}" var="course">
                            <option value="${course.id}">${course.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add Student"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
