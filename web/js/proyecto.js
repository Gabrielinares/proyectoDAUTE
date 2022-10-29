/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function llenarFormulario(fila) {
    var codigo = $(fila).find(".id").text();
    var nombre = $(fila).find(".nombre").text();
    var costo = $(fila).find(".costo").text();
    var estado = $(fila).find(".estado").text();
    var muni = $(fila).find(".muni").text();
    var depto = $(fila).find(".depto").text();


    $("#txtCodigo").val(codigo);
    $("#txtNombre").val(nombre);
    $("#txtCosto").val(costo);

    $("#txtEstado option[selected]").removeAttr('selected');
    $("#txtEstado option:contains(" + estado + ")").attr('selected', true);
    $("#txtMuni option[selected]").removeAttr('selected');
    $("#txtMuni option:contains(" + muni + ")").attr('selected', true);

}

function llenarCancel(fila){
    var codigo = $(fila).find(".id").text();
    $("#txtCodigoC").val(codigo);
    console.log(codigo);
}

$(document).ready(function () {

    $("#exampleModal").on("hidden.bs.modal", function () {
        $('#form')[0].reset();
        $("#txtMuni option[selected]").removeAttr('selected');

    });

    $(document).on('click', '.btnEditar', function () {
        llenarFormulario($(this).closest('tr'));
        $('.btnOcultar1').attr('disabled', 'disabled');
        $('.btnOcultar').removeAttr('disabled');
    });
    $(document).on('click', '.btnEliminar', function () {
        llenarFormulario($(this).closest('tr'));
        $('.btnOcultar1').attr('disabled', 'disabled');
        $('.btnOcultar').removeAttr('disabled');
    });
    $(document).on('click', '.btnAdd', function () {
        $('.btnOcultar').attr('disabled', 'disabled');
        $('.btnOcultar1').removeAttr('disabled');
    });
    
    $(document).on('click', '.btnCancelar', function () {
        llenarCancel($(this).closest('tr'));
        $('.btnOcultar').attr('disabled', 'disabled');
        $('.btnOcultar1').removeAttr('disabled');
    });
});
