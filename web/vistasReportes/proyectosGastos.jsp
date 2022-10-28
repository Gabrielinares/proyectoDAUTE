<%-- 
    Document   : proyectosGastos
    Created on : 28 oct. 2022, 11:18:00
    Author     : User
--%>

<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="com.conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de proyectos</title>
    </head>
    <body>
        <%
            Conexion con = new Conexion();
            con.conectar();
            File reportFile = new File(application.getRealPath("reportes/proyectoGastos.jasper"));
            Map parametros = new HashMap();

            //String estado = request.getParameter("txtEstado");
            //int depto = Integer.parseInt(request.getParameter("txtDepto"));
            //parametros.put("estado", estado);
            //parametros.put("idDepto", depto);
            //agregar el jasper en binario
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parametros, con.getCon());
            response.setContentType("application/pdf");//indicar el tipo de aplicacion
            response.setContentLength(bytes.length);
            //variable de salida para el reporte
            ServletOutputStream output = response.getOutputStream();
            response.getOutputStream();
            output.write(bytes, 0, bytes.length);//escribir el documento jasper
            output.flush();
            output.close();
            con.desconectar();

        %>
    </body>
</html>
