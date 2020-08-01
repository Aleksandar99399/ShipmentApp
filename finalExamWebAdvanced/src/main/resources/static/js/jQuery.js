
function towns() {

    //const url = "http://localhost:8000/shipments/add?offices=";

    $(function () {
            $('#town').on('change', function (e) {
                let townSel = $("#town :selected").val();
                $.ajax({
                    url: "/shipments/add",
                    type: "GET",
                    data:{ town:townSel},
                    success: function (data) {
                        $('#office').html(data)

                    }

                })
            });
            // $('#town').on('each', function (e) {
            //
            // });


            function getOffices() {

                // $(document).ready(function () {
                //     var option = document.getElementById("office").options;
                //     if (document.getElementById('town').value === document.getElementById($('#office').town)) {
                //         $("#status").append('<option>OPEN</option>');
                //         $("#status").append('<option>DELIVERED</option>');
                //     }

                // $('#town').each(function () {
                //     if ($('#town').val()!==$('#office').town){
                //         $("#office option").not("[value^='basic']").hide();
                //     }else {
                //         $("#office option").not("[value^='basic']").show()
                //     }
                //
                // })

                // $('#town').on('change', function() {
                //     var val = this.value;
                //     $('#office option').hide().filter(function() {
                //         return this.value.indexOf( val + '_' ) === 0;
                //     })
                //         .show();
                // })
                //     .change();



                // $("#town").change(function () {
          //      //     if ($(this).data('options') === undefined) {
                //
                //         $(this).data('options', $('#office option').clone());
                //     }
                //     var id = $(this).val();
                //     var options = $(this).data('options').filter('[value=' + id + ']');
                //
                //     $('#office').html(options).text();
                // });



                // var office = $("#office");
                //
                //  var town = $("#town :selected").val();
                //
                // $("#town").change(function() {
                //     if($('#office').office ){
                //         var id = $(this).val();
                //         var options = $(this).data('options').filter('[value=' + id + ']');
                //     } else {
                //         $("#office[value=" + town + "]").hide();
                //     }
                //
                // });

            }

            // function getOfficesRec() {
            //     $("#townRec").change(function () {
            //         if ($(this).data('options') === undefined) {
            //             /*Taking an array of all options-2 and kind of embedding it on the select1*/
            //             $(this).data('options', $('#officeRec option').clone());
            //         }
            //         var id = $(this).val();
            //         var options = $(this).data('options').filter('[value=' + id + ']');
            //
            //         $('#officeRec').html(options);
            //     });
            //
            // }
        }
        // fetch(url)
        //     .then(res => {
        //         return res.text();
        //     })
        //     .then(data => {
        //         $('#office').html(data);
        //     });
        //
        // }
    );


}

// $.ajax({
//     url: "~/shipments/addShipment",
//     type: "get",
//     data: {townContr: offices()},
//     success: function (result) {
//         jQuery('.alert').html(result.success());
//
//     }
// });


//Dropdown

function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

window.onclick = function (event) {
    if (!event.target.matches('.dropbtn')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
};



