<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student & Course Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentServlet" method="POST">
            <table>
                <tr><td>Student ID</td><td><input type="text" name="studentId" value="${student.studentId}" /></td></tr>
                <tr><td>First Name</td><td><input type="text" name="firstname" value="${student.firstname}" /></td></tr>
                <tr><td>Last Name</td><td><input type="text" name="lastname" value="${student.lastname}" /></td></tr>
                <tr><td>Year Level</td><td><input type="text" name="yearLevel" value="${student.yearLevel}" /></td></tr>
                <tr><td colspan="2">
                    <input type="submit" name="action" value="Add" />
                    <input type="submit" name="action" value="Edit" />
                    <input type="submit" name="action" value="Delete" />
                    <input type="submit" name="action" value="Search" />
                </td></tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th><th>First Name</th><th>Last Name</th><th>Year Level</th>
            <c:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.studentId}</td><td>${stud.firstname}</td><td>${stud.lastname}</td><td>${stud.yearLevel}</td>
                </tr>
            </c:forEach>
        </table>
        
        <h1>Course Information</h1>
        <form action="./CourseServlet" method="POST">
            <table>
                <tr><td>Course ID</td><td><input type="text" name="courseId" value="${course.courseId}" /></td></tr>
                <tr><td>Course Name</td><td><input type="text" name="name" value="${course.name}" /></td></tr>
                <tr><td>Credits</td><td><input type="text" name="credits" value="${course.credits}" /></td></tr>
                <tr><td>Semester</td><td><input type="text" name="semester" value="${course.semester}" /></td></tr>
                <tr><td>Max Students</td><td><input type="text" name="maxStudents" value="${course.maxStudents}" /></td></tr>
                <tr><td colspan="2">
                    <input type="submit" name="action" value="Add" />
                    <input type="submit" name="action" value="Edit" />
                    <input type="submit" name="action" value="Delete" />
                    <input type="submit" name="action" value="Search" />
                </td></tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Course ID</th><th>Course Name</th><th>Credits</th><th>Semester</th><th>Max Students</th>
            <c:forEach items="${allCourses}" var="course">
                <tr>
                    <td>${course.courseId}</td><td>${course.name}</td><td>${course.credits}</td><td>${course.semester}</td><td>${course.maxStudents}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
