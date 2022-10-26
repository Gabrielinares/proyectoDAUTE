/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/* global emp, proy */

function llenarFormulario(fila) {
    var dui = $(fila).find(".id").text();
    var fechaI = $(fila).find(".fechaI").text();
    var fechaF = $(fila).find(".fechaF").text();
    var proy = $(fila).find(".proy").text();
    var emp = $(fila).find(".emp").text();
    

    $("#txtCodigo").val(dui);
    $("#txtFechaI").val(fechaI);
    $("#txtFechaF").val(fechaF);
    $("#txtEmp option[selected]").removeAttr('selected');
    $("#txtEmp option:contains(" + emp + ")").attr('selected', true);

    $("#txtProy option[selected]").removeAttr('selected');
    $("#txtProy option:contains(" + proy + ")").attr('selected', true);
}

$(document).ready(function () {

    $("#exampleModal").on("hidden.bs.modal", function () {
        $('#form')[0].reset();
        $("#txtProy option[selected]").removeAttr('selected');
        $("#txtEmp option[selected]").removeAttr('selected');

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
