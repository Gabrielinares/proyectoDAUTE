<!-- Sidebar -->
<ul class="sidebar navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="${pageContext.servletContext.contextPath}/index.jsp">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Panel</span>
        </a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Administraci&oacute;n</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Gestionar:</h6>
            <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/vistas/usuarios.jsp">Usuarios</a>
            <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/vistas/maquinaria.jsp">Maquinaria</a>
            <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/vistas/detallemaquinaria.jsp">Maquinaria asignada</a>
            <a class="dropdown-item" href="#">Empleado</a>
            <a class="dropdown-item" href="#">Proyectos</a>
            <a class="dropdown-item" href="#">Departamentos</a>
            <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/vistas/municipio.jsp">Municipios</a>
        </div>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="charts.html">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Reportes</span></a>
    </li>
</ul>