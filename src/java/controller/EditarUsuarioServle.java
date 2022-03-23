/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.IUsuarioService;
import service.UsuarioServiceImpl;

/**
 *
 * @author Medina
 * 22 marzo 2022 
 * 
 */
public class EditarUsuarioServle extends HttpServlet {

     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int idUsuario= Integer.parseInt(request.getParameter("idUsuario"));
        IUsuarioService service = new UsuarioServiceImpl();
        Usuario usuario = new Usuario();
        usuario = service.obtenerRegistro(idUsuario);
        //System.out.println("nombre: "+usuario.getNombreUsuario()+" password"+usuario.getContraseña());
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel='stylesheet' href='"+request.getContextPath()+"/resources/css/estiloFormulario.css'>");
        System.out.println(request.getContextPath());
        out.println("</head>");

       out.println("<body>");
       
       
       
       out.println("<form class='formulario' action ='EditarUsuarioServle' method='POST'>"); 
       out.println("<fieldset>");
       out.println("<legend>Modificar usuario</legend>");
       out.println("<div class=\"contenedor-campos\">");
       
       out.println("<div class=\"campo\">");
//       out.println("<label>id</label>");
       out.println("<input name= 'idUsuario' type='hidden' value='"+usuario.getcodigo()+"'>" );
       out.println("</div>");
       
       
       out.println("<div class=\"campo\">");
       out.println("<label>Nombre de usuario</label>");
       out.println("<input name='nombre' type='text' value='"+usuario.getNombreUsuario()+"'>" );
       out.println("</div>");
       
       
       
       out.println("<div class=\"campo\">");
       out.println(" <label>Contraseña</label>");
       out.println("<input name='password'  type='text' value='"+usuario.getContraseña()+"'>" );
       out.println("</div>");
       
       out.println("<div class=\"campo\">");
       out.println(" <label>Sexo</label>");
       out.println("<input name='sexo' type='text' value='"+usuario.getSexo()+"'>" );
       out.println("</div>");
       
       
       out.println("<div class=\"campo\">");
       out.println(" <label>Edad</label>");
       out.println("<input name='edad' type='text' value='"+usuario.getEdad()+"'>" );
       out.println("</div>");
       
       
       out.println("<div class=\"campo\">");
       out.println("<input type=submit value= 'Guardar'>" );
       out.println("</div>");
       
       
       out.println("</fieldset>");
       out.println("</form>");
       
       
    }
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
    System.out.println("usuario"+request.getParameter("nombre"));
    IUsuarioService service = new UsuarioServiceImpl();
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(request.getParameter("nombre"));
        usuario.setContraseña(request.getParameter("password"));
        usuario.setSexo(request.getParameter("sexo"));
        usuario.setEdad(Integer.parseInt(request.getParameter("edad")));
        usuario.setcodigo(Integer.parseInt(request.getParameter("idUsuario")));
        service.actualizarRegistro(usuario);
        response.sendRedirect("ListarUsuarioSevlet"); 
    
    }
}