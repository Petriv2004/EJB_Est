/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petriv.controller;

import com.petriv.dao.CourseDaoLocal;
import com.petriv.dao.StudentDaoLocal;
import com.petriv.model.Course;
import com.petriv.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RayAj
 */
@WebServlet(name = "StudentCourseServlet", urlPatterns = {"/StudentCourseServlet"})
public class StudentCourseServlet extends HttpServlet {

    @EJB
    private CourseDaoLocal courseDao;

    @EJB
    private StudentDaoLocal studentDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String studentIdStr = request.getParameter("studentId");
        String courseIdStr = request.getParameter("courseId");

        if ("Enroll".equalsIgnoreCase(action)) {
            int studentId = Integer.parseInt(studentIdStr);
            int courseId = Integer.parseInt(courseIdStr);
            studentDao.enrollStudentInCourse(studentId, courseId);

        } else if ("Remove".equalsIgnoreCase(action)) {
            int studentId = Integer.parseInt(studentIdStr);
            int courseId = Integer.parseInt(courseIdStr);
            studentDao.removeStudentFromCourse(studentId, courseId);
        } else if ("GetStudentCourses".equalsIgnoreCase(action)) {
            int studentId = Integer.parseInt(studentIdStr);
            List<Course> courses = studentDao.getCoursesByStudentId(studentId);
            request.setAttribute("studentCourses", courses);
        } else if ("GetCoursesStudent".equalsIgnoreCase(action)) {
            int courseId = Integer.parseInt(courseIdStr);
            List<Student> students = courseDao.getStudentByCourseId(courseId);
            request.setAttribute("students", students);
        } else if ("GetAllStudentCurso".equalsIgnoreCase(action)) {
            List<Course> courses = courseDao.getAllCoursesWithStudents();
            request.setAttribute("allCourses", courses);
        }

        request.getRequestDispatcher("student_course.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
