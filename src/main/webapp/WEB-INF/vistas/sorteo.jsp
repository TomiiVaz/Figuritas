<%--
  Created by IntelliJ IDEA.
  User: DAMIAN
  Date: 3/6/2022
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

        <h1 class="text-center text-white mt-5">Elegi y gana!!!</h1>

    <div class="container d-flex justify-content-around flex-wrap mt-5">
        <!-- Figurita 1  -->
        <div>
            <img src="img/question.svg" width="300px" height="400px" id="foto1">

            <img src="img/${figurita1.nombre}.jpg" class="d-block img-fluid visually-hidden" width="300px" height="400px" id="foto11">
            <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0 visually-hidden'
                       method='post'
                       action='asignar-ganador'
                       modelAttribute="figurita"
                       id='foto111'>

                <%--    input invisible paso el nombre de la figurita para borrarla--%>
                <input class='invisible' type="text"  name='nombre' value="${figurita1.nombre}">

                <button type='submit' class='btn btn-danger my-2 text-white h3'>Reclamar figurita</button>
            </form:form>
        </div>

        <!-- Figurita 2 -->
        <div>
            <img src="img/question.svg" width="300px" height="400px" id="foto2">
            <img src="img/${figurita2.nombre}.jpg" class="d-block img-fluid visually-hidden" width="300px" height="400px" id="foto22">
            <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0 visually-hidden'
                       method='post'
                       action='asignar-ganador'
                       modelAttribute="figurita"
                       id='foto222'>

                <%--    input invisible paso el nombre de la figurita para borrarla--%>
                <input class='invisible' type="text"  name='nombre' value="${figurita2.nombre}">

                <button type='submit' class='btn btn-danger my-2'>Reclamar figurita</button>
            </form:form>
        </div>

        <!-- Figurita 3 -->
        <div>
            <img src="img/question.svg" width="300px" height="400px" id="foto3">
            <img src="img/${figurita3.nombre}.jpg" class="d-block img-fluid visually-hidden" width="300px" height="400px" id="foto33">
            <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0 visually-hidden'
                       method='post'
                       action='asignar-ganador'
                       modelAttribute="figurita"
                        id='foto333'>

                <%--    input invisible paso el nombre de la figurita para borrarla--%>
                <input class='invisible' type="text"  name='nombre' value="${figurita3.nombre}">

                <button type='submit' class='btn btn-danger my-2'>Reclamar fSigurita</button>
            </form:form>
        </div>



    </div>


    <div class="d-block container text-white h1 mt-5 text-center" id="premio">



    </div>


    <div class="container text-center mt-5">
        <a href="home" class="text-decoration-none">
            <button type='button' class='btn btn-warning my-2'>Volver</button>
        </a>

    </div>




</main>

<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>
