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
        <p>${seleccionElegida}</p>
        <form action="buscarfiguritas" method="get">
            <div class="row d-flex justify-content-center">

                <div class="formSearchContainer col-12 mb-2">
                    <input type="text" id="busq" name="busq" placeholder="Buscar por nombre"
                           class="form-control">
                </div>

                <div class="col-6 mb-2">
                    <select name="selSeleccion" id="selSeleccion" class="form-select">
                        <option value="0" >--Elige una selección--</option>
                        <c:forEach var="item" items="${todasSelecciones}">
                            <option value="${item.id}">${item.nombre}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="col-6 mb-2">
                    <select name="selPosicionJugador" id="selPosicionJugador" class="form-select">
                        <option value= "0" >--Elije una posición de jugador--</option>

                        <c:forEach var="item" items="${todasPosiciones}">
                            <option value="${item.id}">${item.descripcion}</option>
                        </c:forEach>

                    </select>
                </div>
                <button type="submit" class="btn btn-primary col-3 mb-2 ">Buscar</button>

            </div>
        </form>
    </div>

    <!--listado de figuritas-->
    <div class="container bg-dark">
        <div class="row mt-4 bg-dark gx-2">

            <%-- Plantilla --%>
            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>



            <c:forEach var="item" items="${figEncontradas}">
                <div class="col-2 my-1">
                    <div class="figuritaEncontrada border rounded border-white">
                        <a href="carta" class="btn">
                            <img src="img/${item.nombre}.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                            <div class="h4 text-center my-auto text-white">${item.nombre}</div>
                        </a>
                    </div>
                </div>

            </c:forEach>

        </div>
    </div>
</main>

<!-- Footer -->
<%@include file="footer.jsp" %>
</body>

</html>
