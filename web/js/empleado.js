/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function llenarFormulario(fila) {
    var dui = $(fila).find(".dui").text();
    var nombre = $(fila).find(".NombreEmp").text();
    var apellido = $(fila).find(".ApellidoEmp").text();
    var disponibilidad = $(fila).find(".Disp").text();
    var salario = $(fila).find(".Salario").text();
    var telefono = $(fila).find(".Telefono").text();


    $("#txtDui").val(dui);
    $("#txtNom").val(nombre);
    $("#txtApe").val(apellido);
    $("#txtDisp option[selected]").removeAttr('selected');
    $("#txtDisp option:contains(" + disponibilidad + ")").attr('selected', true);
    $("#txtSal").val(salario);
    $("#txtTel").val(telefono);

console.log(disponibilidad);

}


$(document).ready(function () {

    $("#exampleModal").on("hidden.bs.modal", function () {
        $('#form')[0].reset();
        $("#txtDisp option[selected]").removeAttr('selected');

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
