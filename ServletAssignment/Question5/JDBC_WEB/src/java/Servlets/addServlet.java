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
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shubham
 */
public class addServlet extends HttpServlet {

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
            out.println("<title>Servlet addServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String eid=request.getParameter("txtEid");
            String name=request.getParameter("txtname");
            String Pass=request.getParameter("txtpass");
            String dept=request.getParameter("txtdept");
            String URL="jdbc:mysql://localhost/EmpDB";
            String user="shubham1";
            String pass="shubham";
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn=DriverManager.getConnection(URL,user,pass);
                String sql="";
                    if(eid.equals("0")){
                       
                          sql="insert into EmpTB(EmployeeName,Password,DepartmentID)values(?,?,?)";
                    }
                    else{
                       
                          sql="Update EmpTB set EmployeeName=?,Password=?,DepartmentID=? where EmpID="+eid;
                    }
                
                
                
                PreparedStatement stmt=cn.prepareStatement(sql);
                stmt.setString(1,name );
                stmt.setString(2,Pass);
                stmt.setString(3, dept);
                
                int row=stmt.executeUpdate();
                if(row>0){
                   response.sendRedirect("DisplayServlet");
                    
                }
                
                stmt.close();
                cn.close();
                
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
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
