
$(document).ready(function () {

    $(".createSubmit").click(function () {

        var income = document.getElementById("income").value;
        var size = document.getElementById("size").value;
        var monthly = document.getElementById("monthly").value;
        console.log("test");

        var parameter = JSON.stringify({income:income, size:size, monthly:monthly})


        $.post({
            method: 'POST',
            url: 'http://localhost:8080/calc',
            data: parameter,
            headers: {
                'Content-Type': 'application/json'
            }});

     /*   $.post("calc",
            {
                "income":income,
                "size": size,
                "monthly": monthly
            },
            function (data, status) {
                alert("Data: " + data + "\nStatus: " + status);
            });*/
    });
});


