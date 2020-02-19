/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shubham
 */
public class StudentFormServlet extends HttpServlet {

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
            out.println("<title>Servlet StudentFormServlet</title>");            
            out.println("</head>");
            out.println("<body>");
           // out.println("<h1>Servlet StudentFormServlet at " + request.getContextPath() + "</h1>");
           
           
           String name=(String)request.getAttribute("name");
           String gender=(String)request.getAttribute("gender");
           String date=(String)request.getAttribute("date");
           String sem=(String)request.getAttribute("sem");
           String clg=(String)request.getAttribute("clg");
           
           if(name==null){
               name="";
           }
           if(gender==null){
               gender="";
           }
            if(date==null){
               date="";
           }
             if(sem==null){
               sem="";
           }
          
              if(clg==null){
               clg="";
           }
          
          
          
           
           
           String errSname=null;
                  errSname =(String)request.getAttribute("errSname");
                  if(errSname==null){
                      errSname=" ";
                  }
                  
                  String errGender=(String)request.getAttribute("errGender");
                  if(errGender==null){
                      errGender=" ";
                  }
                   String errSdate=(String)request.getAttribute("errSdate");
                  if(errSdate==null){
                      errSdate=" ";
                  }
                     String errSem=(String)request.getAttribute("errSem");
                  if(errSem==null){
                      errSem=" ";
                  }
                      String errClg=(String)request.getAttribute("errClg");
                  if(errClg==null){
                      errClg=" ";
                  }
                  
           
           out.println("<form action='Welcome' method='post'>\n" +
"            Student Name: <input type=\"text\" name=\"txtname\" value='"+name+"'><label style='color:red';>"+errSname+"</label>");
           out.println(" <br>\n" +
"            Gender: <input type=\"radio\" name=\"txtgender\" value=\"Male\">Male\n" +
"            <input type=\"radio\" name=\"txtgender\" value=\"Female\">Female <label style='color:red';>"+errGender+"</label>\n" +
"            <br>");
           out.println("  Date Of Birth : <input type=\"date\" name=\"txtdate\"value='"+date+"' ><label style='color:red';>"+errSdate+"</label>\n" +
"            <br>");
           out.println(" Sem :<input type=\"text\" name=\"txtsem\" value='"+sem+"'><label style='color:red';>"+errSem+"</label>\n" +
"            <br>");
           out.println(" College :<input type=\"text\" name=\"txtclg\" value='"+clg+"'><label style='color:red';>"+errClg+"</label>\n" +
"            <br>\n" +
"            <input type=\"submit\" name=\"btnsubmit\" value=\"Submit\">\n" +
"                \n" +
"        </form>");
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
