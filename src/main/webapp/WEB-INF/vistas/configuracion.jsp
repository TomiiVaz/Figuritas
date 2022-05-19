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

    <div class="container container-fluid">
        <%--        Seccion Formularios--%>
        <%--                Form Figurita--%>
        <div class="collapse bg-dark mt-5 mb-5" id="collapseAgregarFigu">
            <div class="card card-body bg-dark border-0">
                <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                           method='post'
                           action='agregar-figurita'
                           modelAtribute="figurita">
                    <input class='my-2 form-control' type='text' path='nombre' id='nombre'
                           placeholder="Ingresa el nombre"/>
                    <select name='rareza' path="rareza" class='form-control my-2'>
                        <option value='Default' selected hidden>Seleccionar una rareza</option>
                        <option value='1'>Comun</option>
                        <option value='2'>Rara</option>
                        <option value='3'>Epica</option>
                    </select>
                    <!-- ver en el path si es pais o pais.id -->
                    <select name='seleccion' path='seleccion' class='form-control my-2'>
                        <c:forEach var="seleccion" items="${selecciones}">
                            <!-- ver lo de pais.id y pais.nombre -->
                            <option value='${seleccion.id}'>${seleccion.nombre}</option>
                        </c:forEach>
                    </select>

                    <button type='submit' class='btn btn-success my-2'>Agregar</button>
                </form:form>
            </div>
        </div>
        <%--                /Form Figurita--%>

        <%--                Form Album--%>
        <div class="collapse bg-dark mt-5 mb-5" id="collapseNuevoAlbum">
            <div class="card card-body bg-dark border-0">
                <form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                      method='post'
                      action=''>
                    <input class='my-2 form-control' type='text' name='nombreNuevoAlbum' id='nombreNuevoAlbum'
                           placeholder='Ingrese el nombre sel album'>
                    <select name='seleccionAgregada' class='form-control my-2'>
                        <option value='Default' selected hidden>Seleccionar una seleccion</option>
                        <option value='Argentina'>Argentina</option>
                        <option value='Bolivia'>Bolivia</option>
                        <option value='Uruguay'>Uruguay</option>
                        <option value='Chile'>Chile</option>
                    </select>
                    <button type='submit' class='btn btn-success my-2'>Agregar</button>
                </form>
            </div>
        </div>
    </div>
    <%--                /Form Album--%>

    <%--        /Seccion Formularios--%>
</main>
<!-- Footer -->
<%@include file="footer.jsp" %>

</body>
</html>