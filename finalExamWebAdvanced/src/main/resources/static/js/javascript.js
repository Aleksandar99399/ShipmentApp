function init() {

    $(function() {
    $('#town').on('change', function (e) {
        $.ajax({
            url: "/shipments/add?town=" + $("#town :selected").text(),
            type: "GET",
            success : getOffices

        })
    });

    function getOffices() {
        $("#town").change(function() {
            if ($(this).data('options') === undefined) {
                /*Taking an array of all options-2 and kind of embedding it on the select1*/
                $(this).data('options', $('#office option').clone());
            }
            var id = $(this).val();
            var options = $(this).data('options').filter('[value=' + id + ']');
            $('#office').html(options);
        });


        // var office = $("#office");
        //
        // var town = $("#town :selected").val();
        //
        // $('#office > option#officeName').each(function() {
        //     if($("#officeName").val()===town){
        //         $("#officeName[value=" + town + "]").show();
        //     } else {
        //         $("#officeName[value=" + town + "]").hide();
        //     }
        //
        // });
    }});

}
