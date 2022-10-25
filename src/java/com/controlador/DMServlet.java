/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controlador;

import com.dao.DetalleMaquinariaDAO;
import com.modelo.DetalleMaquinaria;
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
public class DMServlet extends HttpServlet {

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
            String fechaI = request.getParameter("txtFechaI");
            String fechaF = request.getParameter("txtFechaF");
            int ProyId = Integer.parseInt(request.getParameter("txtProy"));
            int MaqId = Integer.parseInt(request.getParameter("txtMaq"));
            
            int res = 0;
            String msj = "";
            
            DetalleMaquinariaDAO dmdao = new DetalleMaquinariaDAO();
            DetalleMaquinaria dm = new DetalleMaquinaria(codigo, fechaI, fechaF, ProyId, MaqId);
            
            if(request.getParameter("btnGuardar") != null){
                res = dmdao.agregarDM(dm);
                if(res != 0){
                    msj = "Registro agregado";
                }
            } else if(request.getParameter("btnEditar") != null){
                res = dmdao.modificarDM(dm);
                if(res != 0){
                    msj = "Registro editado";
                }
            } else if(request.getParameter("btnEliminar") != null){
                res = dmdao.eliminarDM(dm);
                if(res != 0){
                    msj = "Registro eliminado";
                }
            }
            request.setAttribute("message", msj);
            request.getRequestDispatcher("/vistas/detallemaquinaria.jsp").forward(request, response);
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
