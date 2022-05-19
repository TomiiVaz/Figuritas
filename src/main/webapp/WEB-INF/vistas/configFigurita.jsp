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
            <input class='my-2 form-control' type='text' path='nombre' id='nombre' name='nombre' placeholder="Ingresa el nombre">

            <!-- ver en el path si es pais o pais.id -->
            <select path='seleccion.id' id='seleccion.id' name='seleccion.id' class='form-control my-2'>
                <c:forEach var="seleccion" items="${selecciones}">
                    <!-- ver lo de pais.id y pais.nombre -->
                    <option value='${seleccion.id}'>${seleccion.nombre}</option>
                </c:forEach>
            </select>

            <button type='submit' class='btn btn-success my-2'>Agregar</button>
        </form:form>
    </div>


</main>
<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>
