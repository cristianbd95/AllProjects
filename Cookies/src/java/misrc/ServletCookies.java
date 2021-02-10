/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misrc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Campus FP
 */
public class ServletCookies extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String login, password;
            String accion = request.getParameter("btoEnviar");

            if (accion != null) {
                if (accion.equals("Iniciar")) {
                    login = request.getParameter("txtLogin");
                    password = request.getParameter("txtPassword");
                    if (request.getParameter("chkRecordar").equals("on")) {
                        Cookie cookie = new Cookie("plogin", login);
                        cookie.setComment("cookie que guarda el login");
                        cookie.setMaxAge(60 * 60 * 24);
                        response.addCookie(cookie);
                        System.out.println("Cookie Creada");
                    }
                }
            }
            
        }
    }

    /* 
        si setMaxAge es 0 se cierra la cookie, si es negativo, no se recuerda la cookei
    */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
