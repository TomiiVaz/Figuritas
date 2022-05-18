<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<%@include file="head.jsp" %>
<%@include file="header.jsp" %>
<body class="bg-dark">

    <div style='min-height: 120px;' class='container-fluid' >
            <div class='card card - body border-0' style='width: 300px;'>
            <form class='text-center d-flex flex-column px-5 px-5 py-2 bg-dark border-0'
                  method='post'
                  action='agregar-figurita'
                  modelAtribute="figurita">
                <input class='my-2 form-control' type='text' name='nombre' id='nombre' placeholder='Ingrese el nombre del jugador'>
                <select name='rareza' class='form-control my-2'>
                    <option value='Default' selected hidden>Seleccionar una rareza</option>
                    <option value='comun'>Comun</option>
                    <option value='rara'>Rara</option>
                    <option value='epica'>Epica</option>
                </select>
                <select name='seleccion' class='form-control my-2'>
                    <option value='Default' selected hidden>Seleccionar una seleccion</option>
                    <option value='argentina'>Argetina</option>
                    <option value='brazil'>Brazil</option>
                    <option value='italia'>Italia</option>
                </select>
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
