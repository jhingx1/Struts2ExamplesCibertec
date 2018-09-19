$(function() {
    // INS
    $("#dins").dialog({
        modal: true,
        autoOpen: false
    });
    
    $(".crud .ins").click(function() {
        $("#dins").dialog('open');
    });
    
    // DEL
    $(".crud .del").click(function() {
        var ids = [];

        $("input[name='_del']:checked").each(function() {
            ids.push($(this).val());
        });

        if(ids.length === 0) {
            alert("Debe seleccionar fila(s) a Retirar");
        } else {
            if(confirm("¿Retirar fila(s)?")) {
                window.location = "proveedoresDel?ids="+ids.toString();
            }
        }
    });
    
    // UPD
    $("#dupd").dialog({
        modal: true,
        autoOpen: false
    });
    
    $(".crud .upd").click(function() {
        var id = $("input[name='_upd']:checked").val();

        if(isNaN(id)) {
            alert("Debe seleccionar Fila para Actualizar Datos");
        } else {
            if(confirm("¿Actualizar registro?")) {
                $.ajax({
                    url: "proveedoresGet?id="+id,
                    success: function(data) {
                        var dato = data.split("+++");
                        
                        if(dato.length === 5) {
                            $("#idproveedor").val(dato[0]);
                            $("#nombre").val(dato[1]);
                            $("#ruc").val(dato[2]);
                            $("#correo").val(dato[3]);
                            $("#telefono").val(dato[4]);
                        
                            $("#dupd").dialog('open');
                        }
                    }
                });
            }
        }
    });
    
    // botones
    $("input[type=submit]").button();
});



