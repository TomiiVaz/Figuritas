<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp" %>
<body class="bg-dark">

<%@include file="header.jsp" %>

<main class=".container-fluid text-center">
    <!-- Parte Arriba -->
    <div class="row align-items-center justify-content-center m-2">
        <div class="col">
            <h1 class="mb-4 mt-2 text-white">${usuario.nombre}</h1>
            <div class="m-0">
                <img src="img/${usuario.nombre}.jpg" alt="Foto Perfil" class="img-thumbnail img-fluid m-0">
            </div>
            <button class="btn btn-primary mb-5 mt-3">Editar</button>
        </div>
        <%--        Datos--%>
        <div class="col m-2 d-flex align-items-center justify-content-around">
            <div class="text-start">
                <h4 class="text-white">Nombre de Usuario</h4>
                <h4 class="text-white">Equipo:</h4>
                <h4 class="text-white">Seleccion:</h4>
                <h4 class="text-white">Mail:</h4>
            </div>
            <div class="d-flex flex-column text-start">
                <h4 class="text-white">${usuario.nombre}</h4>
                <h4 class="text-white">${usuario.equipo}</h4>
                <h4 class="text-white">${usuario.seleccion.nombre}</h4>
                <h4 class="text-white">${usuario.email}</h4>
            </div>
            <%--       /Datos--%>
        </div>
        <!-- /Parte Arriba -->

        <!-- Parte Album -->
        <div class="container-fluid">
            <h2 class="mb-3 text-white">Mi Album</h2>
            <div class="text-end container">
                <%--                Agregar figurita form--%>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Agregar Figurita
                </button>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content bg-dark">
                            <div class="modal-header">
                                <h5 class="modal-title text-white" id="exampleModalLabel">Agregar Figurita</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body text-center">
                                <form class="d-flex flex-column mb-2"
                                      method="post"
                                      action="pegar">

                                    <label for="albumIdd">Seleccione el album</label>
                                    <select path='albumIdd' id='albumIdd' name='albumIdd' class='form-control my-2'>
                                        <c:forEach var="album" items="${albunes}">
                                            <option value='${album.id}'>${album.nombre}</option>
                                        </c:forEach>
                                    </select>

                                    <label for="id" class="mb-1 text-white">Ingresar código</label>
                                    <input type="text" path="id" name="id" id="id" class="form-control mt-2">
                                    <button type="submit" class="btn btn-primary mt-3">Save changes</button>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <%--                    El boton esta fuera del form, por lo cual no se donde me lo envia xd--%>
                <%--                /Agregar figurita form--%>

                <%--                    Albunes--%>
                <div class="mb-1 mt-2">
                    <select path='albumId' id='albumId' name='albumId' class='form-control my-2'>
                        <c:forEach var="album" items="${albunes}">
                            <option value='Default' selected hidden>Seleccionar un álbum</option>
                            <option value='${album.id}'>${album.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <%--                    Albunes--%>
                <%--Selecciones--%>
                <div class="mb-5 mt-2">
                    <select id='seleccionId' name='seleccionId' class='form-control my-2'>
                        <c:forEach var="seleccion" items="${selecciones}">
                            <option value='Default' selected hidden>Seleccionar una selección</option>
                            <option value='${seleccion.id}'>${seleccion.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <%--Selecciones--%>
            </div>
            <div class="d-flex flex-wrap justify-content-center">
                <div class="card m-3" style="width: 18rem;">
                    <img src="img/messi1.jpg" class="card-img-top" alt="Foto de jugador">
                    <div class="card-body">
                        <h5 class="card-title">Nombre Jugador</h5>
                        <p class="card-text">Tipo de Carta</p>
                    </div>
                    <ul class="list-group list-group-flush text-start">
                        <li class="list-group-item">Equipo: PSG</li>
                        <li class="list-group-item">Posicion: Delantero</li>
                        <li class="list-group-item">Pierna Hábil: Zurda</li>
                        <li class="list-group-item">Dorsal: 30</li>
                    </ul>
                    <div class="card-body">
                        <a href="carta" class="card-link">Ir a la carta</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- /Parte Album -->
</main>
<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>
