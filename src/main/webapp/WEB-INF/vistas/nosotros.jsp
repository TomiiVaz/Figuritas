<%--
  Created by IntelliJ IDEA.
  User: DAMIAN
  Date: 3/5/2022
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="head.jsp" %>

<body class="bg-dark">
<!-- Header -->
<%@include file="header.jsp" %>
<!-- Main -->
<main class="bg-dark">
    <div class="container mt-5">
        <div class="row">
            <div class="col-sm-2">
                <img class="img-fluid" src="img/messi-epico.jpg" alt="" style="height: 100%;">
            </div>
            <div class="col-sm-8">
                <h1 class="text-white text-center mb-5">Nosotros</h1>
                <p class="text-white">
                    Somos un equipo de developers con un alto nivel de conocimiento en el desarrollo de aplicaciones web fullstack. Gracias a nuestra gran creatividad, persistencia y un muy nivel de comunicación logramos aplicaciones como esta y muchas otras.
                    <br>
                    <br>
                    <br>
                    Tras 4 meses de diseño, planificación y desarrollo, lanzamos la primera versión del mercado de figuritas, llamado <strong>FIGUS</strong>.
                    <br>
                    <br>
                    <br>
                    Le pusimos onda profe dale aprobanos jaja. 😎 😎 😎 😎
                </p>

                <div class="container mt-5">
                    <div class="row">
                        <div class="col-sm-3">
                            <img class="img-fluid img-thumbnail" src="img/foto-carnet.jpg" alt="">
                            <p class="text-center text-white">Manu</p>
                        </div>
                        <div class="col-sm-3">
                            <img class="img-fluid img-thumbnail" src="img/foto-carnet.jpg" alt="">
                            <p class="text-center text-white">Tomi</p>
                        </div>
                        <div class="col-sm-3">
                            <img class="img-fluid img-thumbnail" src="img/foto-carnet.jpg" alt="">
                            <p class="text-center text-white">Juani</p>
                        </div>
                        <div class="col-sm-3">
                            <img class="img-fluid img-thumbnail" src="img/foto-carnet.jpg" alt="">
                            <p class="text-center text-white">Dami</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-2">
                <img class="img-fluid" src="img/ronaldo-epico.jpg" alt="" style="height: 100%;">
            </div>
        </div>
    </div>
</main>
<!-- Footer -->
<%@include file="footer.jsp" %>
</body>
</html>
