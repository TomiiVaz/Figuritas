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

        <div class="container-fluid d-flex flex-row justify-content-start align-middle border border-primary p-2 m-5">
            <a href="home" style="width: 10%"><img src="img/messi1.jpg" class="img-fluid rounded-circle" style="width: 40%" ></a>
            <div><p>Muy buena! La quiero</p></div>
        </div>
        <div class="container w-75">
            <div class="form-floating">
                <h4 class="mb-4">Deja tu comentario aqui:</h4>
                <textarea class="form-control bg-secondary" id="floatingTextarea2"
                          style="height: 100px"></textarea>
            </div>
        </div>
        <%--        Parte comentarios--%>

</main>

<!-- Footer -->
<%@include file="footer.jsp" %>

<%--Script Boostrap--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<%--/Script Boostrap--%>
</body>
</html>
