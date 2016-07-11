/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.IOException;
import java.sql.Connection;
import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yoshi
 */
public class LoginCheck extends HttpServlet {

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
        
//        HttpSession session = request.getSession();
        UserDataDTO udd = new UserDataDTO();
        UserData ud = new UserData();

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        try {
            /*非ログイン状態でのみアクセス可能
            入力フォームの確認と、ログイン判定に使用するuserIDをsessionに入れて他のページで使いまわす*/
            
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            ud.setName(name);
            ud.setPassword(password);
            ud.UD2DTOMapping(udd);
            
            UserDataDTO userdata = UserDataDAO.getInstance().LoginCheck(udd);
            ud.DTO2UDMapping(udd);
            
            if (ud.getUserID() > 0) {
                session.setAttribute("userdata", ud);
                request.getRequestDispatcher(response.encodeURL(session.getAttribute("referer").toString().substring(34))).forward(request, response);
            } else {
                request.setAttribute("error", "名前かパスワードが違います");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

//        try {
//            request.setCharacterEncoding("UTF-8");
//            
//            String name = request.getParameter("name");
//            String password = request.getParameter("password");
//            
//            ud.setName(name);
//            ud.setPassword(password);
//            
//            ud.UD2DTOMapping(udd);
//            
//            System.out.print("---------------------");
//            System.out.print(udd.getName());
//            System.out.print(udd.getPassword());
//            System.out.print(UserDataDAO.getInstance().LoginCheck(udd));
//            
//            udd = UserDataDAO.getInstance().LoginCheck(udd);
//            ud.DTO2UDMapping(udd);
//            
//            if (ud.getUserID() > 0) {
//                session.setAttribute("ud", ud);
//                request.getRequestDispatcher(session.getAttribute("referer").toString().substring(35)).forward(request, response);
//            } else {    
//                request.setAttribute("error", "名前かパスワードが違います");
//                request.getRequestDispatcher("/login.jsp").forward(request, response);
//            }
//        }catch (Exception e) {
//            request.setAttribute("error", e.getMessage());
//            request.getRequestDispatcher("/error.jsp").forward(request, response);
//        }
//    }

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
