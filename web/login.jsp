<%-- 
    Document   : login.jsp
    Created on : 24 oct. 2022, 16:43:41
    Author     : gabriel
--%>

<%@page import="java.io.InputStream"%>
<%@page import="com.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Proyectos - Login</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.min.css" />

    </head>

    <body class="bg-dark">

        <div class="container">
            <div class="card card-login mx-auto mt-5">
                <div class="card-header">Inicio de sesi&oacute;n</div>
                <div class="card-body">
                    <form action="${pageContext.servletContext.contextPath}/LoginServlet" method="POST">
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="text" id="txtUser" name="txtUser" class="form-control" required="required">
                                <label for="inputEmail">Usuario</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="password" id="txtPass" name="txtPass" class="form-control" required="required">
                                <label for="inputPassword">Contrase&ntilde;a</label>
                            </div>
                        </div>
                        <div class="form-group">
                        </div>
                        <button class="btn btn-primary btn-block" name="btnLogin" type="submit">Acceder</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        <%
            //capturar todas las sesiones
            HttpSession sesion = request.getSession();
            if (request.getAttribute("mensaje") != null) {
        %>
        <script>alert('<%= request.getAttribute("mensaje")%>')</script>
        <%
            }
            ArrayList<Usuario> lista = new ArrayList<>();
            if (request.getAttribute("datos") != null) {
                lista = (ArrayList<Usuario>) request.getAttribute("datos");
                String nameUser = "";
                InputStream pathFoto = null;
                int idUser = 0;
                int estado = 0;
                for (Usuario elem : lista) {
                    idUser = elem.getIdUser();
                    nameUser = elem.getUsername();
                    pathFoto = elem.getPathFoto();
                    estado = elem.getEstado();
                }

                //crear variables de sesion
                if (estado == 1) {
                    session.setAttribute("id", idUser);
                    sesion.setAttribute("usuario", nameUser);
                    sesion.setAttribute("pathFoto", pathFoto);
                    sesion.setAttribute("logged_in", "activa");
                    response.sendRedirect("index.jsp");//redireccionar
                } else {
        %>
        <script>
            $(document).ready(function () {
                Swal.fire({
                    position: 'top-center',
                    icon: 'error',
                    title: 'Usuario deshabilitado',
                    showConfirmButton: false,
                    timer: 3000
                });
            });
        </script>
        <%
                }

            }

            //validacion para cerrar la sesion
            if (request.getParameter("cerrar") != null) {
                sesion.invalidate();
                response.sendRedirect("login.jsp");
            }
        %>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.all.min.js"></script>

    </body>

</html>

