<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp" %>
<body class="bg-dark">

<%@include file="header.jsp" %>

<main class="container text-center">
    <p class="h1 text-light">Intercambio</p>

    <div class="container row d-flex justify-content-between">
        <!-- TENGO/PEDIDO -->
        <div class="col-auto">
            <p class="h3 text-light">Figurita Pedida</p>
            <div class="card m-3" style="width: 18rem;">
                <img src="../../img/${registroIntercambio.registroPide.figurita.nombre}.jpg" class="card-img-top" alt="Foto de jugador">
                <h5 class="card-title">${registroIntercambio.registroPide.figurita.nombre}</h5>
                <p class="card-text">${registroIntercambio.registroPide.figurita.rareza.descripcion}</p>

                <ul class="list-group list-group-flush text-center">
                    <li class="list-group-item">${registroIntercambio.registroPide.figurita.equipo}</li>
                    <li class="list-group-item">${registroIntercambio.registroPide.figurita.posicion.descripcion}</li>
                    <li class="list-group-item">${registroIntercambio.registroPide.figurita.dorsal}</li>
                </ul>
            </div>
        </div>

        <!-- ME OFRECEN-->
        <div class="col-auto">
            <p class="h3 text-light">Figurita Ofrecida</p>
            <div class="card m-3" style="width: 18rem;">
                <img src="../../img/${registroIntercambio.registroDecide.figurita.nombre}.jpg" class="card-img-top" alt="Foto de jugador">
                <h5 class="card-title">${registroIntercambio.registroDecide.figurita.nombre}</h5>
                <p class="card-text">${registroIntercambio.registroDecide.figurita.rareza.descripcion}</p>

                <ul class="list-group list-group-flush text-center">
                    <li class="list-group-item">${registroIntercambio.registroDecide.figurita.equipo}</li>
                    <li class="list-group-item">${registroIntercambio.registroDecide.figurita.posicion.descripcion}</li>
                    <li class="list-group-item">${registroIntercambio.registroDecide.figurita.dorsal}</li>
                </ul>
            </div>

        </div>

    </div>

    <!-- Botones -->

    <div class="mt-2 mb-2 p-2 rounded">
        <a href="/figus/perfil/aceptar/${registroIntercambio.id}" class="text-decoration-none">
            <button type='button' class='btn btn-success my-2 mx-2'>Aceptar</button>
        </a>
        <a href="/figus/perfil/rechazar/${registroIntercambio.id}" class="text-decoration-none">
            <button type='button' class='btn btn-danger my-2 mx-2'>Rechazar</button>
        </a>
    </div>


</main>
<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>

