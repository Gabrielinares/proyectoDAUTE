/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controlador;

import com.dao.DetalleEmpleadoDAO;
import com.modelo.DetalleEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manmn
 */
public class DEServlet extends HttpServlet {

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
            
            int dui = Integer.parseInt(request.getParameter("txtCodigo"));
            Date fechaI = Date.valueOf(request.getParameter("txtFechaI"));
            Date fechaF = Date.valueOf(request.getParameter("txtFechaF"));
            int Emp = Integer.parseInt(request.getParameter("txtEmp"));
            int ProyId = Integer.parseInt(request.getParameter("txtProy"));
            
            int res = 0;
            String msj = "";
            
            DetalleEmpleadoDAO dedao = new DetalleEmpleadoDAO();
            DetalleEmpleado de = new DetalleEmpleado(dui, fechaI, fechaF, ProyId, Emp);
            
            if(request.getParameter("btnGuardar") != null){
                res = dedao.agregarDE(de);
                if(res != 0){
                    msj = "Registro agregado";
                }
            } else if(request.getParameter("btnEditar") != null){
                res = dedao.modificarDE(de);
                if(res != 0){
                    msj = "Registro editado";
                }
            } else if(request.getParameter("btnEliminar") != null){
                res = dedao.eliminarDE(de);
                if(res != 0){
                    msj = "Registro eliminado";
                }
            }
            request.setAttribute("message", msj);
            request.getRequestDispatcher("/vistas/detalleempleado.jsp").forward(request, response);
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
