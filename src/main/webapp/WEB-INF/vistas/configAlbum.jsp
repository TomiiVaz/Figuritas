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
        <h1 class="text-white">Administrador de álbum</h1>
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
                       action='agregar-album'
                       modelAttribute="album">
                <input class='my-2 form-control' type='text' path="nombre" name='nombre' id='nombre'
                       placeholder='Ingrese el nombre del álbum'>
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
                       action='ver-albunes'
                       modelAttribute="album">
                <select path='album.id' id='album.id' name='album.id' class='form-control my-2'>
                    <c:forEach var="album" items="${albunes}">
                        <option value='Default' selected hidden>Seleccionar un álbum</option>
                        <option value='${album.id}'>${album.nombre}</option>
                    </c:forEach>
                </select>
                <input class='my-2 form-control' type='text' path="nombreNuevoAlbum" name='nombreNuevoAlbum'
                       id='nombreNuevoAlbum'
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
                       action=''
                       modelAttribute="">
                <select name='tipoNuevo' class='form-control my-2'>
                    <option value='Aire'>Mundial Qatar 2022</option>
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
