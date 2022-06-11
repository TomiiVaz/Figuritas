
let contador = 0;

$(function () {


    $("#foto1").on('click', function () {

        if(!(contador >0)){
            $("#foto1").hide();
            $("#foto11").removeClass("visually-hidden");
            $("#foto111").removeClass("visually-hidden");

            contador++;

            $("#premio").append("<p>Ganaste</p>");
        }


    });

    $("#foto2").on('click', function () {

        if(!(contador >0)){
            $("#foto2").hide();
            $("#foto22").removeClass("visually-hidden");
            $("#foto222").removeClass("visually-hidden");

            contador++;

            $("#premio").append("<p>Ganaste</p>");
        }

    });

    $("#foto3").on('click', function () {

        if(!(contador >0)){
            $("#foto3").hide();
            $("#foto33").removeClass("visually-hidden");
            $("#foto333").removeClass("visually-hidden");
            contador++;

            $("#premio").append("<p>Ganaste</p>");
        }
    });


});