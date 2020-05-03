/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.QuestionPossibleAnswers;
import models.User;
import models.UserAnswers;
import services.ExamImpl;

/**
 *
 * @author Walter
 */
public class Exam extends HttpServlet {
    ExamImpl examService;
     private String DB_URL="ra1.anystream.eu:3012";
    private String url="jdbc:mysql://" + DB_URL + "/scrum?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
    private String usernameDB="root";
    private String password="AFDEmp_MySQL1";
    
    public Exam(){
        examService = new ExamImpl();
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Exam</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Exam at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        // Get questions from databse (get dummy data for now)
        List<QuestionPossibleAnswers> questionsWithPossibleAnswers = examService.getQuestionsWithPossibleAnswers();
        // Send questions to front
        request.setAttribute("questionsWithPossibleAnswers", questionsWithPossibleAnswers);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
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
        // Get user and selected answers from parameters
        UserAnswers userAnswers = (UserAnswers)request.getAttribute("userAnswers");
        User user = userAnswers.getUser();
        // Save to db via the examService
        examService.saveUser(user);
        examService.saveUserSelectedAnswers(userAnswers, user, url,  usernameDB, password);
        
        
        
        
        
        // Get Results
        examService.getResult(user);
        // Forward to index.jsp
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
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
