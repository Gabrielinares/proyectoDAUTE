/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controlador;

import com.dao.ProyectoDAO;
import com.modelo.Proyecto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabriel
 */
public class ProyectoServlet extends HttpServlet {

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
            String nombre = request.getParameter("txtNombre");
            double costo = Double.parseDouble(request.getParameter("txtCosto"));
            String estado = request.getParameter("txtEstado");
            int depto = Integer.parseInt(request.getParameter("txtDepto"));
            String razon = "";
            int codigoC = 0;
            
            int res = 0;
            String msj = "";
            
            ProyectoDAO pdao = new ProyectoDAO();
            Proyecto p = new Proyecto(codigo, nombre, estado, costo, null, depto);
            
            if(request.getParameter("btnGuardar") != null){
                res = pdao.agregarProyecto(p);
                if (res != 0){
                    msj = "Registro agregado";
                }
            } else if(request.getParameter("btnEditar") != null){
                res = pdao.modificarProyecto(p);
                if (res != 0){
                    msj = "Registro modificado";
                }
            } else if(request.getParameter("btnEliminar") != null){
                res = pdao.eliminarProyecto(p);
                if (res != 0){
                    msj = "Registro eliminado";
                }
            } else if(request.getParameter("btnCancelar") != null){
                codigoC = Integer.parseInt(request.getParameter("txtCodigoC"));
                razon = request.getParameter("txtCancel");
                res = pdao.cancelarProyecto(razon, codigoC);
                if (res != 0){
                    msj = "Registro cancelado";
                }
            }
            
            request.setAttribute("message", msj);
            request.getRequestDispatcher("/vistas/proyecto.jsp").forward(request, response);
            
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
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
