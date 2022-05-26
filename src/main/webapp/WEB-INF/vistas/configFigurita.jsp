<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!-- head -->
<%@include file="head.jsp" %>
<body class="bg-dark">
<!-- header -->
<%@include file="header.jsp" %>
<!-- main -->
<main>
    <h1 class="text-center text-white">Configuracion de figurita</h1>
    <div class="container">
        <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                   method='post'
                   action='agregar-figurita'
                   modelAttribute='figurita'>
            <label for='nombre' class='text-white'>Nombre</label>
            <input class='my-2 form-control' type='text' path='nombre' id='nombre' name='nombre'>

            <label for='seleccion.id' class='text-white'>Seleccion</label>
            <select path='seleccion.id' id='seleccion.id' name='seleccion.id' class='form-control my-2'>
                <c:forEach var="seleccion" items="${selecciones}">
                    <!-- ver lo de pais.id y pais.nombre -->
                    <option value='${seleccion.id}'>${seleccion.nombre}</option>
                </c:forEach>
            </select>

            <label for="posicion.id" class='text-white'>Posicion</label>
            <select path='posicion.id' id='posicion.id' name='posicion.id' class='form-control my-2'>
                <c:forEach var="posicion" items="${posiciones}">
                    <!-- ver lo de pais.id y pais.nombre -->
                    <option value='${posicion.id}'>${posicion.descripcion}</option>
                </c:forEach>
            </select>

            <label for="rareza.id" class='text-white'>Rareza</label>
            <select path='rareza.id' id='rareza.id' name='rareza.id' class='form-control my-2'>
                <c:forEach var="rareza" items="${rarezas}">
                    <!-- ver lo de pais.id y pais.nombre -->
                    <option value='${rareza.id}'>${rareza.descripcion}</option>
                </c:forEach>
            </select>

            <label for='dorsal' class='text-white'>Dorsal</label>
            <input class='my-2 form-control' type="number"  path='dorsal' id='dorsal' name='dorsal'>

            <label for='equipo' class='text-white'>Equipo</label>
            <input class='my-2 form-control' type="text"  path='equipo' id='equipo' name='equipo'>

            <label for='anio' class='text-white'>Año</label>
            <input class='my-2 form-control' type="number"  path='anio' id='anio' name='anio'>
            <!-- falta posicion y rareza -->
            <button type='submit' class='btn btn-success my-2'>Agregar</button>
        </form:form>
    </div>


</main>
<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>
