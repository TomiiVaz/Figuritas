<header class="bg-dark border-bottom border-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3">

            <a href="home" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <img class="rounded-circle me-3" src="img/favicon.ico" style="width: 32px">
                <span class="fs-4 text-white h2">FIGUS</span>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="nosotros" class="nav-link px-2 link-dark text-white h4">Nosotros</a></li>
            </ul>

            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" method="get" action="buscarfiguritas">
                <label for="busq"></label>
                <input type="text" id="busq" name="busq" placeholder="Buscar Figurita/s..." class="form-control">
                <button type="submit" class="invisible"></button>
            </form>

            <div class="dropdown text-end ">
                <a href="" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1"
                   data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="img/messi1.jpg" alt="mdo" width="32" height="32" class="rounded-circle">
                </a>
                <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1" style="">
                    <li><a class="dropdown-item" href="perfil">Profile</a></li>
                    <c:if>
                        <li><a class="dropdown-item" href="configuracion">Configuracion</a></li>
                    </c:if>
                    <li><a class="dropdown-item" href="home">Sign out</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>

