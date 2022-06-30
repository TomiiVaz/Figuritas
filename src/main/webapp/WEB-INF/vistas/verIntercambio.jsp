<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp" %>
<body class="bg-dark">

<%@include file="header.jsp" %>

<main class=".container-fluid text-center">
    <h1>INTERCAMBIO</h1>
    <!-- TENGO/PEDIDO -->
    <div>
        <div class="card m-3" style="width: 18rem;">
            <img src="img/${registroIntercambio.registroPide.figurita.nombre}.jpg" class="card-img-top" alt="Foto de jugador">
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
</main>
<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>

