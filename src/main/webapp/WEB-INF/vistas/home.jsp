<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<%@include file="header.jsp" %>

<main>

	<section>
		<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
				<button type="button" data-bstarget="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img style="height: 520px"  src="img/messi1.jpg" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img style="height: 520px"  src="img/messi2.jpg" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img style="height: 520px"  src="img/messi3.jpg" class="d-block w-100" alt="...">
				</div>
			</div>
			<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</section>
	<section>
		<div>
			<h2 class="text-white text-center mt-3">Econtra la figurita que te falta</h2>
		</div>
		<div class="container bg-dark">
			<div class="row mt-4 bg-dark gx-2">
				<div class="col-2 my-1">
					<div class="figuritaEncontrada border rounded border-white">
						<a href="#" class="btn">
							<img src="img/messi-god-no.jpg" alt="foto1" width="100% " class="rounded m-auto d-block">
							<div class="h4 text-center my-auto text-white">Messi</div>
						</a>
					</div>
				</div>

				<div class="col-2 my-1">
					<div class="figuritaEncontrada border rounded border-white">
						<a href="#" class="btn">
							<img src="img/messi-god-no.jpg" alt="foto1" width="100% " class="rounded m-auto d-block">
							<div class="h4 text-center my-auto text-white">Messi</div>
						</a>
					</div>
				</div>
				<div class="col-2 my-1">
					<div class="figuritaEncontrada border rounded border-white">
						<a href="#" class="btn">
							<img src="img/messi-god-no.jpg" alt="foto1" width="100% " class="rounded m-auto d-block">
							<div class="h4 text-center my-auto text-white">Messi</div>
						</a>
					</div>
				</div>
				<div class="col-2 my-1">
					<div class="figuritaEncontrada border rounded border-white">
						<a href="#" class="btn">
							<img src="img/messi-god-no.jpg" alt="foto1" width="100% " class="rounded m-auto d-block">
							<div class="h4 text-center my-auto text-white">Messi</div>
						</a>
					</div>
				</div>
				<div class="col-2 my-1">
					<div class="figuritaEncontrada border rounded border-white">
						<a href="#" class="btn">
							<img src="img/messi-god-no.jpg" alt="foto1" width="100% " class="rounded m-auto d-block">
							<div class="h4 text-center my-auto text-white">Messi</div>
						</a>
					</div>
				</div>
				<div class="col-2 my-1">
					<div class="figuritaEncontrada border rounded border-white">
						<a href="#" class="btn">
							<img src="img/messi-god-no.jpg" alt="foto1" width="100% " class="rounded m-auto d-block">
							<div class="h4 text-center my-auto text-white">Messi</div>
						</a>
					</div>
				</div>
				<div class="col-2 my-1">
					<div class="figuritaEncontrada border rounded border-white">
						<a href="#" class="btn">
							<img src="img/messi-god-no.jpg" alt="foto1" width="100% " class="rounded m-auto d-block">
							<div class="h4 text-center my-auto text-white">Messi</div>
						</a>
					</div>
				</div>
				<div class="col-2 my-1">
					<div class="figuritaEncontrada border rounded border-white">
						<a href="#" class="btn">
							<img src="img/messi-god-no.jpg" alt="foto1" width="100% " class="rounded m-auto d-block">
							<div class="h4 text-center my-auto text-white">Messi</div>
						</a>
					</div>
				</div>
				<div class="col-2 my-1">
					<div class="figuritaEncontrada border rounded border-white">
						<a href="#" class="btn">
							<img src="img/messi-god-no.jpg" alt="foto1" width="100% " class="rounded m-auto d-block">
							<div class="h4 text-center my-auto text-white">Messi</div>
						</a>
					</div>
				</div>

			</div>
		</div>
	</section>

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