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
    <div class="container-fluid d-flex justify-content-around mt-5 mb-2 mb-4">
        <%--    Seccion Figurita--%>
        <div class="text-center">
            <h3 class="text-white">Figuritas</h3>
            <button type="button" class="btn btn-primary m-1" data-bs-toggle="collapse" data-bs-target="#collapseAgregarFigu" aria-expanded="false" aria-controls="collapseAgregarFigu">Agregar</button>
            <button type="button" class="btn btn-primary m-1">Modificar</button>
            <button type="button" class="btn btn-primary m-1">Eliminar</button>
        </div>
        <%--    /Seccion Figurita--%>

        <%--    Seccion Seleccion--%>
        <div class="text-center">
            <h3 class="text-white">Seleccion</h3>
            <button type="button" class="btn btn-primary m-1">Agregar</button>
            <button type="button" class="btn btn-primary m-1">Modificar</button>
            <button type="button" class="btn btn-primary m-1">Eliminar</button>
        </div>
        <%--    /Seccion Seleccion--%>

        <%--    Seccion Almbum--%>
        <div class="text-center">
            <h3 class="text-white">Album</h3>
            <button type="button" class="btn btn-primary m-1" data-bs-toggle="collapse"
                    data-bs-target="#collapseNuevoAlbum" aria-expanded="false" aria-controls="collapseNuevoAlbum">
                Agregar
            </button>
            <button type="button" class="btn btn-primary m-1">Modificar</button>
            <button type="button" class="btn btn-primary m-1">Eliminar</button>
        </div>
        <%--    /Seccion Almbum--%>

        <%--    Seccion Usuario--%>
        <div class="text-center">
            <h3 class="text-white">Usuario</h3>
            <button type="button" class="btn btn-primary m-1">Agregar</button>
            <button type="button" class="btn btn-primary m-1">Modificar</button>
            <button type="button" class="btn btn-primary m-1">Eliminar</button>
        </div>
        <%--    /Seccion Usuario--%>
    </div>
    <div class="container container-fluid">
        <%--        Seccion Formularios--%>
        <%--                Form Figurita--%>
            <div class="collapse bg-dark mt-5 mb-5" id="collapseAgregarFigu">
                <div class="card card-body bg-dark border-0">
                    <form:form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                          method='post'
                          action='agregar-figurita'
                          modelAtribute="figurita">
                        <input class='my-2 form-control' type='text' path='nombre' name='nombre' id='nombre' placeholder="Ingresa el nombre">
                        <select name='rareza' path="rareza" class='form-control my-2'>
                            <option value='Default' selected hidden>Seleccionar una rareza</option>
                            <option value='1'>Comun</option>
                            <option value='2'>Rara</option>
                            <option value='3'>Epica</option>
                        </select>
                        <!-- ver en el path si es pais o pais.id -->
                        <select name='seleccion.id' path='seleccion.id' class='form-control my-2'>
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
                    <input class='my-2 form-control' type='text' name='nombreNuevoAlbum' id='nombreNuevoAlbum' placeholder='Ingrese el nombre sel album'>
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