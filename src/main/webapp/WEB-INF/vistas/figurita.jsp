<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!-- head -->
<%@include file="head.jsp" %>

<body class="bg-dark text-white">
<%@include file="header.jsp" %>
<main class=".container-fluid text-center">

    <!-- Parte Arriba -->
    <div class="row align-items-center justify-content-center m-2 mb-5 mb-4">
        <div class="container-fluid text-center mt-5">
            <a href="home" class="text-decoration-none">
                <button type='button' class='btn btn-warning my-2'>Volver</button>
            </a>
        </div>
        <div class="col">
            <h1 class="mb-4 mt-2">${figurita.nombre}</h1>
            <div class="m-0">
                <img src="img/${figurita.nombre}.jpg" alt="Foto Perfil" class="img-thumbnail img-fluid m-0">
            </div>

            <!-- Muestro si esta logueado -->
                <c:if test="${rol.equals('ADM')}">
                <a href="configuracion-figurita">
                    <button class="btn btn-primary mb-5 mt-3">Configuracion</button>
                </a>
                </c:if>

        </div>
        <%--        Datos--%>
        <div class="col m-2 d-flex justify-content-start">
            <div class="text-start">
                <h4><span class="text-secondary">Jugador:</span> ${figurita.nombre}</h4>
                <h4><span class="text-secondary">Equipo:</span> ${figurita.equipo}</h4>
                <h4><span class="text-secondary">Seleccion:</span> ${figurita.seleccion.nombre}</h4>
                <h4><span class="text-secondary">Posicion:</span> ${figurita.posicion.descripcion}</h4>
                <h4><span class="text-secondary">Dorsal:</span> ${figurita.dorsal}</h4>
            </div>
            <%--        /Datos--%>
        </div>
        <!-- /Parte Arriba -->

        <%--        Parte comentarios--%>
        <h2 class="mb-5">Comentarios</h2>

        <div class="container-fluid text-start">
            <div class="container d-flex flex-row align-baseline justify-content-start flex-wrap">
                <c:forEach var="comentarios" items="${comentarios}">
                    <c:if test="${comentarios.figurita.id == figurita.id}">
                <div class="col-2 text-center">
                    <img src="img/${comentarios.usuario.nombre}.jpg" alt="Foto Perfil" class="rounded-circle" width="50%">
                    <h6 class="m-1">${comentarios.usuario.nombre}</h6>
                </div>
                <div class="col-10 text-start">
                    <p class="text-white">${comentarios.descripcion}</p>
                </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>

        <%--    Solo los usuarios logueados pueden dejarle comentarios a las figuritas--%>
        <c:if test="${id!=null}">
        <div class="container w-75">
            <h4 class="mb-4">Deja tu comentario aqui:</h4>

            <form:form class='text-center d-flex flex-column px-5 py-2 bg-dark border-0'
                       method='post'
                       action='agregar-comentario'
                       modelAttribute="comentario">
                <input class='my-2 form-control' type='text' path='descripcion' id='descripcion' name='descripcion' required>

                <%--    input invisible paso el id de la figurita para darselo al comentario--%>
                <input class='d-none' type="text" id='figurita.id' name='figurita.id' value="${figurita.id}">

                <%--    input invisible paso el id de la usuario para darselo al comentario--%>
                <input class='d-none' type="text" id='usuario.id' name='usuario.id' value="${id}">

                <button type='submit' class='btn btn-success'>Enviar</button>
            </form:form>
            </c:if>

        </div>
        <%--        Parte comentarios--%>

</main>

<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>
