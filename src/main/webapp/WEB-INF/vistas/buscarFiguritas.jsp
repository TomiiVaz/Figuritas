<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 28/4/2022
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-- head -->
<%@include file="head.jsp" %>


<body class="bg-dark">
<%@include file="header.jsp" %>

<main>
    <!--opciones de filtrado de cartas (por selección, nombre jugador, posición)-->
    <div class="container mt-3">
        <h4 class="text-white">Filtros</h4>
        <p>${posicionElegida}</p>
        <form action="buscarfiguritas" method="get">
            <div class="row d-flex justify-content-center">

                <div class="formSearchContainer col-12 mb-2">
                    <input type="text" id="nombreIngresado" name="nombreIngresado" placeholder="Buscar por nombre"
                           class="form-control">
                </div>

                <div class="col-6 mb-2">
                    <select name="seleccionIngresada" id="seleccionIngresada" class="form-select">
                        <option value="0" >--Elige una selección--</option>
                        <c:forEach var="item" items="${seleccionesParaFormulario}">
                            <option value="${item.id}">${item.nombre}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="col-6 mb-2">
                    <select name="posicionIngresada" id="posicionIngresada" class="form-select">
                        <option value= "0" >--Elije una posición de jugador--</option>

                        <c:forEach var="item" items="${posicionesParaFormulario}">
                            <option value="${item.id}">${item.descripcion}</option>
                        </c:forEach>

                    </select>
                </div>
                <button type="submit" class="btn btn-primary col-3 mb-2 ">Buscar</button>

            </div>
        </form>
        <div>
            <c:if test="${not empty nombreIntroducido}">
                <span class="bg-warning text-center p-2 rounded ">${nombreIntroducido}</span>
            </c:if>
            <c:if test="${not empty posicionElegida}">
                <span class="bg-warning text-center p-2 rounded ">${posicionElegida.descripcion}</span>
            </c:if>
            <c:if test="${not empty seleccionElegida}">
                <span class="bg-warning text-center p-2 rounded ">${seleccionElegida.nombre}</span>
            </c:if>
        </div>

    </div>

    <!--listado de figuritas-->
    <div class="container bg-dark">
        <div class="row mt-4 bg-dark gx-2">
            <!-- preguntar o ver que onda porque del home se llama post y desde aca como get -->
            <c:forEach var="pegada" items="${regsEncontradosEnLaBusqueda}">

                <div class="card m-3" style="width: 18rem;">
                    <img src="img/${pegada.figurita.nombre}.jpg" class="card-img-top" alt="Foto de jugador">
                    <ul class="list-group list-group-flush text-center">
                        <h5 class="card-title">${pegada.figurita.nombre}</h5>
                        <p class="card-text">${pegada.figurita.rareza.descripcion}</p>
                        <li class="list-group-item">${pegada.figurita.equipo}</li>
                        <li class="list-group-item">${pegada.figurita.posicion.descripcion}</li>
                        <li class="list-group-item">${pegada.figurita.dorsal}</li>
                        <li class="list-group-item">${pegada.figurita.album.nombre}</li>
                    </ul>
                    <div class="card-body">
                        <a href="carta/${pegada.id}" class="card-link text-decoration-none btn btn-secondary">Ir a la carta</a>
                        <c:if test="${id!=null}">
                            <a href="intercambio/${pegada.id} " class="card-link text-decoration-none btn btn-primary">Intercambiar</a>
                        </c:if>
                    </div>
                </div>

            </c:forEach>
            <c:if test="${not empty mensajeError}">
                <p class="text-danger text-center"><span>${mensajeError}</span></p>
                <br>
            </c:if>

        </div>
    </div>
</main>

<!-- Footer -->
<%@include file="footer.jsp" %>
</body>

</html>
