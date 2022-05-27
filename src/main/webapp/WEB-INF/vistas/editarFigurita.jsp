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


    <%--    Formulario editar figurita--%>
    <div class="mt-5 container-fluid">
        <div class="card card-body bg-dark border-0 container">
            <h2 class="text-white text-center">Formulario editar Figurita</h2>
            <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                       method='post'
                       action='updateFalso-figurita'
                       modelAttribute="figurita">

                <label for='nombre' class='text-white'>Nombre</label>
                <input class='my-2 form-control' type='text' path='nombre' id='nombre' name='nombre' value="${figuritaEncontrada.nombre}"> // no me anda cambiar el nombre

                <label for='seleccion.id' class='text-white'>Seleccion</label>
                <select path='seleccion.id' id='seleccion.id' name='seleccion.id' class='form-control my-2'>
                    <c:forEach var="seleccion" items="${selecciones}">
                        <option value='Default' selected>${figuritaEncontrada.seleccion.nombre}</option>
                        <option value='${seleccion.id}'>${seleccion.nombre}</option>
                    </c:forEach>
                </select>

                <label for="posicion.id" class='text-white'>Posicion</label>
                <select path='posicion.id' id='posicion.id' name='posicion.id' class='form-control my-2'>
                    <c:forEach var="posicion" items="${posiciones}">
                        <option value='Default' selected>${figuritaEncontrada.posicion.descripcion}</option>
                        <option value='${posicion.id}'>${posicion.descripcion}</option>
                    </c:forEach>
                </select>

                <label for="rareza.id" class='text-white'>Rareza</label>
                <select path='rareza.id' id='rareza.id' name='rareza.id' class='form-control my-2'>
                    <c:forEach var="rareza" items="${rarezas}">
                        <option value='Default' selected>${figuritaEncontrada.rareza.descripcion}</option>
                        <option value='${rareza.id}'>${rareza.descripcion}</option>
                    </c:forEach>
                </select>

                <label for="album.id" class='text-white'>Album</label>
                <select path='album.id' id='album.id' name='album.id' class='form-control my-2'>
                    <c:forEach var="albunes" items="${albunes}">
                        <option value='Default' selected>${figuritaEncontrada.album.nombre}</option>
                        <option value='${albunes.id}'>${albunes.nombre}</option>
                    </c:forEach>
                </select>

                <label for='dorsal' class='text-white'>Dorsal</label>
                <input class='my-2 form-control' type="number"  path='dorsal' id='dorsal' name='dorsal' value="${figuritaEncontrada.dorsal}">

                <label for='equipo' class='text-white'>Equipo</label>
                <input class='my-2 form-control' type="text"  path='equipo' id='equipo' name='equipo' value="${figuritaEncontrada.equipo}">


                <input class='my-2 form-control' type="text"  path='id' id='id' name='id' value="${figuritaEncontrada.id}">

                <button type='submit' class='btn btn-success my-2'>Editar</button>
            </form:form>
        </div>
    </div>

</main>

<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>
