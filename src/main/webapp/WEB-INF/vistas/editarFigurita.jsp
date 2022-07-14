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
        <a href="/figus/configuracion/figurita/" class="text-decoration-none">
            <button type='button' class='btn btn-warning my-2'>Volver</button>
        </a>
    </div>

    <%--    Formulario editar figurita--%>
    <div class="mt-5 container-fluid">
        <div class="card card-body bg-dark border-0 container">
            <h2 class="text-white text-center">Formulario editar Figurita</h2>
            <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                       method='post'
                       action='editar/enviar'
                       modelAttribute="figurita">
                <div class="w-100 d-flex justify-content-center">
                    <img src="<c:url value="/img/${figuritaEncontrada.nombre}.jpg" />" class="w-25" alt="Foto de jugador">
                </div>
                <label for='nombre' class='text-white'>Nombre</label>
                <input class='my-2 form-control' type='text' path='nombre' id='nombre' name='nombre' value="${figuritaEncontrada.nombre}">

                <label for='seleccion.id' class='text-white'>Seleccion</label>
                <select path='seleccion.id' id='seleccion.id' name='seleccion.id' class='form-control my-2'>
                    <option value=${figuritaEncontrada.seleccion.id} selected>${figuritaEncontrada.seleccion.nombre}</option>
                    <c:forEach var="seleccion" items="${selecciones}">

                        <%--  if negado --%>
                        <c:if test="${!figuritaEncontrada.seleccion.nombre.equals(seleccion.nombre)}">
                            <option value='${seleccion.id}'>${seleccion.nombre}</option>
                        </c:if>

                    </c:forEach>
                </select>

                <label for="posicion.id" class='text-white'>Posicion</label>
                <select path='posicion.id' id='posicion.id' name='posicion.id' class='form-control my-2'>
                    <option value=${figuritaEncontrada.posicion.id} selected>${figuritaEncontrada.posicion.descripcion}</option>
                    <c:forEach var="posicion" items="${posiciones}">

                        <%--  if negado --%>
                            <c:if test="${!figuritaEncontrada.posicion.descripcion.equals(posicion.descripcion)}">
                                <option value='${posicion.id}'>${posicion.descripcion}</option>
                            </c:if>


                    </c:forEach>
                </select>

                <label for="rareza.id" class='text-white'>Rareza</label>
                <select path='rareza.id' id='rareza.id' name='rareza.id' class='form-control my-2'>
                    <option value=${figuritaEncontrada.rareza.id} selected>${figuritaEncontrada.rareza.descripcion}</option>
                    <c:forEach var="rareza" items="${rarezas}">

                        <%--    Aca lo que quise probar es hacer un if else en vez de un if negado como hago arriba--%>
                        <c:choose>
                            <c:when test="${figuritaEncontrada.rareza.descripcion.equals(rareza.descripcion)}"></c:when>
                            <c:otherwise>
                                <option value='${rareza.id}'>${rareza.descripcion}</option>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </select>

                <label for="album.id" class='text-white'>Album</label>
                <select path='album.id' id='album.id' name='album.id' class='form-control my-2'>
                    <option value=${figuritaEncontrada.album.id} selected>${figuritaEncontrada.album.nombre}</option>
                    <c:forEach var="albunes" items="${albunes}">
                        <%--  if negado --%>
                        <c:if test="${!figuritaEncontrada.album.nombre.equals(albunes.nombre)}">
                            <option value='${albunes.id}'>${albunes.nombre}</option>
                        </c:if>

                    </c:forEach>
                </select>

                <label for='dorsal' class='text-white'>Dorsal</label>
                <input class='my-2 form-control' type="number"  path='dorsal' id='dorsal' name='dorsal' value="${figuritaEncontrada.dorsal}">

                <label for='equipo' class='text-white'>Equipo</label>
                <input class='my-2 form-control' type="text"  path='equipo' id='equipo' name='equipo' value="${figuritaEncontrada.equipo}">

                <%--    input invisible paso el id de la figurita para borrarla--%>
                <input class='my-2 form-control invisible' type="text"  path='id' id='id' name='id' value="${figuritaEncontrada.id}">

                <button type='submit' class='btn btn-success my-2'>Editar</button>
            </form:form>
        </div>
    </div>

</main>

<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>
