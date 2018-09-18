$(function() {
    // INS
    //Lllama al modal
    $("#dins").dialog({
        modal: true,
        autoOpen: false,
        width: 360
    });
    
    //ejecuta esta funcion, para llamar al modal
    $(".crud .ins").click(function() {
        $("#dins").dialog('open');
    });
    
    // DEL
    $(".crud .del").click(function() {
        var ids = [];  ///Creamos un array para el borrdo multiple
        //each:recorre todos los ck que tengan ese name
        $("input[name='_del']:checked").each(function() {
            //vamos añadiendo en el array ids.
            ids.push($(this).val());
        });
        //verificamos si no ha seleccionado nada
        if(ids.length === 0) {
            alert("Debe seleccionar fila(s) a Retirar");
        } else {
            //mostramos el mensaje
            if(confirm("¿Retirar fila(s)?")) {
                //nos dirigimos hacia el strust.xml con tiempoDel y el parametro ids(identificados)
                //ids: lo pasamos a string, nos devuelve un string asi : 1,2,3
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
        //Para verificar si un boton esta ckekeados.
        var id = $("input[name='_upd']:checked").val();//es 1: ck o:no
 
        if(isNaN(id)) {
            //Si no selcciono nada
            alert("Debe seleccionar Fila para Actualizar Datos");
        } else {
            //confirmacion
            if(confirm("¿Actualizar registro?")) {
                //Uso de ajax
                $.ajax({
                    url: "tiemposGet?id="+id, //Ruta para donde va struts.xml
                    success: function(data) {
                        //recibiendo los datos que esta serados por "+++"
                        //asi que aqui lo separaremos
                        var dato = data.split("+++");
                        //verificando si tenemos 4 datos.
                        if(dato.length === 4) {
                            //mediante jq asignamos los datos correspondientes.
                            $("#idtiempo").val(dato[0]);
                            $("#fechax").val(dato[1]);
                            $("#horax").val(dato[2]);
                            $("#fechahorax").val(dato[3]);
                            //mostrando la venta para actualizar.
                            $("#dupd").dialog('open');
                        }
                    }
                });
            }
        }
    });
    
    // botones,para darle la propiedad botton al sumit
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


