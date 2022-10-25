<%-- 
    Document   : session
    Created on : 25 oct. 2022, 12:36:02
    Author     : gabriel
--%>
<%@page session="true" %>


<%
    HttpSession ses = request.getSession();
    String usuario = "";
    String pf = "";
    int id = 0;
    if (ses.getAttribute("usuario") != null && ses.getAttribute("pathFoto") != null && ses != null && ses.getAttribute("id") != null) {
        usuario = ses.getAttribute("usuario").toString();
        pf = ses.getAttribute("pathFoto").toString();
        id = Integer.parseInt(ses.getAttribute("id").toString());
    }else{
        response.sendRedirect("login.jsp");
    }
%>
