<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-- head -->
<%@include file="head.jsp" %>

<body class="bg-dark text-white">
<%@include file="header.jsp" %>
<main class=".container-fluid text-center">

    <!-- Parte Arriba -->
    <div class="row align-items-center justify-content-center m-2 mb-5 mb-4">
        <div class="col">
            <h1 class="mb-4 mt-2">Lionel Messi</h1>
            <div class="m-0">
                <img src="img/messi1.jpg" alt="Foto Perfil" class="img-thumbnail img-fluid m-0">
            </div>
            <button class="btn btn-primary mb-5 mt-3">Editar</button>
        </div>
        <%--        Datos--%>
        <div class="col m-2 d-flex align-items-center justify-content-around">
            <div class="text-start">
                <h4>Jugador:</h4>
                <h4>Equipo:</h4>
                <h4>Seleccion:</h4>
                <h4>Posicion:</h4>
                <h4>Dorsal:</h4>
            </div>
            <div class="d-flex flex-column text-start">
                <h4>Lionel Andres Messi</h4>
                <h4>Paris Saint German</h4>
                <h4>Argentina</h4>
                <h4>Delantero</h4>
                <h4>30</h4>
            </div>
            <%--        /Datos--%>
        </div>
        <!-- /Parte Arriba -->

        <%--        Parte comentarios--%>
        <h2 class="mb-5">Comentarios</h2>

        <div class="container-fluid text-start">
            <div class="container d-flex flex-row align-baseline justify-content-start">
                <div class="col-2 text-center">
                    <img src="img/messi1.jpg" alt="Foto Perfil" class="rounded-circle" width="50%">
                    <h6 class="m-1">Tomas</h6>
                </div>
                <div class="col-10 text-start">
                    <p class="m-1 ms-s">Muy buena la quiero!</p>
                </div>
            </div>
        </div>
        <div class="container w-75">
            <h4 class="mb-4">Deja tu comentario aqui:</h4>
            <form method="get"
                  action="#">
            <textarea class="form-control" id="floatingTextarea2"
                      style="height: 100px"></textarea>
                <button class="btn btn-primary mb-5 mt-3">Enviar</button>
            </form>
        </div>
        <%--        Parte comentarios--%>

</main>

<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>
