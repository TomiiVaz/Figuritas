<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h1 class="text-white">Administrador de Selecciones</h1>
        <div class="mt-5">
            <button class="btn btn-primary me-3" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseAgregar"
                    aria-expanded="false" aria-controls="collapseAgregar">
                Agregar
            </button>
            <button class="btn btn-primary me-3" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseEditar"
                    aria-expanded="false" aria-controls="collapseEditar">
                Editar
            </button>
            <button class="btn btn-primary " type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseEliminar"
                    aria-expanded="false" aria-controls="collapseEliminar">
                Eliminar
            </button>
        </div>
    </div>

    <%--    Formulario Agregar--%>
    <div class="collapse mt-5 container-fluid" id="collapseAgregar">
        <div class="card card-body bg-dark border-0 container">
            <h2 class="text-white text-center">Formulario agregar</h2>
            <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                       method='post'
                       action='crear-seleccion'
                       modelAttribute="selecciones">
                <input class='my-2 form-control' type='text' name='nombre' id='nombre'
                       placeholder='Ingrese el nombre de la seleccion'>
                <button type='submit' class='btn btn-success my-2'>Agregar</button>
            </form:form>
        </div>
    </div>
    <%--    /Formulario Agregar--%>

    <%--    Formulario Editar--%>
    <div class="collapse mt-5 container-fluid" id="collapseEditar">
        <div class="card card-body bg-dark border-0 container">
            <h2 class="text-white text-center">Formulario editar</h2>
            <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                       method='post'
                       action='ver-selecciones'
                       modelAttribute="selecciones">
                <select id='seleccionId' name='seleccionId' class='form-control my-2'>
                    <c:forEach var="seleccion" items="${selecciones}">
                        <option value='Default' selected hidden>Seleccionar una selección</option>
                        <option value='${seleccion.id}'>${seleccion.nombre}</option>
                    </c:forEach>
                </select>
                <input class='my-2 form-control' type='text' id="nombreNuevo" name="nombreNuevo"
                       placeholder='Ingrese el nuevo nombre'>

                <button type='submit' class='btn btn-success my-2'>Editar</button>

            </form:form>
        </div>
    </div>
    <%--    /Formulario Editar--%>

    <%--    Formulario Borrar--%>
    <div class="collapse mt-5 container-fluid" id="collapseEliminar">
        <div class="card card-body bg-dark border-0 container">
            <h2 class="text-white text-center">Formulario eliminar</h2>
            <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                       method='post'
                       action='del-seleccion'
                       modelAttribute="selecciones">
                <select path='seleccionId' id='seleccionId' name='seleccionId' class='form-control my-2'>
                    <c:forEach var="seleccion" items="${selecciones}">
                        <option value='Default' selected hidden>Seleccionar una selección a borrar</option>
                        <option value='${seleccion.id}'>${seleccion.nombre}</option>
                    </c:forEach>
                </select>
                <button type='submit' class='btn btn-success my-2'>Eliminar</button>
            </form:form>
        </div>
    </div>
    <%--    /Formulario Borrar--%>

</main>
<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>
