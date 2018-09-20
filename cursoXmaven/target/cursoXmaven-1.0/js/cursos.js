$(function () {
    if ($.trim($(".msg_error").text()) !== "") {
        $(".msg_error").css("visibility", "visible");
    }
    
    // datepicker
    $(".fecha").datepicker({
        showOn: "button",
        buttonImage: "images/calendar.gif",
        buttonImageOnly: true
    });
    
    $(".fecha").datepicker('setDate', new Date());
    
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

function profesoresQry() {
    window.location = "profesoresQry";
}

function cursosIns() {
    //window.location = "frasesInsForm";
    window.location = "cursosInsForm";
}

function frasesDel() {
    var ids = [];

    $("input[name='idfrase_del']:checked").each(function () {
        ids.push($(this).val());
    });

    if (ids.length === 0) {
        message("Advertencia", "Seleccione fila(s) a Retirar");
    } else {
        $("#message").html("¿Retirar registro(s)?");
        $("#dlg_message").dialog({
            modal: true,
            title: "Advertencia",
            width: 340,
            buttons: {
                "No": function () {
                    $(this).dialog("close");
                },
                "Si": function () {
                    $(this).dialog("close");
                    window.location = "frasesDel?ids=" + ids.toString();
                }
            }
        });
    }
}

function frasesUpd() {
    var id = $("input[name='idfrase_upd']:checked").val();

    if (isNaN(id)) {
        message("Advertencia", "Seleccione Fila para Actualizar Datos");
    } else {
        window.location = "frasesGet?idfrase=" + id;
    }
}


