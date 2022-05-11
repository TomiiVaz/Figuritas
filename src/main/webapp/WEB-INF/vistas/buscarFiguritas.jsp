<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 28/4/2022
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buscar Figuritas</title>

    <%--    Css Boostrap--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%--    /Css Boostrap--%>

</head>

<body>
<%@include file="header.jsp" %>

<main>
    <!--opciones de filtrado de cartas (por selección, nombre jugador, posición)-->
    <div class="container">
        <h4 class="mark">Filtros</h4>
        <form action="#" method="get">
            <div class="formSearchContainer">
                <input type="text" placeholder="buscar por nombre"
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
    <div class="container">
        <div class="row mt-4 bg-light gx-2">
            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>
            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>
            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>
            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>
            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>
            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>
            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>


            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>

            <div class="col-2 my-1">
                <div class="figuritaEncontrada border rounded border-primary">
                    <a href="#" class="btn">
                        <img src="img/messi-god-no.jpg" alt="foto1" width="95% " class="rounded m-auto d-block">
                        <div class="h4 text-center my-auto">Messi</div>
                    </a>
                </div>
            </div>


        </div>
    </div>
</main>

<!-- Footer -->
<%@include file="footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>

</html>
