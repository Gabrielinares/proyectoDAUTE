<%-- 
    Document   : usuarios
    Created on : 24 oct. 2022, 16:31:33
    Author     : gabriel
--%>

<%@page import="com.dao.EmpleadoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.modelo.Empleado"%>
<%@page import="com.dao.EmpleadoDAO"%>
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

        <title>Gesti&oacute;n de usuarios</title>

        <!-- Custom fonts for this template-->
        <link href="${pageContext.servletContext.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="${pageContext.servletContext.contextPath}/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="${pageContext.servletContext.contextPath}/css/sb-admin.css" rel="stylesheet">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.min.css" />


    </head>

    <body id="page-top">

        <%            EmpleadoDAO edao = new EmpleadoDAO();
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
                            <a href="#">Empleados</a>
                        </li>
                        <li class="breadcrumb-item active">Overview</li>
                    </ol>

                    <div class="row">
                        <div class="col-lg-8">
                            <h1>Gesti&oacute;n de Empleados</h1>
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
                                            <th>DUI</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Disponible</th>
                                            <th>Salario</th>
                                            <th>Telefono</th>
                                            <th>Acciones</th>

                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>DUI</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Disponible</th>
                                            <th>Salario</th>
                                            <th>Telefono</th>
                                            <th>Acciones</th>

                                        </tr>
                                    </tfoot>
                                    <tbody id="construirTabla">
                                        <%
                                            ArrayList<Empleado> lista = edao.mostrarEmpleados();

                                            String estado = "";

                                            for (Empleado elem : lista) {
                                                if (elem.getDisp()== 1) {
                                                    estado = "Si";
                                                } else if (elem.getDisp() != 1) {
                                                    estado = "No";
                                                }

                                        %>
                                        <tr>
                                            <td class="dui"><%= elem.getDui()%></td>
                                            <td class="NombreEmp"><%= elem.getNombreEmp()%></td>
                                            <td class="ApellidoEmp"><%= elem.getApellidoEmp()%></td>
                                            <td align="center" class="Disp"><%= estado%></td>
                                            <td class="Salario"><%= elem.getSalario()%></td>
                                            <td class="Telefono"><%= elem.getTelefono()%></td>
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
                        <h5 class="modal-title" id="exampleModalLabel">Datos Empleado</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="${pageContext.servletContext.contextPath}/EmpleadoServlet" method="POST" id="form">
                            <div class="row">
                                <div class="col-6">
                                    <label>DUI</label>
                                    <input type="number" name="txtDui" class="form-control" id="txtDui" required>
                                </div>
                            </div> <br>
                            <div class="row">
                                <div class="col-6">
                                    <label>Nombre</label>
                                    <input type="text" name="txtNom" class="form-control" id="txtNom" required>
                                </div>
                                <div class="col-6">
                                    <label>Apellido</label><br>
                                    <input type="text" name="txtApe" class="form-control" id="txtApe" required>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Salario</label>
                                    <input type="number" name="txtSal" class="form-control" id="txtSal" required>
                                </div>
                                <div class="col-6">
                                    <label>Telefono</label><br>
                                    <input type="number" name="txtTel" class="form-control" id="txtTel" required>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <label>Disponibilidad</label><br>
                                    <select name="txtDisp" id="txtDisp" required>
                                        <option value="3"> Seleccione... </option>
                                        <option value="1"> Si </option>
                                        <option value="0"> No </option>

                                    </select>
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

        <script src="${pageContext.servletContext.contextPath}/js/empleado.js"></script>
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
    </body>

</html>
