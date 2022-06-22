<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp" %>
<body class="bg-dark">

<%@include file="header.jsp" %>

<main class=".container-fluid text-center">
    <!-- Parte Arriba -->
    <div class="row align-items-center justify-content-center m-2">
        <div class="container-fluid text-center mt-5">
            <a href="home" class="text-decoration-none">
                <button type='button' class='btn btn-warning my-2'>Volver</button>
            </a>
        </div>
        <%--        Boton de mis intercambios--%>
        <div>
            <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample"
                 aria-labelledby="offcanvasExampleLabel">
                <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="offcanvasExampleLabel">Intercambios</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                    <div class="card">
                        <div class="card-header">
                            <ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
                                <li class="nav-item" role="presentation">
                                    <a class="nav-link active" id="home-tab" data-bs-toggle="tab" href="#home"
                                       role="tab" aria-controls="home" aria-selected="true">Pedí</a>
                                </li>
                                <li class="nav-item" role="presentation">
                                    <a class="nav-link" id="profile-tab" data-bs-toggle="tab" href="#profile" role="tab"
                                       aria-controls="profile" aria-selected="false">Me pidieron</a>
                                </li>
                            </ul>
                        </div>
                        <div class="card-body">
                            <div class="tab-content" id="myTabContent">
                                <div class="tab-pane fade show active" id="home" role="tabpanel"
                                     aria-labelledby="home-tab">
                                    <c:forEach var="item" items="${pedi}">
                                        <div class="mt-2 mb-2 p-2 bg-info bg-opacity-25 rounded">
                                            <p>Ofreci: ${item.registroPide.figurita.nombre}</p>
                                            <p>Pedi: ${item.registroDecide.figurita.nombre}</p>
                                            <p>Album: ${item.registroDecide.figurita.album.nombre}</p>
                                            <p>Estado: ${item.estado.descripcion}</p>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                    <c:forEach var="registro" items="${pidieron}">
                                        <c:if test="${registro.estado.descripcion.equals('Espera')}">
                                            <div class="mt-2 mb-2 p-2 bg-info bg-opacity-25 rounded">
                                                <p>Ofrecido: ${registro.registroPide.figurita.nombre}</p>
                                                <p>Pedido: ${registro.registroDecide.figurita.nombre}</p>
                                                <p>Album: ${registro.registroDecide.figurita.album.nombre}</p>
                                                <a href="#" class="text-decoration-none">
                                                    <button type='button' class='btn btn-success my-2'>Aceptar</button>
                                                </a>
                                                <a href="#" class="text-decoration-none">
                                                    <button type='button' class='btn btn-danger my-2'>Rechazar</button>
                                                </a>
                                            </div>
                                        </c:if>

                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--                    <div class="dropdown mt-3">--%>
                    <%--                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"--%>
                    <%--                                data-bs-toggle="dropdown">--%>
                    <%--                            Dropdown button--%>
                    <%--                        </button>--%>
                    <%--                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">--%>
                    <%--                            <li><a class="dropdown-item" href="#">Action</a></li>--%>
                    <%--                            <li><a class="dropdown-item" href="#">Another action</a></li>--%>
                    <%--                            <li><a class="dropdown-item" href="#">Something else here</a></li>--%>
                    <%--                        </ul>--%>
                    <%--                    </div>--%>
                </div>
            </div>
        </div>
        <%--       /Boton de mis intercambios--%>
        <div class="col mt-5">
            <h1 class="mb-4 mt-2 text-white">${usuario.nombre}</h1>
            <div class="m-0">
                <img src="img/${usuario.nombre}.jpg" alt="Foto Perfil" class="img-thumbnail img-fluid m-0">
            </div>
            <button class="btn btn-primary mt-4" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseEditar"
                    aria-expanded="false" aria-controls="collapseEditar">
                Editar
            </button>
        </div>
        <%--        Datos--%>
        <div class="col mt-5 m-2 d-flex align-items-center justify-content-around">
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

        <%--        Parte editar--%>
        <div class="collapse mt-5 mb-5 container-fluid" id="collapseEditar">
            <div class="card card-body bg-dark border-0 container">
                <h2 class="text-white text-center">Formulario editar</h2>
                <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                           method='post'
                           action='editar'
                           modelAttribute="usuario">
                    <input class='form-control my-2' type='text' name='nombre' id='nombre'
                           placeholder='Nombre' value="${usuario.nombre}">
                    <input class='form-control my-2' type='text' name='email' id='email'
                           placeholder='Email' value="${usuario.email}">
                    <input class='form-control my-2' type='text' name='equipo' id='equipo'
                           placeholder='Equipo' value="${usuario.equipo}">
                    <select id='seleccion.id' name='seleccion.id' class='form-control my-2'>
                        <c:forEach var="seleccion" items="${selecciones}">
                            <option value='${usuario.seleccion.id}' selected hidden>${usuario.seleccion.nombre}</option>
                            <option value='${seleccion.id}'>${seleccion.nombre}</option>
                        </c:forEach>
                    </select>
                    <button type='submit' class='btn btn-success mt-1'>Editar</button>
                </form:form>
            </div>
        </div>
        <%--        /Parte editar--%>

        <!-- Parte Album -->
        <div class="container-fluid mt-5">
            <button class="btn btn-success mb-4 mt-5" type="button" data-bs-toggle="offcanvas"
                    data-bs-target="#offcanvasExample"
                    aria-controls="offcanvasExample">
                Mis intercambios
            </button>
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
                                    <button type="submit" class="btn btn-primary mt-3">Pegar</button>
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
                <div class="mb-3">
                    <c:if test="${not empty errorCodigo}">
                        <p class="text-danger"><span>${errorCodigo}</span></p>
                        <br>
                    </c:if>
                    <c:if test="${not empty errorCoincidencia}">
                        <p class="text-danger"><span>${errorCoincidencia}</span></p>
                        <br>
                    </c:if>
                </div>
                <form action="filtrar" method="get">
                    <%--                    Albunes--%>

                    <div class="mb-1 mt-2">
                        <select path='albumId' id='albumId' name='albumId' class='form-control my-2'>
                            <c:forEach var="album" items="${albunes}">
                                <option value='0' selected hidden>Seleccionar un álbum</option>
                                <option value='${album.id}'>${album.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <%--                    Albunes--%>
                    <%--Selecciones--%>
                    <div class="mb-5 mt-2">
                        <select id='seleccionId' name='seleccionId' class='form-control my-2'>
                            <c:forEach var="seleccion" items="${selecciones}">
                                <option value='0' selected hidden>Seleccionar una selección</option>
                                <option value='${seleccion.id}'>${seleccion.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <%--Selecciones--%>
                    <button type="submit" class="btn btn-primary">
                        Buscar
                    </button>
                </form>

            </div>
            <div class="d-flex flex-wrap justify-content-center">
                <c:forEach var="pegada" items="${pegadas}">
                    <div class="card m-3" style="width: 18rem;">
                        <img src="<c:url value="/img/${pegada.figurita.nombre}.jpg" />" class="card-img-top" alt="Foto de jugador">
                        <ul class="list-group list-group-flush text-center">
                            <h5 class="card-title">${pegada.figurita.nombre}</h5>
                            <p class="card-text">${pegada.figurita.rareza.descripcion}</p>
                            <li class="list-group-item">${pegada.figurita.equipo}</li>
                            <li class="list-group-item">${pegada.figurita.posicion.descripcion}</li>
                            <li class="list-group-item">${pegada.figurita.dorsal}</li>
                        </ul>
                        <div class="card-body">
                            <a href="#" class="card-link text-decoration-none me-3">Ir a la carta</a>
                            <c:choose>
                                <c:when test="${pegada.intercambiable!=true}">
                                    <a href="publicar/${pegada.id}" class="card-link text-success text-decoration-none">Publicar</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="sacar/${pegada.id}" class="card-link text-success text-decoration-none">Sacar</a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!-- /Parte Album -->
</main>
<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>
