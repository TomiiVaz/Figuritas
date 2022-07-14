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

    <!-- Carousel -->
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bstarget="#carouselExampleIndicators" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img style="height: 700px" src="img/CA2021.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img style="height: 700px" src="img/Qatar.webp" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img style="height: 700px" src="img/mundialbrasil.jpg" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    <!-- /Carousel -->



    <!-- Gana una figurita -->
    <c:if test="${id!=null}">
        <section class="mt-5">
            <div class="container d-flex justify-content-center">
                <form:form method='get'
                           action='sorteo'
                            class='d-flex justify-content-center'>
                <button type="submit" class="btn btn-danger">
                    <h3 class="text-white mr-1">Ganate una figurita</h3>
                    <img src="img/slot-machine.png">
                </button>
                </form:form>
            </div>
        </section>
    </c:if>


    <!-- Figuritas que se muestran -->
    <section>
        <div>
            <h2 class="text-white text-center mt-3">Econtra la figurita que te falta</h2>
        </div>
        <div class="container bg-dark">
            <div class="row mt-4 bg-dark gx-2">

                <!-- recorro todas las intercambiables que esten guardas en la BBDD -->
                <c:forEach var="intercambiable" items="${intercambiables}">

                    <div class="card m-3" style="width: 18rem;">
                        <img src="<c:url value="/img/${intercambiable.figurita.nombre}.jpg" />" class="card-img-top" alt="Foto de jugador">
                        <ul class="list-group list-group-flush text-center">
                            <h5 class="card-title">${intercambiable.figurita.nombre}</h5>
                            <p class="card-text">${intercambiable.figurita.rareza.descripcion}</p>
                            <li class="list-group-item">${intercambiable.figurita.equipo}</li>
                            <li class="list-group-item">${intercambiable.figurita.posicion.descripcion}</li>
                            <li class="list-group-item">${intercambiable.figurita.dorsal}</li>
                            <li class="list-group-item">${intercambiable.figurita.album.nombre}</li>
                        </ul>
                        <div class="card-body">
                            <a href="carta/${intercambiable.id}" class="card-link text-decoration-none btn btn-secondary">Ir a la carta</a>
                            <c:if test="${id!=null}">
                                <a href="intercambio/${intercambiable.id} " class="card-link text-decoration-none btn btn-primary">Intercambiar</a>
                            </c:if>
                        </div>
                    </div>

                </c:forEach>


            </div>
        </div>
    </section>
    <!-- /Figuritas que se muestran -->

</main>

<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>