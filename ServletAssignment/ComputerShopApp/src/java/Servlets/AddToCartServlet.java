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
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author snehal
 */
public class AddToCartServlet extends HttpServlet {

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
            out.println("<title>Servlet AddToCartServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            HttpSession s=request.getSession();
           String pid=request.getParameter("Productid");
           int uid= (int) s.getAttribute("userId");
          String total="";
           String URL="jdbc:mysql://localhost/ComputerShoppingAppDB";
            String user="snehal";
            String pass="snehal";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn=DriverManager.getConnection(URL,user,pass);
                String psql="";
                String Price="";
                psql="select * from ProductTB where ProductId="+pid;
                Statement pstmt=cn.createStatement();
                ResultSet prs =pstmt.executeQuery(psql);
                prs.absolute(1);
                Price = prs.getString(5);
                String Usql="";
                Usql="select * from CartTB";
                Statement ustmt=cn.createStatement();
                ResultSet urs =ustmt.executeQuery(Usql);
                String cartid="";
                int flag=0;
                while(urs.next()){
                    if(urs.getInt(2) == uid)
                    {
                        cartid=urs.getString(1);
                        flag=1;
                    }
                }
                ustmt.close();
                String sql="";
                String cdsql="";
                String id="";
                if(flag==1)
                {
                    sql="insert into CartDetailTB(CartId,ProductId,Qty,Price)values(?,?,?,?) ";
                    PreparedStatement stmt=cn.prepareStatement(sql);
                    stmt.setString(1, cartid );
                    stmt.setString(2, pid );
                    stmt.setString(3, "1" );
                    stmt.setString(4, Price );
                    int row=stmt.executeUpdate();
                    if(row>0){
                       response.sendRedirect("CustomerHomePage");
                        System.out.println("succefully add to cart");
                    }
                    stmt.close();
                }
                if(flag==0)
                {
                     sql="insert into CartTB(UserId)values(?)";
                     PreparedStatement stmt=cn.prepareStatement(sql);
                     stmt.setInt(1, uid );
                     int row=stmt.executeUpdate();
                     try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                     if (generatedKeys.next()) {

                         id = (String)generatedKeys.getString(1);
                        System.out.println("Inserted ID -" + id);
                     }
           
                    }
                      stmt.close();
                      if(row>0){
                    cdsql="insert into CartDetailTB(CartId,ProductId,Qty,Price)values(?,?,?,?) ";
                    PreparedStatement cdstmt=cn.prepareStatement(cdsql);
                    cdstmt.setString(1, id );
                    cdstmt.setString(2, pid );
                    cdstmt.setString(3, "1" );
                    cdstmt.setString(4, Price );
                    int cdrow=cdstmt.executeUpdate();
                     if(cdrow>0){
                       response.sendRedirect("CustomerHomePage");
                        System.out.println("succefully add to cart");
                    }
                    cdstmt.close();
                      }
                }
               

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
