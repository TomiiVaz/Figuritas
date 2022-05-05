$(document).ready(function() {
    
    $("#form").submit(function() {
        return validar();
    });

    $("#nombre").keyup(function() {
        validar();
    });

    $("#nickname").keyup(function() {
        validar();
    });

    $("#pais").change(function() {
        validar();
    });

    $("#club").change(function() {
        validar();
    });

    $("#mail").keyup(function() {
        validar();
    });

    $("#telefono").keyup(function() {
        validar();
    });

    $("#clave").keyup(function() {
        validar();
    });

    $("#clave2").keyup(function() {
        validar();
    });

 })
 
 function validar(){

    var regexemail = /^[0-9a-zA-Z._.-]+\@[0-9a-zA-Z._.-]+\.[0-9a-zA-Z]+$/; 
    var mensaje =""; 
    var error =0;

    reset();

    // validacion de nombre
    if ($("#nombre").val()==""){ /*valida que nombre no este vacio*/
        mensaje+= "<p>El campo nombre es obligatorio </p>";
        error++;
        $("#nombre").addClass('error');
    }

    // validacion de nickname
    if($("#nickname").val().length < 5){
        mensaje+= "<p>El campo nickname debe tener al menos 4 caracteres </p>";
        error++;
        $("#nickname").addClass('error');
    }

    // validacion de pais
    if ($("#pais option:selected").val()==0){
        mensaje+= "<p>Debe Seleccionar un pais</p>";
        error++;
        $("#pais").addClass('error');
    }

    // validacion de club
    if ($("#club option:selected").val()==0){
        mensaje+= "<p>Debe Seleccionar un club</p>";
        error++;
        $("#club").addClass('error');
    }

    // validacion de mail
    if(!$("#mail").val().match(regexemail)){
        mensaje+= "<p>Debe ser un email valido</p>";
        error++;
        $("#mail").addClass('error');
    }

    // validacion de telefono
    if($("#telefono").val().length != 10){
        mensaje+= "<p>El campo telefono debe tener 10 caracteres </p>";
        error++;
        $("#telefono").addClass('error');
    }

    // validacion de clave
    if($("#clave").val().length < 8){
        mensaje+= "<p>La contraseña debe tener al menos 8 caracteres</p>";
        error++;
        $("#clave").addClass('error');
    }

    // validacion de clave2
    if($("#clave2").val() != $("#clave").val()){
        mensaje+= "<p>Las claves deben ser iguales</p>"
        error++;
        $("#clave2").addClass('error');
    }

     /*Si error es mayor a 0 retorna falso y muestra todo los mensajes de errores acumulado en la variable mensaje*/
     if (error>0){
        
        $("#mensaje").append(mensaje); //agregamos al div de id mensaje, los mensajes de error acumulados en la variable mensaje
        return false;
    }
    /*Sino retorna verdadero y el formulario se envía*/
    else{
        return true;
    }
 }


 function reset(){ /*Esta funciona elimina todas las clases de error*/
    $("#nombre").removeClass('error');
    $("#apellido").removeClass('error');
    $("#provincia").removeClass('error');
    $("#email").removeClass('error');
    $("#mensaje").empty(); //vaciamos el contenido del div de id mensaje
}
