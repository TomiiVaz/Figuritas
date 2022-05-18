<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="head.jsp" %>
<%@include file="header.jsp" %>
<body class="bg-dark">

    <div style='min-height: 120px;' class='container-fluid' >
            <div class='card card - body border-0' style='width: 300px;'>
            <form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                  method='post'
                  action='alta.php'>
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


<%@include file="footer.jsp" %>
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
