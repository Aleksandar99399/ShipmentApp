const offices = new Map([
    /*[# th:each="city : ${cities}"]*/
    ['[(${town.id})]', [
        /*[# th:each="office : ${city.offices}"]*/
        {id: '[(${office.id})]', name: '[(${office.name})]'},
        /*[/]*/
    ]
    ],
    /*[/]*/
]);

$(document).ready(function () {
    $('#town').change(function () {
        //clean up the options
        $('#office > option').each(function () {
            if ($(this).val()) {
                $(this).remove();
            }
        });
        //get the city id and fill in offices
        let cityId = $(this).val();
        if (cityId) {
            let options = ''
            offices.get(cityId).forEach(function(value, idx) {
                options += '<option value="'+value.id+'">'+value.name+'</option>';
            })
            $('#office').append(options)
        }
    });
});


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