<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!-- head -->
<%@include file="head.jsp" %>
<body class="bg-dark">
<!-- header -->
<%@include file="header.jsp" %>
<!-- main -->
<main>

    <div class="container-fluid text-center mt-5">
        <a href="/figus/configuracion" class="text-decoration-none">
            <button type='button' class='btn btn-warning my-2'>Volver</button>
        </a>
        <h1 class="text-white">Administrador de Usuarios</h1>

        <table class="table bg-opacity-7 rounded">
            <thead>
            <tr class="text-white">
                <th scope="col">Id</th>
                <th scope="col">Nombre</th>
                <th scope="col">Email</th>
                <th scope="col">Rol</th>
                <th scope="col">Estado</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="usuario" items="${usuarios}">
            <tr class="text-white">
                <td>${usuario.id}</td>
                <td>${usuario.nombre}</td>
                <td>${usuario.email}</td>
                <td>${usuario.rol}</td>
                <c:if test="${usuario.activo==true}">
                    <td>Activo</td>
                </c:if>
                <c:if test="${usuario.activo==false}">
                    <td>Inactivo</td>
                </c:if>
                <td>
                    <a href="eliminar/${usuario.id}">
                        <button class="btn btn-primary" type="submit">Eliminar</button>
                    </a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

</main>
<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>
