/**
 * General JavaScript code for the Reef Nexus project.
 *
 * Created by Branden Ogata on 3/23/2015.
 *
 */

/*
 * The actual overlays.
 */
var overlays = [];

/*
 * Initializes the map, making sure to save the map as a global variable for later reference.
 *
 */

function initialize() {
  this.map = new google.maps.Map(document.getElementById("map"),
      {
        zoom: 10,
        center: new google.maps.LatLng(21.477, -157.967)
      });

  // Sets up the overlays
  for (var i = 0; i < overlayCoordinates.length; i++) {
    var coordinates = overlayCoordinates[i];
    var newOverlay = new google.maps.Polygon({
      paths: coordinates,
      strokeColor: "#000000",
      strokeOpacity: 0.0,
      strokeWeight: 2,
      fillColor: "#000000",
      fillOpacity: 0.0
    });
    newOverlay.setMap(this.map);
    overlays.push(newOverlay);

    // Show the data for the region that was clicked on
    google.maps.event.addListener(newOverlay, 'click', function () {
      var index = overlays.indexOf(this);
      var overlayName = overlayNames[index];
      var totalFish = 0;

      // Clear the table of fish data
      $(".location-detail > table > tbody").html("");

      $.ajax({
        type: "GET", url: "/locationData",
        data: "name=" + overlayName.replace(" ", "_"), success: function (data) {
          var wrapper = $("<div></div>").html(data);
          var totalFishCount = 0;

          // Update the location name on the right of the page
          $(".location-detail > h4 > a").text($(wrapper).find("#location-name").text())
              .attr("href", $(wrapper).find("#location-url").text());

          // For each .fish-data
          $(wrapper).find(".fish-data").each(function () {
            // Add row to the table containing the .fish-name and .fish-count values
            var row = $("<tr>").attr("class", "fish-data");
            var fishCountColumn = $("<td>").text($(this).find(".fish-count").text())
                .attr("class", "fish-count");
            var fishNameColumn = $("<td>").text($(this).find(".fish-name").text())
                .attr("class", "fish-name");

            row.append(fishCountColumn, fishNameColumn);

            $(".location-detail > table > tbody").append(row);

            // Add value of .fish-count to totalFish
            totalFishCount += parseInt($(fishCountColumn).text());
          });

          // For each row in the table, append the percentage (in addition to the total number of fish)
          $(".location-detail > table > tbody").children().each(function () {
            var fishCountColumn = $(this).find(".fish-count").first();
            var fishCount = $(fishCountColumn).text();

            $(fishCountColumn).text(((parseInt(fishCount) * 100.0) / totalFishCount).toFixed(2) + "%");
          });
        }, error: function () {
          $(".location-detail > h4 > a").text("Location not found")
              .attr("href", "#");
        }
      });
    });
  }

}

/*
 * Focus on user's current location.
 */

function userLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(getPosition, showError);

  }
  else {
    alert("Geolocation is not supported by this browser.");
  }
}

/*
 * Obtain user's current coordinates
 */

function getPosition(position) {
  UserLatitude = position.coords.latitude;
  UserLongitude = position.coords.longitude;
  showPosition(UserLatitude, UserLongitude);
}

/*
 * Pan to user's current location.
 */

function showPosition(userLatitude, userLongitude) {
  lat = userLatitude;
  lon = userLongitude;
  latlon = new google.maps.LatLng(lat, lon);

  map.setZoom(15);
  google.maps.event.trigger(map.panTo(latlon), 'click');
}

function showError(error) {
  switch (error.code) {
    case error.PERMISSION_DENIED:
      alert("User denied the request for Geolocation.");
      break;
    case error.POSITION_UNAVAILABLE:
      alert("Location information is unavailable.")
      break;
    case error.TIMEOUT:
      alert("The request to get user location timed out.")
      break;
    case error.UNKNOWN_ERROR:
      alert("An unknown error occurred.")
      break;
  }
}

$(document).ready(function () {
  initialize();
});