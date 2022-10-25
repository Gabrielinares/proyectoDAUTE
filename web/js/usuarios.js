/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function llenarFormulario(fila) {
    var codigo = $(fila).find(".codigo").text();
    var user = $(fila).find(".usuario").text();
    var contra = $(fila).find(".contra").text();
    var estado = $(fila).find(".estado").text();

    $("#txtCodigo").val(codigo);
    $("#txtUser").val(user);
    $("#txtPass").val(contra);
    $("#txtEstado option[selected]").removeAttr('selected');
    $("#txtEstado option:contains("+estado+")").attr('selected', true);

}


$(document).ready(function(){
    
    $("#exampleModal").on("hidden.bs.modal", function () {
        $('#form')[0].reset();

    });
    
    $(document).on('click', '.btnEditar', function(){
        llenarFormulario($(this).closest('tr'));
        $('.btnOcultar1').attr('disabled', 'disabled');
        $('.btnOcultar').removeAttr('disabled');
    });
    $(document).on('click', '.btnEliminar', function(){
        llenarFormulario($(this).closest('tr'));
        $('.btnOcultar1').attr('disabled', 'disabled');
        $('.btnOcultar').removeAttr('disabled');
    });
    $(document).on('click', '.btnAdd', function(){
        $('.btnOcultar').attr('disabled', 'disabled');
        $('.btnOcultar1').removeAttr('disabled');
    });
});