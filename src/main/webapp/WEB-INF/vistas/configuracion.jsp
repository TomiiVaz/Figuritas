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
            <button type="button" class="btn btn-primary m-1" data-bs-toggle="collapse"
                    data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">Agregar
            </button>
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
    </div>
    <div class="container container-fluid">
        <%--        Seccion Formularios--%>
        <%--                Form Figurita--%>

        <%--                /Form Figurita--%>

        <%--                Form Album--%>
        <div class="collapse" id="collapseExample">
            <div class="card card-body">
                <form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                      method='post'
                      action='alta.php'
                      enctype='multipart/form-data'>
                    <input class='my-2 form-control' type='text' name='nombreNuevo' id='nombreNuevo' placeholder='Ingrese el nombre de Pokemon'>
                    <select name='tipoNuevo' class='form-control my-2'>
                        <option value='Default' selected hidden>Seleccionar un tipo</option>
                        <option value='Aire'>Aire</option>
                        <option value='Fuego'>Fuego</option>
                        <option value='Tierra'>Tierra</option>
                        <option value='Viento'>Viento</option>
                    </select>
                    <input class='my-2 form-control' type='number' name='numeroNuevo' id='numeroNuevo' placeholder='Ingrese el numero de Pokemon'>
                    <div class='my-2'>
                        <input type='file' class='form-control' aria-label='file example' name='imagenNueva'>
                        <div class='invalid-feedback'>Example invalid form file feedback</div>
                    </div>
                    <input class='my-2 form-control' type='text' name='nombreImagen' id='nombreImagen' placeholder='Ingrese nombre de la imagen'>
                    <input class='my-2 form-control' type='text' name='nuevaDescripcion' id='nuevaDescripcion' placeholder='Ingrese descripcion del pokemon'>
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