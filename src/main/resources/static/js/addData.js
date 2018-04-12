
$(document).ready(function () {

    $(".createSubmit").click(function () {

        var income = document.getElementById("income").value;
        var size = document.getElementById("size").value;
        var monthly = document.getElementById("monthly").value;

        var parameter = JSON.stringify({income:income, size:size, monthly:monthly})
        $( ".masthead" ).removeClass( "masthead-deactive" );

        $.post({
            method: 'POST',
            url: 'http://localhost:8080/calc',
            data: parameter,
            headers: {
                'Content-Type': 'application/json'
            }});

    });


    $( "#pension-nav" ).click(function() {
        $( "pension-nav" ).addClass("caption");
        $( "#text-heading" ).text("caption");
        $( "#text-content" ).text("active");

    });

    $( "#dreams-nav" ).click(function() {
        $( "#text-heading" ).addClass("caption2");
        $( "#text-content" ).text("text2");

    });

    $( "#lifestyle-nav" ).click(function() {
        $( "#text-heading" ).addClass("caption3");
        $( "#text-content" ).text("text3");

    });

    $( ".testclass" ).click(function() {
        $( "#text-content" ).text("text3");

    });


    $( ".testclass" ).click(function() {
        $( ".masthead" ).removeClass( "masthead-deactive" );

    });
});


