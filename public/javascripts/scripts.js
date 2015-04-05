/**
 * General JavaScript code for the Reef Nexus project.
 *
 * Created by Branden Ogata on 3/23/2015.
 *
 */

/*
 * Initializes the map, making sure to save the map as a global variable for later reference.
 *
 */

function initialize()
{
  this.map = new google.maps.Map(document.getElementById("map"),
      {zoom: 10,
        center: new google.maps.LatLng(21.477, -157.967)});
}

$(document).ready(function() {
  initialize();
});