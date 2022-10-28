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

            <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/vistas/empleado.jsp#">Empleado</a>
            <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/vistas/detalleempleado.jsp">Detalle Empleado</a>

            <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/vistas/proyecto.jsp">Proyectos</a>
            <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/vistas/departamento.jsp">Departamentos</a>
            <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/vistas/municipio.jsp">Municipios</a>
        </div>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-file"></i>
            <span>Reportes</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Visualizar:</h6>
            <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/vistasReportes/proyectosGastos.jsp">Gasto de todos <br> los proyectos</a>
            <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/vistasReportes/proyectosED.jsp">Proyectos por estado y <br>departamento</a>
            <a class="dropdown-item" href="#">Emisi&oacute;n de boleta <br> de pagos</a>
            <a class="dropdown-item" href="#">Proyectos que est&eacute;n en <br> ejecuci&oacute;n entre <br> un rango de fechas</a>
            <a class="dropdown-item" href="#">Proyectos entregados <br> entre fechas</a>
            <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/vistasReportes/proyectosGEF.jsp">Ganancia de proyectos <br> entre 2 fechas</a>


        </div>
    </li>
</ul>