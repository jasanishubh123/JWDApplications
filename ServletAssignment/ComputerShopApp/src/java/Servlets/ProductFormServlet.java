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
public class ProductFormServlet extends HttpServlet {

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
            out.println("<title>Servlet ProductFormServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String id = request.getParameter("Productid");
            String editProductname="";
            String editPrice="";
            String editDesc="";
            String editBrand="";
            String editProductCategory="";

            if (id != null) {
                String URL = "jdbc:mysql://localhost/ComputerShoppingAppDB";
                String user = "snehal";
                String pass = "snehal";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection cn = DriverManager.getConnection(URL, user, pass);

                    String sql = "select * from ProductTB where ProductId=" + id;

                    Statement stmt = cn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    rs.absolute(1);
                    editProductname = rs.getString(2);
                    editPrice = rs.getString(5);
                    editDesc=rs.getString(6);
                    editBrand=rs.getString(3);
                    editProductCategory=rs.getString(4);
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

                    String bsql = "select * from BrandTB";
                    String pcsql = "select * from ProductCategoryTB";

                    Statement stmt = cn.createStatement();
                   
                    ResultSet rsb =stmt.executeQuery(bsql);                   
                    out.println("<form method='post' action='ProductAddServlet'>");
                    out.println("<input type='hidden' name='txtProductid' value='"+id+"'>");
                    
                    out.println("Product:<input type='text' name='txtProductname' value='"+editProductname+"'><br>");
                    out.println("Price:<input type='text' name='txtPrice' value='"+editPrice+"'><br>");
                    out.println("Brand:<select name='txtbrand'>");
                    if(id != null){
                         while(rsb.next()){
                             if(rsb.getString(1) == null ? editBrand == null : rsb.getString(1).equals(editBrand)){
                                 out.println("<option value='"+rsb.getString(1)+"'selected >"+rsb.getString(2)+"</option>");
                             }
                             else{
                                 out.println("<option value='"+rsb.getString(1)+"' >"+rsb.getString(2)+"</option>");
                             }
                        
                         }
                         }
                    else{
                         while(rsb.next()){
                        out.println("<option value='"+rsb.getString(1)+"'>"+rsb.getString(2)+"</option>");
                         }
                          
                    }
                    out.println("</select><br>");
                    stmt.close();
                    out.println("ProductCategory:<select name='txtPCD'>");
                    Statement stmtpc = cn.createStatement();
                     ResultSet rspc =stmtpc.executeQuery(pcsql);
                    if(id != null){
                        
                          while(rspc.next()){
                             if(rspc.getString(1) == null ? editProductCategory == null : rspc.getString(1).equals(editProductCategory)){
                                 out.println("<option value='"+rspc.getString(1)+"'selected >"+rspc.getString(2)+"</option>");
                             }
                             else{
                                 out.println("<option value='"+rspc.getString(1)+"' >"+rspc.getString(2)+"</option>");
                             }
                        
                         }
                    }else{
                        
                          while(rspc.next()){
                        out.println("<option value='"+rspc.getString(1)+"'>"+rspc.getString(2)+"</option>");
                         }
                    }
                   out.println("</select><br>Description:<input type='textarea' name='txtDesc' value='"+editDesc+"'><br>");
                    out.println("<br><input type='submit' name='btnsubmit' value='Add Product'>");
                    out.println("</form>");
                   

                    stmtpc.close();
                    cn.close();
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
