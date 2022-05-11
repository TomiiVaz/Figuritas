<%--
  Created by IntelliJ IDEA.
  User: DAMIAN
  Date: 3/5/2022
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Los Panini</title>

    <!-- Bootstrap CSS Jquery-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Material+Icons+Round"> <!-- google icons-->
    <link rel="stylesheet" href="css/styles.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="js/jquery-3.6.0.min.js"></script>

    <!-- Favicon-->
    <link rel="icon" href="img/favicon.ico">

</head>
<body>

<%@include file="header.jsp" %>
<!-- Main -->
<main class="bg-dark">

    <div class="container">

        <div class="row">

            <div class="col-sm-2">
                <img class="img-fluid" src="img/messi-epico.jpg" alt="" style="height: 100%;">
            </div>

            <div class="col-sm-8">
                <h1 class="text-white text-center">Nosotros</h1>
                <p class="text-white">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Velit delectus quisquam rerum ducimus impedit soluta tempore accusantium, rem saepe, ad fuga ut provident enim in iste optio! Rerum reprehenderit voluptate magnam sunt distinctio corrupti amet quis aspernatur explicabo, earum placeat neque, sapiente beatae vero tenetur adipisci nisi excepturi voluptatibus deserunt? Veniam suscipit repudiandae magnam libero voluptas cupiditate, ipsum laboriosam ut ratione voluptates doloremque dolor perferendis ex modi esse ea saepe minima voluptatem molestias quam dolores perspiciatis quos quod similique! Aut culpa perspiciatis recusandae ratione reiciendis placeat necessitatibus sapiente eaque dolores pariatur! Harum odit, omnis officiis itaque fugiat consequatur similique rem recusandae adipisci placeat explicabo fugit reiciendis eum eaque nisi at praesentium! Aliquid repellat sapiente cum esse deleniti adipisci beatae quod laborum ut molestias itaque veritatis dicta optio ex qui nesciunt tempora rem quos, nostrum mollitia velit sequi. Debitis deserunt, earum laborum quae voluptas praesentium ea vero corporis. Voluptate quidem, eaque officia vel soluta, a, nisi omnis aperiam consectetur provident ad saepe. Harum rem voluptas ab sunt ipsam eius neque, quaerat perspiciatis aliquid quibusdam distinctio esse ad deserunt, repellendus officiis provident. Aliquam magni ducimus labore! Enim libero quas rem cumque ipsam dolorum explicabo molestias eius repellat consectetur non deserunt, temporibus expedita.</p>

                <div class="container m-2">
                    <div class="row">
                        <div class="col-sm-3">
                            <img class="img-fluid img-thumbnail" src="img/foto-carnet.jpg" alt="">
                            <p class="text-center text-white">Manu</p>
                        </div>
                        <div class="col-sm-3">
                            <img class="img-fluid img-thumbnail" src="img/foto-carnet.jpg" alt="">
                            <p class="text-center text-white">Tomi</p>
                        </div>
                        <div class="col-sm-3">
                            <img class="img-fluid img-thumbnail" src="img/foto-carnet.jpg" alt="">
                            <p class="text-center text-white">Juani</p>
                        </div>
                        <div class="col-sm-3">
                            <img class="img-fluid img-thumbnail" src="img/foto-carnet.jpg" alt="">
                            <p class="text-center text-white">Dami</p>
                        </div>

                    </div>


                </div>
            </div>

            <div class="col-sm-2">
                <img class="img-fluid" src="img/ronaldo-epico.jpg" alt="" style="height: 100%;">
            </div>

        </div>

    </div>

</main>

<!-- Footer -->
<div class="container">
    <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
        <div class="col-md-4 d-flex align-items-center">
            <!-- aca iria un iconito de la marca -->
            <ul class="list-unstyled">
                <li>
                    <a href="/" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 320 512"><!--! Font Awesome Pro 6.1.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. --><path d="M320 64.01c0 17.67-14.33 32-32 32H64v128h160c17.67 0 32 14.32 32 31.1s-14.33 32-32 32H64v160c0 17.67-14.33 32-32 32s-32-14.33-32-32v-384C0 46.34 14.33 32.01 32 32.01h256C305.7 32.01 320 46.34 320 64.01z"/></svg>
                    </a>
                </li>
            </ul>
            <span class="text-muted">© 2022 Figus, Inc</span>
        </div>

        <div class="col-md-4 d-flex align-items-center justify-content-center text-muted">
            <p>Los pibardos de Taller Web I</p>
        </div>

        <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">

            <li><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><!--! Font Awesome Pro 6.1.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. --><path d="M459.37 151.716c.325 4.548.325 9.097.325 13.645 0 138.72-105.583 298.558-298.558 298.558-59.452 0-114.68-17.219-161.137-47.106 8.447.974 16.568 1.299 25.34 1.299 49.055 0 94.213-16.568 130.274-44.832-46.132-.975-84.792-31.188-98.112-72.772 6.498.974 12.995 1.624 19.818 1.624 9.421 0 18.843-1.3 27.614-3.573-48.081-9.747-84.143-51.98-84.143-102.985v-1.299c13.969 7.797 30.214 12.67 47.431 13.319-28.264-18.843-46.781-51.005-46.781-87.391 0-19.492 5.197-37.36 14.294-52.954 51.655 63.675 129.3 105.258 216.365 109.807-1.624-7.797-2.599-15.918-2.599-24.04 0-57.828 46.782-104.934 104.934-104.934 30.213 0 57.502 12.67 76.67 33.137 23.715-4.548 46.456-13.32 66.599-25.34-7.798 24.366-24.366 44.833-46.132 57.827 21.117-2.273 41.584-8.122 60.426-16.243-14.292 20.791-32.161 39.308-52.628 54.253z"/></svg></li>
            <li><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><!--! Font Awesome Pro 6.1.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. --><path d="M504 256C504 119 393 8 256 8S8 119 8 256c0 123.78 90.69 226.38 209.25 245V327.69h-63V256h63v-54.64c0-62.15 37-96.48 93.67-96.48 27.14 0 55.52 4.84 55.52 4.84v61h-31.28c-30.8 0-40.41 19.12-40.41 38.73V256h68.78l-11 71.69h-57.78V501C413.31 482.38 504 379.78 504 256z"/></svg></li>
            <li><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><!--! Font Awesome Pro 6.1.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. --><path d="M224.1 141c-63.6 0-114.9 51.3-114.9 114.9s51.3 114.9 114.9 114.9S339 319.5 339 255.9 287.7 141 224.1 141zm0 189.6c-41.1 0-74.7-33.5-74.7-74.7s33.5-74.7 74.7-74.7 74.7 33.5 74.7 74.7-33.6 74.7-74.7 74.7zm146.4-194.3c0 14.9-12 26.8-26.8 26.8-14.9 0-26.8-12-26.8-26.8s12-26.8 26.8-26.8 26.8 12 26.8 26.8zm76.1 27.2c-1.7-35.9-9.9-67.7-36.2-93.9-26.2-26.2-58-34.4-93.9-36.2-37-2.1-147.9-2.1-184.9 0-35.8 1.7-67.6 9.9-93.9 36.1s-34.4 58-36.2 93.9c-2.1 37-2.1 147.9 0 184.9 1.7 35.9 9.9 67.7 36.2 93.9s58 34.4 93.9 36.2c37 2.1 147.9 2.1 184.9 0 35.9-1.7 67.7-9.9 93.9-36.2 26.2-26.2 34.4-58 36.2-93.9 2.1-37 2.1-147.8 0-184.8zM398.8 388c-7.8 19.6-22.9 34.7-42.6 42.6-29.5 11.7-99.5 9-132.1 9s-102.7 2.6-132.1-9c-19.6-7.8-34.7-22.9-42.6-42.6-11.7-29.5-9-99.5-9-132.1s-2.6-102.7 9-132.1c7.8-19.6 22.9-34.7 42.6-42.6 29.5-11.7 99.5-9 132.1-9s102.7-2.6 132.1 9c19.6 7.8 34.7 22.9 42.6 42.6 11.7 29.5 9 99.5 9 132.1s2.7 102.7-9 132.1z"/></svg></li>

        </ul>
    </footer>
</div>

<!-- Script de Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>
