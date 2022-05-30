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
                    <img style="height: 700px" src="img/messi3.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img style="height: 700px" src="img/ronaldoPR.png" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img style="height: 700px" src="img/maradonaMano.jpg" class="d-block w-100" alt="...">
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

    <!-- Figuritas que se muestran -->
    <section>
        <div>
            <h2 class="text-white text-center mt-3">Econtra la figurita que te falta</h2>
        </div>
        <div class="container bg-dark">
            <div class="row mt-4 bg-dark gx-2">

                <!-- Este Messi esta hardcodeado -->
                <div class="col-2 my-1">
                    <div class="figuritaEncontrada border rounded border-white">
                        <a href="#" class="btn">
                            <img src="img/messi-god-no.jpg" alt="foto1" width="100% " class="rounded m-auto d-block">
                            <div class="h4 text-center my-auto text-white">Messi</div>
                        </a>
                    </div>
                </div>

                <c:forEach var="figuritas" items="${figuritas}">


                    <div class="col-2 my-1">
                        <div class="border rounded border-white">
                            <a href="#" class="btn">
                                <img src="img/${figuritas.nombre}.jpg" alt="foto1" class="rounded img-fluid m-auto d-block">
                                <div class="h4 text-center my-auto text-white">${figuritas.nombre}</div>
                                <p class="text-white">Seleccion: ${figuritas.seleccion.nombre}</p>
                            </a>
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