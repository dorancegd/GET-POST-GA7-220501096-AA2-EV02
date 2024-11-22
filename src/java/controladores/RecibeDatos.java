/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Anotación para simplificar la configuración del servlet
@WebServlet(name = "RecibeDatos", urlPatterns = {"/RecibeDatos"})
public class RecibeDatos extends HttpServlet {

    // Método para manejar la lógica de validación de usuario y contraseña
    private boolean validarUsuario(String usuario, String clave) {
        return "Admin".equals(usuario) && "1234".equals(clave);
    }

    // Método principal para procesar solicitudes
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String mensaje)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + mensaje + "</h1>");
            out.println("<a href='index.html'>Volver al formulario</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        String mensaje = validarUsuario(usuario, clave) ? "Registro exitoso" : "Registro no exitoso";
        processRequest(request, response, mensaje);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        String mensaje = validarUsuario(usuario, clave) ? "Registro exitoso" : "Registro no exitoso";
        processRequest(request, response, mensaje);
    }

    @Override
    public String getServletInfo() {
        return "Servlet que procesa datos de un formulario y valida el usuario y la contraseña.";
    }
}
