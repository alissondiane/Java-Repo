<%@ page import="com.arteaga.practica04.bean.Cliente" %>
<%@ page import="com.arteaga.practica04.dao.impl.DaoFactory" %>
<%@ page import="com.arteaga.practica04.dao.ClienteDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 23/02/2021
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Nuevo Cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css">
</head>
<body>
<%
    Cliente a=new Cliente();
    String action ="graba";
    if(request.getParameter("codigo") != null){
        DaoFactory factory=DaoFactory.getInstance();
        ClienteDao dao=factory.getClienteDao(1);
        String codigo=request.getParameter("codigo");
        a = dao.find(codigo);
        action ="modifica";
    }else{
        a.setCodigo("");
        a.setNombre("");
        a.setApellido("");
        a.setCorreo("");
        a.setTelefono("");
        a.setTotalCompras(0.0);
    }
%>
<div class="container">
    <div class="row">
        <%if(request.getParameter("codigo") != null){%>
        <h1>Edición de Cliente</h1>
        <%}else{%>
        <h1>Cliente Nuevo</h1>
        <%}%>
        <hr>
        </br>
<form action="ServletClienteCrud" method="post">
    <div class="form-group row">
        <label for="txtCodigo" class="col-sm-2 col-form-label">Código:</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="txtCodigo" name="txtCodigo" value="<%=a.getCodigo()%>">
        </div>
    </div>
    <div class="form-group row">
        <label for="txtNombre" class="col-sm-2 col-form-label">Nombre:</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="txtNombre" name="txtNombre" value="<%=a.getNombre()%>">
        </div>
    </div>
    <div class="form-group row">
        <label for="txtApellido" class="col-sm-2 col-form-label">Apellido:</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="txtApellido" name="txtApellido" value="<%=a.getApellido()%>">
        </div>
    </div>
    <div class="form-group row">
        <label for="txtCorreo" class="col-sm-2 col-form-label">Correo:</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="txtCorreo" name="txtCorreo" value="<%=a.getCorreo()%>">
        </div>
    </div>
    <div class="form-group row">
        <label for="txtTelefono" class="col-sm-2 col-form-label">Teléfono:</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="txtTelefono" name="txtTelefono" value="<%=a.getTelefono()%>">
        </div>
    </div>
    <div class="form-group row">
        <label for="txtCompras" class="col-sm-2 col-form-label">Total Compras:</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="txtCompras" name="txtCompras" value="<%=a.getTotalCompras()%>">
        </div>
    </div>
    <input type="hidden" name="action" value="<%=action%>">
    <br>
    <button class="btn btn-primary" type="submit">Guardar <i class="fas fa-save"></i></button>

</form>
    </div>
</div>

</body>
</html>
