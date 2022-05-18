<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<!-- head -->
<%@include file="head.jsp" %>
<body class="bg-dark">
<!-- header -->
<%@include file="header.jsp" %>
<!-- main -->
<main>
    <div class="container-fluid d-flex justify-content-around mt-5 mb-2 mb-4">
        <%--    Seccion Figurita--%>
        <div class="text-center">
            <h3 class="text-white">Figuritas</h3>
            <button type="button" class="btn btn-primary m-1">Agregar</button>
            <button type="button" class="btn btn-primary m-1">Modificar</button>
            <button type="button" class="btn btn-primary m-1">Eliminar</button>
        </div>
        <%--    /Seccion Figurita--%>

        <%--    Seccion Almbum--%>
        <div class="text-center">
            <h3 class="text-white">Album</h3>
            <button type="button" class="btn btn-primary m-1">Agregar</button>
            <button type="button" class="btn btn-primary m-1">Modificar</button>
            <button type="button" class="btn btn-primary m-1">Eliminar</button>
        </div>
        <%--    /Seccion Almbum--%>

        <%--    Seccion Seleccion--%>
        <div class="text-center">
            <h3 class="text-white">Seleccion</h3>
            <button type="button" class="btn btn-primary m-1">Agregar</button>
            <button type="button" class="btn btn-primary m-1">Modificar</button>
            <button type="button" class="btn btn-primary m-1">Eliminar</button>
        </div>
        <%--    /Seccion Seleccion--%>

        <%--    Seccion Usuario--%>
        <div class="text-center">
            <h3 class="text-white">Usuario</h3>
            <button type="button" class="btn btn-primary m-1">Agregar</button>
            <button type="button" class="btn btn-primary m-1">Modificar</button>
            <button type="button" class="btn btn-primary m-1">Eliminar</button>
        </div>
        <%--    /Seccion Usuario--%>

        <%--        Seccion Formularios--%>
        <%--                Form Figurita--%>

        <%--                /Form Figurita--%>

        <%--                Form Album--%>

        <%--                /Form Album--%>

        <%--        /Seccion Formularios--%>

    </div>
</main>
<!-- Footer -->
<%@include file="footer.jsp" %>
</div>

<!-- Script de Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>


</body>
</html>