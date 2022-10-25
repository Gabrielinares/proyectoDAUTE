<%-- 
    Document   : detallemaquinaria
    Created on : 24 oct. 2022, 18:24:23
    Author     : gabriel
--%>

<%@page import="com.modelo.Maquinaria"%>
<%@page import="com.dao.MaquinariaDAO"%>
<%@page import="com.modelo.DetalleMaquinaria"%>
<%@page import="java.util.ArrayList"%>
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

        <title>Gesti&oacute;n de maquinaria</title>

        <!-- Custom fonts for this template-->
        <link href="${pageContext.servletContext.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="${pageContext.servletContext.contextPath}/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="${pageContext.servletContext.contextPath}/css/sb-admin.css" rel="stylesheet">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.min.css" />

    </head>

    <body id="page-top">

        <%
            MaquinariaDAO mdao = new MaquinariaDAO();
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
                            <a href="#">Maquinaria</a>
                        </li>
                        <li class="breadcrumb-item active">Overview</li>
                    </ol>

                    <div class="row">
                        <div class="col-lg-8">
                            <h1>Gesti&oacute;n de maquinaria</h1>
                        </div>
                        <div class="col-lg-4">
                            <button type="button" class="btn btn-success float-right btnAdd" data-toggle="modal" data-target="#exampleModal">Agregar</button>

                        </div>
                    </div>
                    <hr>

                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>

                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>C&oacute;digo</th>
                                            <th>Nombre</th>
                                            <th>Descripci&oacute;n</th>
                                            <th>Cantidad</th>
                                            <th>Acciones</th>

                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>C&oacute;digo</th>
                                            <th>Nombre</th>
                                            <th>Descripci&oacute;n</th>
                                            <th>Cantidad</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%
                                            ArrayList<Maquinaria> lista = mdao.mostraMaquinarias();

                                            String estado = "";

                                            for (Maquinaria elem : lista) {
                                        %>
                                        <tr>
                                            <td class="codigo"><%= elem.getIdMaquinaria()%></td>
                                            <td class="nombre"><%= elem.getNombreMaquinaria()%></td>
                                            <td class="desc"><%= elem.getDesc()%></td>
                                            <td class="cant"><%= elem.getCant()%></td>
                                            <td>
                                                <button type="button" class="btn btn-dark btnEditar" data-toggle="modal" data-target="#exampleModal">Editar</button>
                                                <button type="button" class="btn btn-danger btnEliminar" data-toggle="modal" data-target="#exampleModal">Eliminar</button>
                                            </td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->
                <%@include file="../template/footer.jsp" %>

            </div>
            <!-- /.content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Datos maquinaria</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="${pageContext.servletContext.contextPath}/MaqServlet" method="POST" id="form">
                            <div class="row">
                                <div class="col-6">
                                    <label>Codigo</label>
                                    <input type="text" name="txtCodigo" class="form-control" id="txtCodigo" value="0" readonly="true">
                                </div>
                                <div class="col-6">
                                    <label>Nombre</label>
                                    <input type="text" name="txtNombre" class="form-control" id="txtNombre">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Descripci&oacute;n</label>
                                    <input type="text" name="txtDesc" class="form-control" id="txtDesc">
                                </div>
                                <div class="col-6">
                                    <label>Cantidad</label><br>
                                    <input type="number" name="txtCant" class="form-control" id="txtCant">
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="col-12">
                                    <button type="submit" name="btnGuardar" class="btn btn-success btnOcultar1">Guardar</button>
                                    <button type="submit" name="btnEditar" class="btn btn-dark btnOcultar">Editar</button>
                                    <button type="submit" name="btnEliminar" class="btn btn-danger btnOcultar">Eliminar</button>
                                    <button type="button" class="btn btn-info" data-dismiss="modal">Cancelar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
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

        <%
            if (request.getAttribute("message") != null) {
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

        <script src="${pageContext.servletContext.contextPath}/js/maquinaria.js"></script>
    </body>

</html>