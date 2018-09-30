$(function() {
    // INS
    $("#dins").dialog({
        modal: true,
        autoOpen: false,
        width: 360
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
                window.location = "tiemposDel?ids="+ids.toString();
            }
        }
    });
    
    // UPD
    $("#dupd").dialog({
        modal: true,
        autoOpen: false,
        width: 360
    });
    
    $(".crud .upd").click(function() {
        var id = $("input[name='_upd']:checked").val();
 
        if(isNaN(id)) {
            alert("Debe seleccionar Fila para Actualizar Datos");
        } else {
            if(confirm("¿Actualizar registro?")) {
                $.ajax({
                    url: "tiemposGet?id="+id,
                    success: function(data) {
                        var dato = data.split("+++");
                   
                        if(dato.length === 4) {
                            $("#idtiempo").val(dato[0]);
                            $("#fechax").val(dato[1]);
                            $("#horax").val(dato[2]);
                            $("#fechahorax").val(dato[3]);
                        
                            $("#dupd").dialog('open');
                        }
                    }
                });
            }
        }
    });
    
    // botones
    $("input[type=submit]").button();
    
    // datepicker
    $(".fecha").datepicker({
        showOn: "button",
        buttonImage: "images/calendar.gif",
        buttonImageOnly: true
    });
                
    $(".fecha").datepicker('setDate', new Date());
    //
                
    $.timepicker.regional['es'] = {
        timeOnlyTitle: 'Seleccione Hora',
        timeText: 'Selección',
        hourText: 'Hora',
        minuteText: 'Minutos',
        secondText: 'Segundos',
        currentText: 'Ahora',
        closeText: 'Aceptar',
        ampm: false
    };

    $.timepicker.setDefaults($.timepicker.regional['es']);
    $(".fechahora").datetimepicker({
        showOn: 'button',
        buttonImage: 'images/calendar.gif',
        buttonImageOnly: true,
        showAnim: 'slideDown',
        showSecond: true,
        yearRange: '2012:2018',
        changeMonth: true,
        changeYear: true,
        timeFormat: 'hh:mm:ss tt',
        hour: 8,
        minute: 30,
        second: 30,
        hourMin: 1,
        hourMax: 23,
        stepHour: 1,
        stepMinute: 1,
        stepSecond: 1,
        addSliderAccess: true, 
        sliderAccessArgs: {
            touchonly: false
        }
    });
    
    $(".fechahora").datetimepicker('setDate', new Date());
    //
    
    $(".hora").timepicker({
        showOn: 'button',
        buttonImage: 'images/clock.png',
        buttonImageOnly: true,
        showAnim: 'slideDown',
        showSecond: true,
        controlType: 'select',
	timeFormat: 'hh:mm:ss tt'
    });
    
    $(".hora").timepicker('setDate', new Date());
});


