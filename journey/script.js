document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("journeyForm");
    const recommendationsList = document.getElementById("recommendedPlaces");

    form.addEventListener("submit", function(event) {
        event.preventDefault();
        const currentLocation = document.getElementById("currentLocation").value;
        const finalDestination = document.getElementById("finalDestination").value;
        const transportationOptions = getSelectedTransportationOptions();
        planJourney(currentLocation, finalDestination, transportationOptions);
    });

    function getSelectedTransportationOptions() {
        const checkboxes = document.querySelectorAll('input[name="transportation"]:checked');
        const options = [];
        checkboxes.forEach(checkbox => {
            options.push(checkbox.value);
        });
        return options;
    }

    function planJourney(currentLocation, finalDestination, transportationOptions) {
        // Here you can make an AJAX request to a backend service (Java servlet) to fetch recommendations
        // For demonstration purposes, let's assume we receive recommendations as an array of strings
        const recommendations = [
            "Eiffel Tower",
            "Statue of Liberty",
            "Great Wall of China",
            "Taj Mahal",
            "Machu Picchu"
        ];

        displayRecommendations(recommendations);
    }

    function displayRecommendations(recommendations) {
        recommendationsList.innerHTML = "";
        recommendations.forEach(place => {
            const listItem = document.createElement("li");
            listItem.textContent = place;
            recommendationsList.appendChild(listItem);
        });
    }
});
