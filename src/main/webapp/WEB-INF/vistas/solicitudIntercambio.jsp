<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- head -->
<%@include file="head.jsp" %>

<body class="bg-dark">

<!-- header -->
<%@include file="header.jsp" %>
<!-- main -->
<main>
    <h1 class="text-center text-white mt-2">¡Intercambia tu figurita!</h1>
    <div class="container bg-dark d-flex">
        <div class="row mt-4 bg-dark gx-2">
                <div class="card m-3" style="width: 18rem;">
                    <img src="<c:url value="/img/${rpsolicitado.figurita.nombre}.jpg" />" class="card-img-top" alt="Foto de jugador">
                    <ul class="list-group list-group-flush text-center">
                        <h5 class="card-title">${rpsolicitado.figurita.nombre}</h5>
                        <p class="card-text">${rpsolicitado.figurita.rareza.descripcion}</p>
                        <li class="list-group-item">${rpsolicitado.figurita.equipo}</li>
                        <li class="list-group-item">${rpsolicitado.figurita.posicion.descripcion}</li>
                        <li class="list-group-item">${rpsolicitado.figurita.dorsal}</li>
                        <li class="list-group-item">${rpsolicitado.figurita.album.nombre}</li>
                    </ul>
<%--                    <div class="card-body">--%>
<%--                        <a href="#" class="card-link text-decoration-none">Ir a la carta</a>--%>
<%--                    </div>--%>
                </div>
        </div>
        <form method="get" action="solicitud">
            <div class="row mt-4 bg-dark gx-2">
                <h4 class="text-center text-white mt-2">Selecciona la figurita que ofreces para el intercambio</h4>
                <select path='idPide' id='idPide' name='idPide'>
                    <option value="0" selected hidden>Selecciona una figurita</option>
                    <c:forEach var="figu" items="${pegadasofrecidas}">
                        <option value="${figu.id}">${figu.figurita.nombre} de ${figu.album.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="row mt-4 bg-dark gx-2">
                <button type="submit" class="btn btn-warning btn-block m-2">Solicitar intercambio</button>
            </div>
        </form>
    </div>


</main>

<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>
