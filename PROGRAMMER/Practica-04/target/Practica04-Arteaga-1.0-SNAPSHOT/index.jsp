<%@ page import="com.arteaga.practica04.bean.Cliente" %>
<%@ page import="com.arteaga.practica04.dao.impl.DaoFactory" %>
<%@ page import="com.arteaga.practica04.dao.ClienteDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <title>Mantenimiento Clientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

</head>
<body>

<div class="container">
    <div class="row">
        <h1>Mantenimiento de clientes</h1>
        <hr>
        <br>
        <div style="display: flex;justify-content: flex-end;margin-bottom: 10px;">
            <a class="btn btn-danger mx-2" href="ServletReporte" role="button">Reporte PDF  <i class="fas fa-file-pdf"></i></a>
            <a class="btn btn-success mx-2" href="ServletExcel1" role="button">Reporte Excel  <i class="fas fa-file-excel"></i></a>
            <a class="btn btn-secondary mx-2" href="ServletPie" role="button">Gráfico Pie  <i class="fas fa-chart-pie"></i></a>
            <a class="btn btn-primary" href="nuevo.jsp" role="button">Nuevo  <i class="fas fa-plus"></i></a>
        </div>



        <div class="col-md-12"><table class="table table-striped">
            <thead class="bg-primary text-white">
            <tr>
                <td>Código</td>
                <td>Nombre</td>
                <td>Apellido</td>
                <td>Correo</td>
                <td>Teléfono</td>
                <td>Modificar</td>
                <td>Eliminar</td>
            </tr>
            </thead>
            <tbody>
            <%
                DaoFactory factory=DaoFactory.getInstance();
                ClienteDao dao=factory.getClienteDao(1);
                List<Cliente> lista=dao.findAll();
                for(Cliente cli:lista){
            %>
            <tr>
                <td><%=cli.getCodigo()%></td>
                <td><%=cli.getNombre()%></td>
                <td><%=cli.getApellido()%></td>
                <td><%=cli.getCorreo()%></td>
                <td><%=cli.getTelefono()%></td>
                <td><a class="btn btn-primary" href="nuevo.jsp?codigo=<%=cli.getCodigo()%>" role="button">
                    <i class="fas fa-edit"></i></a>
                </td>
                <td><a class="btn btn-danger" href="ServletClienteCrud?action=elimina&codigo=<%=cli.getCodigo()%>" role="button">
                    <i class="fas fa-trash-alt"></i></a>
                </td>

            </tr>
            <% } %>
            </tbody>
        </table></div>


        <%if(request.getParameter("mensaje")!=null){%>
        <div class="alert alert-primary" role="alert">
            <%=request.getParameter("mensaje")%>
        </div>
        <%}%>
    </div>
</div>

</body>
</html>