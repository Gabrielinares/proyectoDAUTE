/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/* global emp, proy */

function llenarFormulario(fila) {
    var dui = $(fila).find(".dui").text();
    var fechaI = $(fila).find(".fechaI").text();
    var fechaF = $(fila).find(".fechaF").text();
    var Emp = $(fila).find(".TxtEmp").text();
    var proyId = $(fila).find(".proy").text();
    

    console.log(emp);
    console.log(proyId);

    $("#txtDui").val(dui);
    $("#txtFechaI").val(fechaI);
    $("#txtFechaF").val(fechaF);
    $("#txtEmp option[selected]").removeAttr('selected');
    $("#txtEmp option:contains(" + emp + ")").attr('selected', true);

    $("#txtproy option[selected]").removeAttr('selected');
    $("#txtproy option:contains(" + proy + ")").attr('selected', true);
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
        //llenarFormulario($(this).closest('tr'));
        $('.btnOcultar1').attr('disabled', 'disabled');
        $('.btnOcultar').removeAttr('disabled');
    });
    $(document).on('click', '.btnAdd', function () {
        $('.btnOcultar').attr('disabled', 'disabled');
        $('.btnOcultar1').removeAttr('disabled');
    });
});
