
$(document).ready(function () {

    $(".createSubmit").click(function () {

        var income = document.getElementById("income").value;
        var size = document.getElementById("size").value;
        var monthly = document.getElementById("monthly").value;
        console.log("test");


        $http({
            method: 'POST',
            url: 'http://localhost:8080/service/v1/saveWork',
            data: postData,
            headers: {
                'Content-Type': 'application/json'
            }});



        $.post("/calc",
            {
                "income":income,
                "size": size,
                "monthly": monthly
            },
            function (data, status) {
                alert("Data: " + data + "\nStatus: " + status);
            });
    });
});


