/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controlador;

import com.dao.UsuarioDAO;
import com.modelo.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author gabriel
 */
@MultipartConfig //Linea necesaria para procesar forms con imagenes
public class UsuarioServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
            String user = request.getParameter("txtUser");
            String contra = request.getParameter("txtPass");
            int estado = Integer.parseInt(request.getParameter("txtEstado"));
            Part part = request.getPart("foto");
            InputStream inputStream = part.getInputStream();

            int res = 0;
            String msj = "";
            
            UsuarioDAO udao = new UsuarioDAO();
            Usuario u = new Usuario(codigo, user, contra, estado, inputStream);
            
            if(request.getParameter("btnGuardar") != null){
                res = udao.agregarUsuario(u);
                if(res != 0){
                    msj = "Registro agregado";
                }
            } else if(request.getParameter("btnEditar") != null){
                res = udao.modificarUsuario(u);
                if(res != 0){
                    msj = "Registro editado";
                }
            } else if(request.getParameter("btnEliminar") != null){
                res = udao.eliminarUsuario(u);
                if(res != 0){
                    msj = "Registro eliminado";
                }
            }
            request.setAttribute("message", msj);
            request.getRequestDispatcher("/vistas/usuarios.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
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
