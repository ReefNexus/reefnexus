/**
 * General JavaScript code for the Reef Nexus project.
 *
 * Created by Branden Ogata on 3/23/2015.
 *
 */

/*
 * The overlay coordinates.
 */
var overlayCoordinates = [
  [new google.maps.LatLng(21.27242,-157.85048),
    new google.maps.LatLng(21.28667,-157.87744),
    new google.maps.LatLng(21.30733,-157.85931),
    new google.maps.LatLng(21.29588,-157.83243)],
  [new google.maps.LatLng(21.27242,-157.85048),
    new google.maps.LatLng(21.25439,-157.82759),
    new google.maps.LatLng(21.26882,-157.81185),
    new google.maps.LatLng(21.29588,-157.83243)],
  [new google.maps.LatLng(21.24642,-157.79096),
    new google.maps.LatLng(21.25439,-157.82759),
    new google.maps.LatLng(21.26882,-157.81185),
    new google.maps.LatLng(21.26177,-157.79286)],
  [new google.maps.LatLng(21.24642,-157.79096),
    new google.maps.LatLng(21.26191,-157.75283),
    new google.maps.LatLng(21.28334,-157.75988),
    new google.maps.LatLng(21.26177,-157.79286)],
  [new google.maps.LatLng(21.25402,-157.70281),
    new google.maps.LatLng(21.26191,-157.75283),
    new google.maps.LatLng(21.28334,-157.75988),
    new google.maps.LatLng(21.29272,-157.70162)],
  [new google.maps.LatLng(21.25402,-157.70281),
    new google.maps.LatLng(21.26479,-157.68108),
    new google.maps.LatLng(21.27934,-157.69096),
    new google.maps.LatLng(21.29272,-157.70162)],
  [new google.maps.LatLng(21.27634,-157.66942),
    new google.maps.LatLng(21.26479,-157.68108),
    new google.maps.LatLng(21.27934,-157.69096),
    new google.maps.LatLng(21.28896,-157.68042)],
  [new google.maps.LatLng(21.27634,-157.66942),
    new google.maps.LatLng(21.29292,-157.64739),
    new google.maps.LatLng(21.30205,-157.65626),
    new google.maps.LatLng(21.28896,-157.68042)],
  [new google.maps.LatLng(21.31121,-157.6326),
    new google.maps.LatLng(21.29292,-157.64739),
    new google.maps.LatLng(21.31798,-157.68034),
    new google.maps.LatLng(21.33973,-157.66248)],
  [new google.maps.LatLng(21.38276,-157.69225),
    new google.maps.LatLng(21.36008,-157.7346),
    new google.maps.LatLng(21.31798,-157.68034),
    new google.maps.LatLng(21.33973,-157.66248)],
  [new google.maps.LatLng(21.38276,-157.69225),
    new google.maps.LatLng(21.36008,-157.7346),
    new google.maps.LatLng(21.38577,-157.74299),
    new google.maps.LatLng(21.40504,-157.69956)],
  [new google.maps.LatLng(21.44508,-157.70942),
    new google.maps.LatLng(21.42338,-157.75313),
    new google.maps.LatLng(21.38577,-157.74299),
    new google.maps.LatLng(21.40504,-157.69956)],
  [new google.maps.LatLng(21.44508,-157.70942),
    new google.maps.LatLng(21.42322,-157.75331),
    new google.maps.LatLng(21.45105,-157.79424),
    new google.maps.LatLng(21.48828,-157.71758)],
  [new google.maps.LatLng(21.39203,-157.78598),
    new google.maps.LatLng(21.42322,-157.75331),
    new google.maps.LatLng(21.45105,-157.79424),
    new google.maps.LatLng(21.43907,-157.83328)],
  [new google.maps.LatLng(21.52303,-157.87035),
    new google.maps.LatLng(21.5447,-157.81613),
    new google.maps.LatLng(21.45105,-157.79424),
    new google.maps.LatLng(21.43907,-157.83328)],
];

/*
 * The overlay names.
 */
var overlayNames = [
  "Kaka'ako to Ala Moana",
    "Waikiki",
    "Diamond Head",
    "Kahala",
    "Maunalua Bay",
    "Haunama Bay",
    "Koko Head",
    "Sandy to Kaloko",
    "Makapu'u",
    "Waimanalo Bay",
    "Lanikai",
    "Kailua Bay",
    "MCBH",
    "South Kaneohe Bay",
    "North Kaneohe Bay"
];

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
      strokeOpacity: 0.8,
      strokeWeight: 2,
      fillColor: "#000000",
      fillOpacity: 0.35
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
        $(wrapper).find(".fish-data").each(function()
        {
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

          $(fishCountColumn).text(fishCount + " (" + ((parseInt(fishCount) * 100.0) / totalFishCount).toFixed(2) + "%)");
        });
      }, error: function() {
        $(".location-detail > h4 > a").text("Location not found")
                                      .attr("href", "#");
      }});
    });
  }

}

$(document).ready(function () {
  initialize();
});