/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author snehal
 */
public class RegisterUserFormServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterUserFormServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String id = request.getParameter("Userid");
            String editname="";
            String editEmail="";
            String editBirthdate="";
            String editMobile="";
            String editPass="";

            if (id != null) {
                String URL = "jdbc:mysql://localhost/ComputerShoppingAppDB";
                String user = "snehal";
                String pass = "snehal";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection cn = DriverManager.getConnection(URL, user, pass);
                    String sql = "select * from UserTB where UserId=" + id;
                    Statement stmt = cn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    rs.absolute(1);
                    editname = rs.getString(2);
                    editEmail = rs.getString(3);
                    editBirthdate=rs.getString(4);
                    editMobile=rs.getString(5);
                    editPass=rs.getString(6);
                    stmt.close();
                    cn.close();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
            else{
                 id="0";
              }
            
            try{
                  String URL = "jdbc:mysql://localhost/ComputerShoppingAppDB";
                String user = "snehal";
                String pass = "snehal";
                
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection cn = DriverManager.getConnection(URL, user, pass);               
                    out.println("<form method='post' action='UserAddServlet'>");
                    out.println("<input type='hidden' name='txtUserid' value='"+id+"'>");
                    
                    out.println("Full Name:<input type='text' name='txtUsername' value='"+editname+"'><br>");
                    out.println("EmailId:<input type='text' name='txtEmail' value='"+editEmail+"'><br>");
                    out.println("BirthDate:<input type='date' name='txtBirthDate' value='"+editBirthdate+"'><br>");
                    out.println("MobileNo:<input type='text' name='txtMobile' value='"+editMobile+"'><br>");
                    out.println("Password:<input type='Password' name='txtPass' value='"+editPass+"'><br>");
                  
                    out.println("<br><input type='submit' name='btnsubmit' value='Register'>");
                    out.println("</form>");
                   
            }
            catch(Exception e){
                e.printStackTrace();
            }
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
