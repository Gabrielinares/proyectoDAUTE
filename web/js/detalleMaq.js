/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function llenarFormulario(fila) {
    var codigo = $(fila).find(".codigo").text();
    var fechaI = $(fila).find(".fechaI").text();
    var fechaF = $(fila).find(".fechaF").text();
    var proyId = $(fila).find(".proy").text();
    var maqId = $(fila).find(".maquinaria").text();

    console.log(maqId);
    console.log(proyId);

    $("#txtCodigo").val(codigo);
    $("#txtFechaI").val(fechaI);
    $("#txtFechaF").val(fechaF);
    $("#txtProy option[selected]").removeAttr('selected');
    $("#txtProy option:contains(" + proyId + ")").attr('selected', true);

    $("#txtMaq option[selected]").removeAttr('selected');
    $("#txtMaq option:contains(" + maqId + ")").attr('selected', true);
}

$(document).ready(function () {

    $("#exampleModal").on("hidden.bs.modal", function () {
        $('#form')[0].reset();
        $("#txtProy option[selected]").removeAttr('selected');
        $("#txtMaq option[selected]").removeAttr('selected');

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
});