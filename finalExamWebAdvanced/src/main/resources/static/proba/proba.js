$(document).ready(function () {
    $('#town').change(function () {
        var  tid=$('#town').val();

        $.ajax({
            url: 'data.php',
            method: 'post',
            data: 'tid=' + tid
        }).done(function (office) {
            console.log(office);

        })

    })

})