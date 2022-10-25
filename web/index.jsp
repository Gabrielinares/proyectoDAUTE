<%-- 
    Document   : index.jsp
    Created on : 24 oct. 2022, 15:55:28
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<%
    HttpSession ses = request.getSession();
    String usuario = "";
    String pf = "";
    if (ses.getAttribute("usuario") != null && ses.getAttribute("pathFoto") != null && ses != null) {
        usuario = ses.getAttribute("usuario").toString();
        pf = ses.getAttribute("pathFoto").toString();
    }else{
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Inicio</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

    <%@include file="/template/navbar.jsp" %>

  <div id="wrapper">

    <!-- Sidebar -->
    <%@include file="/template/sidebar.jsp" %>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="#">Dashboard</a>
          </li>
          <li class="breadcrumb-item active">Overview</li>
        </ol>

        <h1>Sistema de proyectos - SISV11</h1>
        
      </div>
      <!-- /.container-fluid -->

      <!-- Sticky Footer -->
      <%@include file="/template/footer.jsp" %>

    </div>
    <!-- /.content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugin JavaScript-->
  <script src="vendor/chart.js/Chart.min.js"></script>
  <script src="vendor/datatables/jquery.dataTables.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin.min.js"></script>

  <!-- Demo scripts for this page-->
  <script src="js/demo/datatables-demo.js"></script>
  <script src="js/demo/chart-area-demo.js"></script>

</body>

</html>

