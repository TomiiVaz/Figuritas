<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="head.jsp" %>
<body class="bg-dark">
<div class="container mt-3 d-flex justify-content-center text-center">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="registrarme" method="POST" modelAttribute="usuario">
            <h3 class="form-signin-heading text-white">Nuevo Usuario</h3>
            <hr class="colorgraph">
            <br>

            <label for="email" class="text-white mb-1">Email</label>
            <input path="email" id="email" name='email' class="form-control mb-3" placeholder="Ingrese el mail"/>
            <c:if test="${not empty error}">
                <p class="text-danger"><span>${error}</span></p>
                <br>
            </c:if>
            <label for="equipo" class="text-white mb-1">Equipo</label>
            <input path="equipo" type="text" id="equipo" name='equipo' class="form-control mb-3" placeholder="Ingrese su equipo"/>

            <label for='seleccion.id' class='text-white'>Seleccion</label>
            <select path='seleccion.id' id='seleccion.id' name='seleccion.id' class='form-control my-2'>
                <c:forEach var="seleccion" items="${selecciones}">
                    <!-- ver lo de pais.id y pais.nombre -->
                    <option value='${seleccion.id}'>${seleccion.nombre}</option>
                </c:forEach>
            </select>

            <label for="nombre" class="text-white mb-1">Nombre</label>
            <input path="nombre" type="text" id="nombre" name='nombre' class="form-control mb-3" placeholder="Ingrese su nombre"/>

            <label for="password" class="text-white mb-1">Clave</label>
            <input path="password" type="password" id="password" name='password' class="form-control mb-3" placeholder="Ingrese su clave"/>

            <label for="claveConfirm" class="text-white mb-1">Confirmar clave</label>
            <input path="claveConfirm" type="password" id="claveConfirm" name='claveConfirm' class="form-control mb-3" placeholder="Confirme su clave"/>

            <button id="btn-registrarme" class="btn btn-lg btn-primary btn-block mt-4 mb-5 mb-5 " Type="Submit"/>
            Registrarme</button>
        </form:form>
    </div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>