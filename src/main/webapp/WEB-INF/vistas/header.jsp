<header class="bg-dark border-bottom border-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3">

            <a href="<c:url value="/home" />" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <img class="rounded-circle me-3" src="<c:url value="/img/favicon.ico" />" style="width: 32px">
                <span class="fs-4 text-white h2">FIGUS</span>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="<c:url value="/nosotros" />" class="nav-link px-2 text-white h4">Nosotros</a></li>
            </ul>

            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" method="get" action="buscarfiguritas">
                <label for="busq"></label>
                <input type="text" id="busq" name="busq" placeholder="Buscar Figurita/s..." class="form-control">
                <button type="submit" class="invisible"></button>
            </form>

            <c:choose>
                <c:when test="${id!=null}">
                    <div class="dropdown text-end ">
                        <a href="" class="d-block link-dark text-decoration-none dropdown-toggle d-flex justify-content-start" id="dropdownUser1"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="img/${usuario.nombre}.jpg" alt="mdo" width="32" height="32" class="rounded-circle">
                            <h3 class="text-white text-center ms-2">Hola ${usuario.nombre}</h3>
                        </a>
                        <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1" style="">
                            <li><a class="dropdown-item" href="<c:url value="/perfil/" />">Profile</a></li>
                            <!-- modificar para que lea un controlador y no sea un href -->
                            <c:if test="${rol.equals('ADM')}">
                                <li><a class="dropdown-item" href="configuracion">Configuracion</a></li>
                            </c:if>

                            <li><a class="dropdown-item" href="logout">Salir</a></li>
                        </ul>
                    </div>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value="/login" />"><button class="btn btn-primary btn-block m-2">Ingresar</button></a>
                    <a href="<c:url value="/registrarse" />"><button class="btn btn-warning btn-block m-2">Registrarse</button></a>
                </c:otherwise>
            </c:choose>


            <!-- hacer que quede bien centrado (funciona pero le falta eso) -->

        </div>
    </div>
</header>

