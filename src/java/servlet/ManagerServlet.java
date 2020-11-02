/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import services.XMLServices;
import utils.StudentDTO;
import utils.StudentHandler;

/**
 *
 * @author Administrator
 */
public class ManagerServlet extends HttpServlet {

    private static final String HOME_PAGE = "search.jsp";
    private static final String XML = "/WEB-INF/student.xml";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = HOME_PAGE;
        String action = request.getParameter("btAction");
        try {
            String realPath = this.getServletContext().getRealPath("/");
            String path = realPath + XML;
            Document doc = XMLServices.parseFileToDom(path);
            if(action.equals("insert")){
                String id = request.getParameter("txtID");
                String pass = request.getParameter("txtPassword");
                String name = request.getParameter("txtName");
                String gender = request.getParameter("txtGender");
                String yob = request.getParameter("txtYob");
                String course1 = request.getParameter("course1");
                String mark1 = request.getParameter("mark1");
                String course2 = request.getParameter("course2");
                String mark2 = request.getParameter("mark2");
                String course3 = request.getParameter("course3");
                String mark3 = request.getParameter("mark3");
                Map<String, String> atts = new HashMap();
                atts.put("username", id);
                atts.put("password", pass);
                
                Element studentEle = XMLServices.createElement(doc, "student", null, atts);
                Element nameEle = XMLServices.createElement(doc, "name", name, null);
                Element genderEle = XMLServices.createElement(doc, "gender", gender, null);
                Element yobEle = XMLServices.createElement(doc, "yob", yob, null);
                
                
                Element courses = XMLServices.createElement(doc, "courses", null, null);
                atts = new HashMap<>();
                atts.put("mark", mark1);
                Element course1Ele = XMLServices.createElement(doc, "course", course1, atts);
                atts = new HashMap<>();
                atts.put("mark", mark2);
                Element course2Ele = XMLServices.createElement(doc, "course", course2, atts);
                atts = new HashMap<>();
                atts.put("mark", mark3);
                Element course3Ele = XMLServices.createElement(doc, "course", course3, atts);
                
                courses.appendChild(course1Ele);
                courses.appendChild(course2Ele);
                courses.appendChild(course3Ele);
                
                studentEle.appendChild(nameEle);
                studentEle.appendChild(yobEle);
                studentEle.appendChild(genderEle);
                studentEle.appendChild(courses);
                
                NodeList students = doc.getElementsByTagName("students");
                students.item(0).appendChild(studentEle);
                XMLServices.transformDOMToFile(doc, path);
                System.out.println("Success");
            }else if(action.equals("update")){
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
