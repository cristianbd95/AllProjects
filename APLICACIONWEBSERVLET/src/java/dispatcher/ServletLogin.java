package dispatcher;

import factoria2.Conexion;
import factoria2.OperacionCrud;
import factoria2.OperacionesJPA;
import factoria2.Vendedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        OperacionesJPA oc = new OperacionesJPA();
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Enviar")) {
            String login = request.getParameter("txtLogin");
            int password = Integer.parseInt(request.getParameter("txtPassword"));
            Vendedor vendedor = oc.Validar(login, password);
            if (vendedor != null) {
                HttpSession misession = request.getSession(true);
                String nombre = vendedor.getNombre();
                misession.setAttribute("logeado", nombre);
                
                request.setAttribute("usuario", vendedor); //Enviar este objeto a principal.jsp
                request.getRequestDispatcher("Controlador?direccion=principal").forward(request, response);
            } else {
                request.getRequestDispatcher("/dispatcher/formulario.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/dispatcher/formulario.jsp").forward(request, response);
        }
    }

}
