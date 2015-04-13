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
  [new google.maps.LatLng(21.281866, -157.846104),
   new google.maps.LatLng(21.271783, -157.846104),
   new google.maps.LatLng(21.271783, -157.823311),
   new google.maps.LatLng(21.281866, -157.823311)],
  [new google.maps.LatLng(21.271783, -157.823311),
   new google.maps.LatLng(21.271783, -157.822216),
   new google.maps.LatLng(21.265099, -157.822216),
   new google.maps.LatLng(21.265099, -157.823311)],
  [new google.maps.LatLng(21.274787, -157.825805),
   new google.maps.LatLng(21.274787, -157.821755),
   new google.maps.LatLng(21.262355, -157.821755),
   new google.maps.LatLng(21.262355, -157.825805)],
  [new google.maps.LatLng(21.260995, -157.821358),
   new google.maps.LatLng(21.260995, -157.818584),
   new google.maps.LatLng(21.257675, -157.818584),
   new google.maps.LatLng(21.257675, -157.821358)],
  [new google.maps.LatLng(21.257605, -157.818386),
   new google.maps.LatLng(21.257605, -157.816010),
   new google.maps.LatLng(21.256645, -157.816010),
   new google.maps.LatLng(21.256645, -157.818386)],
  [new google.maps.LatLng(21.256655, -157.815961),
   new google.maps.LatLng(21.256655, -157.814486),
   new google.maps.LatLng(21.256000, -157.814486),
   new google.maps.LatLng(21.256000, -157.815961)],
  [new google.maps.LatLng(21.255263, -157.809417),
   new google.maps.LatLng(21.255263, -157.803344),
   new google.maps.LatLng(21.255903, -157.803344),
   new google.maps.LatLng(21.255903, -157.809417)],
  [new google.maps.LatLng(21.256983, -157.798168),
   new google.maps.LatLng(21.256983, -157.795410),
   new google.maps.LatLng(21.256683, -157.795410),
   new google.maps.LatLng(21.256683, -157.798168)]
];

/*
 * The overlay names.
 */
var overlayNames = [
  "Waikiki Beach",
  "Queen Beach",
  "Sans Souci Beach",
  "Kaluahole Beach",
  "Makalei Beach",
  "Leahi Beach",
  "Diamond Head Beach",
  "Cromwells"
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
      {zoom: 10,
        center: new google.maps.LatLng(21.477, -157.967)});

  // Sets up the overlays
  for (var i = 0; i < overlayCoordinates.length; i++) {
    var coordinates = overlayCoordinates[i];
    var newOverlay = new google.maps.Polygon({paths: coordinates,
                                              strokeColor: "#000000",
                                              strokeOpacity: 0.8,
                                              strokeWeight: 2,
                                              fillColor: "#000000",
                                              fillOpacity: 0.35});
    newOverlay.setMap(this.map);
    overlays.push(newOverlay);

    // Show the data for the region that was clicked on
    google.maps.event.addListener(newOverlay, 'click', function() {
      var index = overlays.indexOf(this);
      var overlayName = overlayNames[index];
      var totalFish = 0;


      // Clear the table of fish data
      $(".location-detail > table > tbody").html("");

      $.ajax({type: "GET", url: "/locationData",
              data: "name=" + overlayName.replace(" ", "_"), success: function(data) {
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
        $(".location-detail > table > tbody").children().each(function() {
          var fishCountColumn = $(this).find(".fish-count").first();
          var fishCount = $(fishCountColumn).text();

          $(fishCountColumn).text(fishCount + " (" + ((parseInt(fishCount) * 100.0) / totalFishCount).toFixed(2) + "%)");
        });
      }, error: function() {
        $(".location-detail > h4 > a").text("Location not found")
                                      .attr("href", "#");
      }});

      // Below is the previous solution that created an InfoBox
/*
      var coordinates = overlayCoordinates[index];
      var centerLatitude = 0;
      var centerLongitude = 0;

      for (var i = 0; i < coordinates.length; i++) {
        centerLatitude += coordinates[i].lat();
        centerLongitude += coordinates[i].lng();
      }

      centerLatitude /= coordinates.length;
      centerLongitude /= coordinates.length;

      var marker = new google.maps.Marker({position: new google.maps.LatLng(centerLatitude, centerLongitude),
                                           map: this.map});
      marker.setMap(null);

      var overlayName = overlayNames[index];

      var infoBox = new InfoBox({content: "<span>" + overlayName + "</span>",
                                 disableAutoPan: false,
                                 pixelOffset: new google.maps.Size(-140, 0),
                                 zIndex: null,
                                 boxStyle: {background: "#FFFFFF",
                                            color: "#000000",
                                            opacity: 0.90},
                                 closeBoxMargin: "2px 2px 2px 2px",
                                 closeBoxURL: "http://www.google.com/intl/en_us/mapfiles/close.gif",
                                 infoBoxClearance: new google.maps.Size(1, 1),
                                 isHidden: false,
                                 pane: "floatPane",
                                 enableEventPropagation: false});

      infoBox.open(this.map, marker);
*/
    });
  }

}

$(document).ready(function() {
  initialize();
});