<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 28/4/2022
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-- head -->
<%@include file="head.jsp" %>


<body class="bg-dark">
<%@include file="header.jsp" %>

<main>
    <!--opciones de filtrado de cartas (por selección, nombre jugador, posición)-->
    <div class="container mt-3">
        <h4 class="text-white">Filtros</h4>
        <form action="buscarfiguritas" method="get">
            <div class="formSearchContainer">
                <input type="text" id="busq" name="busq" placeholder="buscar por nombre"
                       class="form-control">
            </div>
            <div class="row gx-2 mt-2">
                <div class="col">
                    <select name="selSeleccion" id="selSeleccion" class="form-select">
                        <option value="0">--Elige una selección--</option>
                        <option value="1">Argentina</option>
                        <option value="2">Brasil</option>
                        <option value="3">Qatar</option>
                        <option value="4">Francia</option>
                    </select>
                </div>

                <div class="col">
                    <select name="selPosicionJugador" id="selPosicionJugador" class="form-select">
                        <option value="0">--Elije una posición de jugador--</option>
                        <option value="1">Arquero</option>
                        <option value="2">Defensor</option>
                        <option value="3">Mediocampista</option>
                        <option value="4">Delantero</option>
                    </select>
                </div>
            </div>


        </form>
    </div>

    <!--listado de figuritas-->
    <div class="container bg-dark">
        <div class="row mt-4 bg-dark gx-2">
            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>
            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>
            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>
            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>
            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>
            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-white">
                    <a href="carta" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto text-white">Messi</div>
                    </a>
                </div>
            </div>


        </div>
    </div>
</main>

<!-- Footer -->
<%@include file="footer.jsp" %>
</body>

</html>
