<%-- 
    Document   : proyectosGEF
    Created on : 28 oct. 2022, 10:47:59
    Author     : User
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="com.conexion.Conexion"%>
<%@page import="com.modelo.Departamento"%>
<%@page import="com.dao.DepartamentoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/template/session.jsp" %>

<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Reporte de proyectos</title>

        <!-- Custom fonts for this template-->
        <link href="${pageContext.servletContext.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="${pageContext.servletContext.contextPath}/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="${pageContext.servletContext.contextPath}/css/sb-admin.css" rel="stylesheet">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.min.css" />


    </head>

    <body id="page-top">

        <%            DepartamentoDAO ddao = new DepartamentoDAO();
        %>

        <%@include file="../template/navbar.jsp" %>

        <div id="wrapper">

            <!-- Sidebar -->
            <%@include file="../template/sidebar.jsp" %>

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Proyectos</a>
                        </li>
                        <li class="breadcrumb-item active">Reportes</li>
                    </ol>

                    <div class="row">
                        <div class="col-lg-12">
                            <h1>Ganancia de proyectos entre 2 fechas</h1>
                        </div>
                    </div>
                    <hr>

                    <form action="proyectosGEF.jsp" method="post" id="form">
                        <div class="row">
                            <div class="col-6">
                                <label>Fecha inicial</label><br>
                                <input type="date" name="txtFecha1" class="form-control">
                            </div>
                            <div class="col-6">
                                <label>Fecha final</label><br>
                                <input type="date" name="txtFecha2" class="form-control">

                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-6">
                                <button type="submit" name="btnGenerar" class="btn btn-success">Generar</button>
                            </div>
                        </div>
                    </form>

                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->
                <%@include file="../template/footer.jsp" %>

            </div>
            <!-- /.content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <%
            if (request.getParameter("btnGenerar") != null) {
                Conexion con = new Conexion();
                con.conectar();
                File reportFile = new File(application.getRealPath("reportes/proyectoGananciaEF.jasper"));
                Map parametros = new HashMap();

                String f1S = request.getParameter("txtFecha1");
                //Date f1 = new SimpleDateFormat("dd/MM/yyyy").parse(f1S);

                String f2S = request.getParameter("txtFecha2");
                //Date f2 = new SimpleDateFormat("dd/MM/yyyy").parse(f2S);
                
                parametros.put("fecha1", f1S);
                parametros.put("fecha2", f2S);

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
            }

        %>

        <!-- Bootstrap core JavaScript-->
        <script src="${pageContext.servletContext.contextPath}/vendor/jquery/jquery.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="${pageContext.servletContext.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="${pageContext.servletContext.contextPath}/vendor/chart.js/Chart.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/vendor/datatables/jquery.dataTables.js"></script>
        <script src="${pageContext.servletContext.contextPath}/vendor/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="${pageContext.servletContext.contextPath}/js/sb-admin.min.js"></script>

        <!-- Demo scripts for this page-->
        <script src="${pageContext.servletContext.contextPath}/js/demo/datatables-demo.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/demo/chart-area-demo.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.all.min.js"></script>

        <script src="${pageContext.servletContext.contextPath}/js/departamento.js"></script>
        <%            if (request.getAttribute("message") != null) {
        %>
        <script>
            $(document).ready(function () {
                Swal.fire({
                    position: 'top-center',
                    icon: 'success',
                    title: '<%= request.getAttribute("message")%>',
                    showConfirmButton: false,
                    timer: 3000
                });
            });
        </script>
        <%
            }
        %>
    </body>

</html>

