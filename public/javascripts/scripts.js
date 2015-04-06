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
 * Creates an InfoBox based on the given index.
 *
 * Parameters:
 *   index    The integer equal to the index of the overlay to make the InfoBox for.
 *
 */

function createInfoBox(index) {

  // When clicked on, center the map on the overlay and display its InfoBox

}

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
                                              strokeColor: "#FF0000",
                                              strokeOpacity: 0.8,
                                              strokeWeight: 2,
                                              fillColor: "#FF0000",
                                              fillOpacity: 0.35});
    newOverlay.setMap(this.map);
    overlays.push(newOverlay);

    google.maps.event.addListener(newOverlay, 'click', function() {
      var index = overlays.indexOf(this);
      var coordinates = overlayCoordinates[index];
      var centerLatitude = 0;
      var centerLongitude = 0;

      for (var i = 0; i < coordinates.length; i++) {
        centerLatitude += coordinates[i].lat();
        centerLongitude += ctioordinates[i].lng();
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
    });
  }

}

$(document).ready(function() {
  initialize();
});