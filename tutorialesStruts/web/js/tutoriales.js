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
                window.location = "tutorialesDel?ids="+ids.toString();
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
                    url: "tutorialesGet?id="+id,
                    success: function(data) {
                        var dato = data.split("+++");
                        
                        if(dato.length === 4) {
                            $("#idtutorial").val(dato[0]);
                            $("#titulo").val(dato[1]);
                            $("#tipo").val(dato[2]);
                            $("#precio").val(dato[3]);
                        
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



