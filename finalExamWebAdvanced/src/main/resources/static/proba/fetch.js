function init() {

    $('#town').change(() => {

        let town = $(this).data('town');
        console.log("Town is " + town);

        $('.office-container').empty();
        $('.town-container').empty();

        fetch('http://localhost:8080/shipments/add' + town.val()) // Fetch the data (GET request)
            .then((response) => response.json()) // Extract the JSON from the Response
            .then((json) => json.forEach((office, idx,town) => { // Render the JSON data to the HTML

                let tableRow =
                    '<select>'+
                    '<option/' + town + '>' +
                    '<select>';

                $('.town-container').append(tableRow);
            }));
    });
}

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