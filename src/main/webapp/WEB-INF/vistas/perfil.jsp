<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Figus - Perfil</title>
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

<main class=".container-fluid text-center">
    <!-- Parte Arriba -->

    <div class="row align-items-center justify-content-center m-2">
        <div class="col">
            <h1 class="mb-4 mt-2">Tomas Vazquez</h1>
            <div class="m-0">
                <img src="img/messi1.jpg" alt="Foto Perfil" class="img-thumbnail img-fluid m-0">
            </div>
            <button class="btn btn-primary mb-5 mt-3">Editar</button>
        </div>
        <%--        Datos--%>
        <div class="col m-2 d-flex align-items-center justify-content-around">
            <div class="text-start">
                <h4>Nombre de Usuario</h4>
                <h4>Equipo:</h4>
                <h4>Seleccion:</h4>
                <h4>Mail:</h4>
            </div>
            <div class="d-flex flex-column text-start">
                <h4>TomiiVaz</h4>
                <h4>Velez</h4>
                <h4>Argentina</h4>
                <h4>TomasVazquez@gmail.com</h4>
            </div>

            <%--        /Datos--%>
        </div>

        <!-- /Parte Arriba -->

        <!-- Parte Album -->
        <div class="container-fluid">
            <h2 class="mb-3">Mi Album</h2>
            <div class="text-end container">
                <button class="btn btn-primary mb-4">Agregar</button>
                <div class="mb-5 mt-2">
                    <select class="form-select form-select-sm" aria-label="Small select">
                        <option selected="">Selecciones</option>
                        <option value="1">Qatar</option>
                        <option value="2">Alemania</option>
                        <option value="3">Dinamarca</option>
                        <option value="4">Argentina</option>
                    </select>
                </div>
            </div>
            <div class="d-flex flex-wrap justify-content-center">
                <div class="card m-3" style="width: 18rem;">
                    <img src="img/messi1.jpg" class="card-img-top" alt="Foto de jugador">
                    <div class="card-body">
                        <h5 class="card-title">Nombre Jugador</h5>
                        <p class="card-text">Tipo de Carta</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Equipo:</li>
                        <li class="list-group-item">Posicion:</li>
                        <li class="list-group-item">Pierna Hábil:</li>
                        <li class="list-group-item">Dorsal:</li>
                    </ul>
                    <div class="card-body">
                        <a href="#" class="card-link">Ir a la carta</a>
                        <a href="#" class="card-link">Guardar</a>
                    </div>
                </div>

                <div class="card m-3" style="width: 18rem;">
                    <img src="img/messi2.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Nombre Jugador</h5>
                        <p class="card-text">Tipo de Carta</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Equipo:</li>
                        <li class="list-group-item">Posicion:</li>
                        <li class="list-group-item">Pierna Hábil:</li>
                        <li class="list-group-item">Dorsal:</li>
                    </ul>
                    <div class="card-body">
                        <a href="#" class="card-link">Ir a la carta</a>
                        <a href="#" class="card-link">Guardar</a>
                    </div>
                </div>

                <div class="card m-3" style="width: 18rem;">
                    <img src="img/messi3.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Nombre Jugador</h5>
                        <p class="card-text">Tipo de Carta</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Equipo:</li>
                        <li class="list-group-item">Posicion:</li>
                        <li class="list-group-item">Pierna Hábil:</li>
                        <li class="list-group-item">Dorsal:</li>
                    </ul>
                    <div class="card-body">
                        <a href="#" class="card-link">Ir a la carta</a>
                        <a href="#" class="card-link">Guardar</a>
                    </div>
                </div>

                <div class="card m-3" style="width: 18rem;">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Nombre Jugador</h5>
                        <p class="card-text">Tipo de Carta</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Equipo:</li>
                        <li class="list-group-item">Posicion:</li>
                        <li class="list-group-item">Pierna Hábil:</li>
                        <li class="list-group-item">Dorsal:</li>
                    </ul>
                    <div class="card-body">
                        <a href="#" class="card-link">Ir a la carta</a>
                        <a href="#" class="card-link">Guardar</a>
                    </div>
                </div>

                <div class="card m-3" style="width: 18rem;">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Nombre Jugador</h5>
                        <p class="card-text">Tipo de Carta</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Equipo:</li>
                        <li class="list-group-item">Posicion:</li>
                        <li class="list-group-item">Pierna Hábil:</li>
                        <li class="list-group-item">Dorsal:</li>
                    </ul>
                    <div class="card-body">
                        <a href="#" class="card-link">Ir a la carta</a>
                        <a href="#" class="card-link">Guardar</a>
                    </div>
                </div>

                <div class="card m-3" style="width: 18rem;">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Nombre Jugador</h5>
                        <p class="card-text">Tipo de Carta</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Equipo:</li>
                        <li class="list-group-item">Posicion:</li>
                        <li class="list-group-item">Pierna Hábil:</li>
                        <li class="list-group-item">Dorsal:</li>
                    </ul>
                    <div class="card-body">
                        <a href="#" class="card-link">Ir a la carta</a>
                        <a href="#" class="card-link">Guardar</a>
                    </div>
                </div>

                <div class="card m-3" style="width: 18rem;">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Nombre Jugador</h5>
                        <p class="card-text">Tipo de Carta</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Equipo:</li>
                        <li class="list-group-item">Posicion:</li>
                        <li class="list-group-item">Pierna Hábil:</li>
                        <li class="list-group-item">Dorsal:</li>
                    </ul>
                    <div class="card-body">
                        <a href="#" class="card-link">Ir a la carta</a>
                        <a href="#" class="card-link">Guardar</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- /Parte Album -->
</main>
<%--Script Boostrap--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<%--/Script Boostrap--%>
</body>
</html>
