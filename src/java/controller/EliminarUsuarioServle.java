/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.IUsuarioService;
import service.UsuarioServiceImpl;

/**
 *
 * @author Medina
 */
public class EliminarUsuarioServle extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           if(request.getParameter("idUsuario") != null){
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));//revisar
                IUsuarioService service = new UsuarioServiceImpl();
                service.eliminarRegistro(idUsuario);

//              response.sendRedirect("ListarUsuarioSevlet");   
           }
//          request
          response.sendRedirect("ListarUsuarioSevlet"); 
          
    }

    

}
