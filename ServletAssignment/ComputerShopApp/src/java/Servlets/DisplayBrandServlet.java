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
public class DisplayBrandServlet extends HttpServlet {

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
            out.println("<title>Servlet DisplayBrandServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            try{
                  String URL = "jdbc:mysql://localhost/ComputerShoppingAppDB";
                String user = "snehal";
                String pass = "snehal";
                
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection cn = DriverManager.getConnection(URL, user, pass);
                    String sql = "select * from BrandTB";

                    Statement stmt = cn.createStatement();
                   
                    ResultSet rsb =stmt.executeQuery(sql);
                    
                    out.println("<table border=1><thead><tr><th>BrandName</th><th>Edit</th><th>Delete</th></tr></thead><tbody>");
                  
                  while(rsb.next()){
                    out.println("<tr>");
                      
                      //out.println(rs.getInt(1));
                      out.println("<td>"+rsb.getString(2)+"</td>");
                      
                       

                      out.println("<td><a href='BrandFormServlet?bid="+rsb.getInt(1)+"'>Edit</a></td>");
                       out.println("<td><a href='BrandDeleteServlet?bid="+rsb.getInt(1)+"' >Delete</a></td>");

                     out.println("</tr>");
                      
                  }
                  out.println("</tbody></table>");
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
