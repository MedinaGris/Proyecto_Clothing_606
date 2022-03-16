
package controler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*  
Author: Griselda Medina Avendaño
    Creado : 16 mar 2022
    Actualización: 
    Descripción:
*/

public class ListaUsuariosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            out.println("<h1> Servlet </h1>");
        
    }

   
    

}
