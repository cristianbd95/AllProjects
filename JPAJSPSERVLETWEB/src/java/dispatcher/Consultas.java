/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatcher;

import entidades.Cliente;
import factoria2.Conexion;
import factoria2.Consulta1;
import factoria2.Consulta2;
import factoria2.ConsultasCrud;
import factoria2.OperacionesJPA;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Consultas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Conexion c = new Conexion(true);
            Connection conexion = c.getConexion();
            ConsultasCrud cc = new ConsultasCrud();

            List<Consulta2> consultas2_al = cc.obtenerConsulta2(conexion);
            
            OperacionesJPA oj = new OperacionesJPA();
            
            List<Cliente> clientes_al = oj.BuscarTodosClientes();

            String boton = request.getParameter("btoEnviar");
            if (boton.equals("Enviar")) {
                if (clientes_al != null) {
                    request.setAttribute("EnvioDatos", clientes_al);
                    request.getRequestDispatcher("/dispatcher/consulta1.jsp?control=llego").forward(request, response);
                } else {
                    out.println("ERROR CONSULTA");
                }
            }
            if (boton.equals("Enviar consulta")) {
                if (consultas2_al != null) {
                    request.setAttribute("EnvioDatos", consultas2_al);
                    request.getRequestDispatcher("/dispatcher/consulta2.jsp?control=llego").forward(request, response);
                } else {
                    out.println("ERROR CONSULTA");
                }
            }

        }
    }

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
