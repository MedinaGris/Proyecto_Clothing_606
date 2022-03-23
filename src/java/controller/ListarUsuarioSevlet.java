/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class ListarUsuarioSevlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
            out.println("<head>");
                out.println("<link rel='stylesheet' href='"+request.getContextPath()+"/resources/css/estilo.css'>");
                System.out.println(request.getContextPath());
            out.println("</head>");

            out.println("<body>");

                out.println("<table border='2'>");

                    out.println("<tr>");

                        out.println("<th>Código</th>");

                        out.println("<th>Nombre de usuario</th>");

                        out.println("<th>Contraseña</th>");
                        out.println("<th>Sexo</th>");
                        out.println("<th>Edad</th>");
                        out.println("<th>Editar</th>");
                        out.println("<th>Eliminar</th>");
                        out.println("</tr>");

                    IUsuarioService service = new UsuarioServiceImpl();

                    List<Usuario> listaUsuario = service.obtenerRegistros();

                    out.println("<tbody>");
                    for (Usuario usuario : listaUsuario) {
                        out.println("<tr>");
                            out.println("<td>"+usuario.getcodigo()+"</td>");
                            out.println("<td>"+usuario.getNombreUsuario()+"</td>");
                            out.println("<td>"+usuario.getContraseña()+"</td>");
                            out.println("<td>"+usuario.getSexo()+"</td>");
                            out.println("<td>"+usuario.getEdad()+"</td>");
                            out.println("<td><a href= '/Proyecto_Clothing_606/EditarUsuarioServle?idUsuario="+usuario.getcodigo()+"'>Editar</a></td>)");
                            
                            out.println("<td><a href= '/Proyecto_Clothing_606/EliminarUsuarioServle?idUsuario="+usuario.getcodigo()+"'>Eliminar</a></td>");
                   

                        out.println("</tr>");
                    }
                    out.println("</tbody>");

                out.println("</table>");

            out.println("</body>");

        out.println("</html>");

    }
  }

   


