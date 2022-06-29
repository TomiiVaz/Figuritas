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

        <h1 class="text-white">Administrador de Figuritas</h1>
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
        <%--  Mensajes Error--%>
        <c:if test="${not empty ErrorFigurita}">
            <p class="text-danger"><span>${ErrorFigurita}</span></p>
            <br>
        </c:if>
        <c:if test="${not empty ErrorFiguritaEditarSinSeleccionar}">
            <p class="text-danger"><span>${ErrorFiguritaEditarSinSeleccionar}</span></p>
            <br>
        </c:if>
        <c:if test="${not empty ErrorNoSeleecionoUnaFiguritaAEliminar}">
            <p class="text-danger"><span>${ErrorNoSeleecionoUnaFiguritaAEliminar}</span></p>
            <br>
        </c:if>

    </div>

    <div class="d-flex flex-wrap">

        <%--    Formulario Agregar--%>
        <div class="collapse mt-5 container-fluid w-25" id="collapseAgregar">
            <div class="card card-body bg-dark border-0 container">
                <h2 class="text-white text-center">Formulario agregar Figurita</h2>
                <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                           method='post'
                           action='agregar'
                           modelAttribute="figurita">

                    <label for='nombre' class='text-white'>Nombre</label>
                    <input class='my-2 form-control' type='text' path='nombre' id='nombre' name='nombre'>

                    <%--  Mensajes Error--%>
                    <c:if test="${not empty NombreFiguritaRepetido}">
                        <p class="text-danger"><span>${NombreFiguritaRepetido}</span></p>
                        <br>
                    </c:if>
                    <c:if test="${not empty NombreFiguritaNullVacio}">
                        <p class="text-danger"><span>${NombreFiguritaNullVacio}</span></p>
                        <br>
                    </c:if>

                    <label for='seleccion.id' class='text-white'>Seleccion</label>
                    <select path='seleccion.id' id='seleccion.id' name='seleccion.id' class='form-control my-2'>
                        <option value='0' selected hidden>Seleccionar seleccion</option>
                        <c:forEach var="seleccion" items="${selecciones}">

                            <option value='${seleccion.id}'>${seleccion.nombre}</option>
                        </c:forEach>
                    </select>
                    <%--  Mensajes Error--%>
                    <c:if test="${not empty SeleccionFiguritaVacia}">
                        <p class="text-danger"><span>${SeleccionFiguritaVacia}</span></p>
                        <br>
                    </c:if>

                    <label for="posicion.id" class='text-white'>Posicion</label>
                    <select path='posicion.id' id='posicion.id' name='posicion.id' class='form-control my-2'>
                        <option value='0' selected hidden>Seleccionar posicion</option>
                        <c:forEach var="posicion" items="${posiciones}">

                            <option value='${posicion.id}'>${posicion.descripcion}</option>
                        </c:forEach>
                    </select>
                    <%--  Mensajes Error--%>
                    <c:if test="${not empty PosicionFiguritaVacia}">
                        <p class="text-danger"><span>${PosicionFiguritaVacia}</span></p>
                        <br>
                    </c:if>

                    <label for="rareza.id" class='text-white'>Rareza</label>
                    <select path='rareza.id' id='rareza.id' name='rareza.id' class='form-control my-2'>
                        <option value='0' selected hidden>Seleccionar rareza</option>
                        <c:forEach var="rareza" items="${rarezas}">

                            <option value='${rareza.id}'>${rareza.descripcion}</option>
                        </c:forEach>
                    </select>
                    <%--  Mensajes Error--%>
                    <c:if test="${not empty RarezaFiguritaVacia}">
                        <p class="text-danger"><span>${RarezaFiguritaVacia}</span></p>
                        <br>
                    </c:if>

                    <label for="album.id" class='text-white'>Album</label>
                    <select path='album.id' id='album.id' name='album.id' class='form-control my-2'>
                        <option value='0' selected hidden>Seleccionar album</option>
                        <c:forEach var="albunes" items="${albunes}">

                            <option value='${albunes.id}'>${albunes.nombre}</option>
                        </c:forEach>
                    </select>
                    <%--  Mensajes Error--%>
                    <c:if test="${not empty AlbumFiguritaVacio}">
                        <p class="text-danger"><span>${AlbumFiguritaVacio}</span></p>
                        <br>
                    </c:if>


                    <label for='dorsal' class='text-white'>Dorsal</label>
                    <input class='my-2 form-control' type="number" path='dorsal' id='dorsal' name='dorsal' value='0'>
                    <%--  Mensajes Error--%>
                    <c:if test="${not empty DorsalFiguritaVacio}">
                        <p class="text-danger"><span>${DorsalFiguritaVacio}</span></p>
                        <br>
                    </c:if>

                    <label for='equipo' class='text-white'>Equipo</label>
                    <input class='my-2 form-control' type="text"  path='equipo' id='equipo' name='equipo'>
                    <%--  Mensajes Error--%>
                    <c:if test="${not empty EquipoFiguritaVacio}">
                        <p class="text-danger"><span>${EquipoFiguritaVacio}</span></p>
                        <br>
                    </c:if>


                    <%--  Boton--%>
                    <button type='submit' class='btn btn-success my-2'>Agregar</button>
                </form:form>
            </div>
        </div>
        <%--    /Formulario Agregar--%>

        <%--    Formulario Editar--%>
        <div class="collapse mt-5 container-fluid w-25" id="collapseEditar">
            <div class="card card-body bg-dark border-0 container">
                <h2 class="text-white text-center">Formulario editar figurita</h2>
                <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                           method='post'
                           action='editar'
                           modelAttribute="figurita">

                    <label for="figuritaId" class='text-white'>Figurita</label>
                    <select id='figuritaId' name='figuritaId' class='form-control my-2'>
                        <option value='0' selected hidden>Seleccionar una figurita</option>

                        <c:forEach var="figurita" items="${figuritas}">
                            <option value='${figurita.id}'>${figurita.nombre}</option>
                        </c:forEach>
                    </select>
                    <c:if test="${not empty ErrorFiguritaSinSeleccionar}">
                        <p class="text-danger"><span>${ErrorFiguritaSinSeleccionar}</span></p>
                        <br>
                    </c:if>

                    <button type='submit' class='btn btn-success my-2'>Editar</button>

                </form:form>
            </div>
        </div>
        <%--    /Formulario Editar--%>

        <%--    Formulario Borrar--%>
        <div class="collapse mt-5 container-fluid w-25" id="collapseEliminar">
            <div class="card card-body bg-dark border-0 container">
                <h2 class="text-white text-center">Formulario eliminar figurita</h2>
                <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                           method='post'
                           action='eliminar'
                           modelAttribute="figurita">

                    <label for="figuritaId" class='text-white'>Figurita</label>
                    <select id='figuritaId' name='figuritaId' class='form-control my-2'>
                        <option value='0' selected hidden>Seleccionar una figurita a borrar</option>

                        <c:forEach var="figurita" items="${figuritas}">
                            <option value='${figurita.id}'>${figurita.nombre}</option>
                        </c:forEach>
                    </select>
                    <c:if test="${not empty ErrorFiguritaAElminarSinSeleccionar}">
                        <p class="text-danger"><span>${ErrorFiguritaAElminarSinSeleccionar}</span></p>
                        <br>
                    </c:if>

                    <button type='submit' class='btn btn-success my-2'>Eliminar</button>
                </form:form>
            </div>
        </div>
        <%--    /Formulario Borrar--%>

    </div>
</main>


<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>
