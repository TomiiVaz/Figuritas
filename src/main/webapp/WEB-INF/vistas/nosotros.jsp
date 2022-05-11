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

<body class="bg-dark">
<!-- Header -->
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
<%@include file="footer.jsp" %>
</div>

<!-- Script de Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>
