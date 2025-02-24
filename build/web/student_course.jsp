<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student & Course Management</title>
</head>
<body>
    <h1>Manage Student-Course Enrollment</h1>

    <h2>Enroll Student in Course</h2>
    <form action="StudentCourseServlet" method="POST">
        <label>Student ID:</label>
        <input type="text" name="studentId" required>
        <label>Course ID:</label>
        <input type="text" name="courseId" required>
        <input type="submit" name="action" value="Enroll">
    </form>

    <h2>Remove Student from Course</h2>
    <form action="StudentCourseServlet" method="POST">
        <label>Student ID:</label>
        <input type="text" name="studentId" required>
        <label>Course ID:</label>
        <input type="text" name="courseId" required>
        <input type="submit" name="action" value="Remove">
    </form>

    <h2>Get Student Courses</h2>
    <form action="StudentCourseServlet" method="GET">
        <label>Student ID:</label>
        <input type="text" name="studentId" required>
        <input type="submit" name="action" value="GetStudentCourses">
    </form>

    <c:if test="${not empty studentCourses}">
        <h3>Courses for Student</h3>
        <ul>
            <c:forEach var="course" items="${studentCourses}">
                <li>${course.courseId} - ${course.name}</li>
            </c:forEach>
        </ul>
    </c:if>

    <h2>Get Students by Course ID</h2>
    <form action="StudentCourseServlet" method="GET">
        <label>Course ID:</label>
        <input type="text" name="courseId" required>
        <input type="submit" name="action" value="GetCoursesStudent">
    </form>

    <c:if test="${not empty students}">
        <h3>Students Enrolled in Course</h3>
        <ul>
            <c:forEach var="student" items="${students}">
                <li>${student.studentId} - ${student.firstname} ${student.lastname}</li>
            </c:forEach>
        </ul>
    </c:if>

    <h2>Get All Courses with Students</h2>
    <form action="StudentCourseServlet" method="GET">
        <input type="submit" name="action" value="GetAllStudentCurso">
    </form>

    <c:if test="${not empty allCourses}">
        <h3>All Courses and Their Students</h3>
        <ul>
            <c:forEach var="course" items="${allCourses}">
                <li><strong>${course.name} (ID: ${course.courseId})</strong></li>
                <ul>
                    <c:forEach var="student" items="${course.students}">
                        <li>${student.studentId} - ${student.firstname} ${student.lastname}</li>
                    </c:forEach>
                </ul>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>
