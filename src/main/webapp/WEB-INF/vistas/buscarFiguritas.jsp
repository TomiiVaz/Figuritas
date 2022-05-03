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
<header class="mb-5">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3">

            <a href="home" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <%--                Logo app--%>
                <span class="fs-4">Figus</span>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="#" class="nav-link px-2 link-dark">Nosotros</a></li>
            </ul>

            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
            </form>

            <div class="dropdown text-end ">
                <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1"
                   data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
                </a>
                <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1" style="">
                    <li><a class="dropdown-item" href="perfil">Profile</a></li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>
                    <li><a class="dropdown-item" href="home">Sign out</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>

<main>
    <!--opciones de filtrado de cartas (por selección, nombre jugador, posición)-->
    <div class="container">
        <h4 class="mark">Filtros</h4>
        <form action="#" method="get" >
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>

</html>
