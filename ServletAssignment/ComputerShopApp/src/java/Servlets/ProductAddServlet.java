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
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author snehal
 */
public class ProductAddServlet extends HttpServlet {

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
            out.println("<title>Servlet ProductAddServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String pid=request.getParameter("txtProductid");
            String pname=request.getParameter("txtProductname");
            String price=request.getParameter("txtPrice");
            String brand=request.getParameter("txtbrand");
            String pc=request.getParameter("txtPCD");
            String desc=request.getParameter("txtDesc");
            String URL = "jdbc:mysql://localhost/ComputerShoppingAppDB";
            String user = "snehal";
            String pass = "snehal";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn=DriverManager.getConnection(URL,user,pass);
                String sql="";
                    if(pid.equals("0")){
                       
                          sql="insert into ProductTB(ProductName,BrandId,ProductCategoryId,Price,Description)values(?,?,?,?,?)";
                    }
                    else{
                       
                          sql="Update ProductTB set ProductName=?,BrandId=?,ProductCategoryId=? ,Price=? ,Description=? where ProductId="+pid;
                    }
                
                PreparedStatement stmt=cn.prepareStatement(sql);
                stmt.setString(1,pname );
                stmt.setString(2,brand);
                stmt.setString(3, pc);
                stmt.setString(4, price);
                stmt.setString(5, desc);
                
                int row=stmt.executeUpdate();
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                
                int id=generatedKeys.getInt(1);
                System.out.println("Inserted ID -" + id);
            }
           
        }
                if(row>0){
                   response.sendRedirect("DisplayProductServlet");
                    
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
