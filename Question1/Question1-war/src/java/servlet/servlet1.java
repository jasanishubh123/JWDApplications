/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ejb.currency;
import ejb.currencyejb;
import ejb.currencyejbLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shubham
 */
public class servlet1 extends HttpServlet {

    @EJB currencyejbLocal cc;
    Double from=0.0;
            Double to=0.0;
            Double money=0.0;
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
            out.println("<title>Servlet servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println(cc.getdata());
             Collection<currency> c=cc.getdata();
             out.println("<form action='servlet1' method='post'>");
             out.println("Money: <input type='text' name='money'/><br><br>");
            out.println("From: <select name='fromdrop'>");
             for (currency i : c){
                 
              out.println("<option value='"+i.getCurrencyStandard()+"'>"+i.getCurrencyName()+"</option>");
          }
            out.println("</select><br><br>");
             out.println("To:&nbsp;&nbsp;&nbsp;&nbsp; <select name='todrop'>");
             for (currency i : c){
                 
              out.println("<option value='"+i.getCurrencyStandard()+"'>"+i.getCurrencyName()+"</option>");
          }
            out.println("</select><br><br>");
            
            out.println("<input type='submit' value='Convert'>");
            
 
            //out.println("<h1>Servlet servlet1 at " + request.getContextPath() + "</h1>");
            
                    from=Double.parseDouble(request.getParameter("fromdrop"));
            to=Double.parseDouble(request.getParameter("todrop"));
            money=Double.parseDouble(request.getParameter("money"));
            
//            out.print(from+"<br>");
//out.print(to+"<br>");
//out.print(money+"</br>");            

            if(from!=0.0 && to!=0.0 && money!=0.0){
                out.println("Answer Is "+Math.round(cc.Calculate(from, to, money)));
            }
            
            out.println();
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
