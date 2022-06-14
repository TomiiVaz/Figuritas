<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- head -->
<%@include file="head.jsp" %>
<body class="bg-dark ">

<%--	<%@include file="header.jsp" %>--%>
<div class="container mt-3 d-flex justify-content-center text-center" style="margin-bottom: 200px;">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 ">
        <%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
        <%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
        <%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
        <form:form action="validar-login" method="POST" modelAttribute="datosLogin">
            <h3 class="form-signin-heading text-white text-center m-2">Inicicar sesion</h3>
            <hr class="colorgraph">
            <br>

            <%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
            <label for="email" class="text-white mb-1">Email</label>
            <form:input path="email" id="email" type="email" class="form-control m-2" placeholder="Ingrese el mail"/>
            <label for="clave" class="text-white mb-1">Clave</label>
            <form:input path="password" type="password" id="password" class="form-control m-2" placeholder="Ingrese su clave"/>

            <%--Bloque que es visible si el elemento error no esta vacio	--%>
            <c:if test="${not empty error}">
                <h4 class="text-danger mb-2 mt-5"><span>${error}</span></h4>
                <br>
            </c:if>
            <button class="btn btn-lg btn-primary btn-block m-4" Type="Submit"/>
            Ingresar</button>
        </form:form>
        <a href="registrarse" class="m-2">Registrarme</a>

        ${msg}
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<!-- Script de Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

<%@include file="footer.jsp" %>
</body>
</html>
