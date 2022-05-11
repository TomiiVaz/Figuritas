<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Figus - Perfil</title>
    <%--    Css Boostrap--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%--    /Css Boostrap--%>
</head>
<body class="bg-dark">

<%@include file="header.jsp" %>

<main class=".container-fluid text-center">
    <!-- Parte Arriba -->

    <div class="row align-items-center justify-content-center m-2">
        <div class="col">
            <h1 class="mb-4 mt-2 text-white">Tomas Vazquez</h1>
            <div class="m-0">
                <img src="img/messi1.jpg" alt="Foto Perfil" class="img-thumbnail img-fluid m-0">
            </div>
            <button class="btn btn-primary mb-5 mt-3">Editar</button>
        </div>
        <%--        Datos--%>
        <div class="col m-2 d-flex align-items-center justify-content-around">
            <div class="text-start">
                <h4 class="text-white">Nombre de Usuario</h4>
                <h4 class="text-white">Equipo:</h4>
                <h4 class="text-white">Seleccion:</h4>
                <h4 class="text-white">Mail:</h4>
            </div>
            <div class="d-flex flex-column text-start">
                <h4 class="text-white">TomiiVaz</h4>
                <h4 class="text-white">Velez</h4>
                <h4 class="text-white">Argentina</h4>
                <h4 class="text-white">TomasVazquez@gmail.com</h4>
            </div>

            <%--        /Datos--%>
        </div>

        <!-- /Parte Arriba -->

        <!-- Parte Album -->
        <div class="container-fluid">
            <h2 class="mb-3 text-white">Mi Album</h2>
            <div class="text-end container">
                <%--                Agregar figurita form--%>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Agregar
                </button>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title text-white" id="exampleModalLabel">Agregar Figurita</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body text-center">
                                <form class="d-flex flex-column mb-2"
                                      method="post"
                                      action="agregar-figurita">
                                    <label for="codigo" class="mb-1">Ingresar código</label>
                                    <input type="text" name="codigo" id="codigo" class="form-control mt-2">
                                    <button type="submit" class="btn btn-primary mt-3">Save changes</button>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <%--                    El boton esta fuera del form, por lo cual no se donde me lo envia xd--%>
                <%--                /Agregar figurita form--%>
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
                    <ul class="list-group list-group-flush text-start">
                        <li class="list-group-item">Equipo: PSG</li>
                        <li class="list-group-item">Posicion: Delantero</li>
                        <li class="list-group-item">Pierna Hábil: Zurda</li>
                        <li class="list-group-item">Dorsal: 30</li>
                    </ul>
                    <div class="card-body">
                        <a href="carta" class="card-link">Ir a la carta</a>
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
                    </div>
                </div>

                <div class="card m-3" style="width: 18rem;">
                    <img src="img/messi1.jpg" class="card-img-top" alt="...">
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
                    </div>
                </div>

                <div class="card m-3" style="width: 18rem;">
                    <img src="img/messi1.jpg" class="card-img-top" alt="...">
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
                    </div>
                </div>

                <div class="card m-3" style="width: 18rem;">
                    <img src="img/messi1.jpg" class="card-img-top" alt="...">
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
                    </div>
                </div>

                <div class="card m-3" style="width: 18rem;">
                    <img src="img/messi1.jpg" class="card-img-top" alt="...">
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
                    </div>
                </div>
            </div>
        </div>
        <!-- /Parte Album -->
</main>

<!-- Footer -->
<%@include file="footer.jsp" %>

<%--Script Boostrap--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<%--/Script Boostrap--%>
</body>
</html>
