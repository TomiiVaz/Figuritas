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
    
    <div class="container text-center mt-5">
        <a href="home" class="text-decoration-none">
            <button type='button' class='btn btn-warning my-2'>Volver</button>
        </a>

    </div>

    <div class="container-fluid">
        <%--    Seccion Cuadrados--%>
        <div class="text-center mb-5">
            <%--    Primera fila--%>
            <h1 class="text-white mb-5 mt-5">ADMINISTRADOR</h1>
            <div class="row mb-5">
                <div class="col-6">
                    <h2 class="text-white">Figurita</h2>
                    <a href="configuracion-figurita">
                        <button class="btn btn-primary mb-5 mt-3">Ingresar</button>
                    </a>
                </div>
                <div class="col-6">
                    <h2 class="text-white">Seleccion</h2>
                    <a href="configuracion-seleccion">
                        <button class="btn btn-primary mb-5 mt-3">Ingresar</button>
                    </a>
                </div>
            </div>
            <%--    /Primera fila--%>
            <%--    Segunda fila--%>
            <div class="row mb-5">
                <div class="col-6">
                    <h2 class="text-white">Album</h2>
                    <a href="configuracion-album">
                        <button class="btn btn-primary mb-5 mt-3">Ingresar</button>
                    </a>
                </div>
                <div class="col-6">
                    <h2 class="text-white">Usuario</h2>
                    <a href="configuracion-usuario">
                        <button class="btn btn-primary mb-5 mt-3">Ingresar</button>
                    </a>
                </div>
            </div>
            <%--    /Segunda fila--%>
        </div>
    </div>
    <%--    /Seccion Cuadrados--%>

</main>
<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>