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
        zoom: 11,
        center: new google.maps.LatLng(21.477, -157.967),
        disableDefaultUI: true
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
          $(".location-header > h4 > a").text($(wrapper).find("#location-name").text());

          $(".location-detail > h4 > a").text("Click here to view more detail...")
              .attr("href", $(wrapper).find("#location-url").text());

          // Counter to limit loop to ten entries
          var loopNum = 10;

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

            loopNum = loopNum - 1;

            if(loopNum == 0){
              return false;
            }

          });

          // For each row in the table, append the percentage (in addition to the total number of fish)
          $(".location-detail > table > tbody").children().each(function () {
            var fishCountColumn = $(this).find(".fish-count").first();
            var fishCount = $(fishCountColumn).text();

            $(fishCountColumn).text(((parseInt(fishCount) * 100.0) / totalFishCount).toFixed(2) + "%");
          });

          // Now sort by percentage
          sortFishResults();

          // Convert percentage to fish rating skill (up to max of five "fishes").
          $(".location-detail > table > tbody").children().each(function () {

            var fishPercent = parseFloat($(this).find(".fish-count").first().text());

            if(fishPercent > 90){
              $(this).find(".fish-count").first().html("<img src='/assets/images/fishrating/tenrating.png'>");}
            else if (fishPercent > 70) {
              $(this).find(".fish-count").first().html("<img src='/assets/images/fishrating/ninerating.png'>");}
            else if (fishPercent > 50) {
              $(this).find(".fish-count").first().html("<img src='/assets/images/fishrating/eightrating.png'>");}
            else if (fishPercent > 40) {
              $(this).find(".fish-count").first().html("<img src='/assets/images/fishrating/sevenrating.png'>");}
            else if (fishPercent > 30) {
              $(this).find(".fish-count").first().html("<img src='/assets/images/fishrating/sixrating.png'>");}
            else if (fishPercent > 20) {
              $(this).find(".fish-count").first().html("<img src='/assets/images/fishrating/fiverating.png'>");}
            else if (fishPercent > 10) {
              $(this).find(".fish-count").first().html("<img src='/assets/images/fishrating/fourrating.png'>");}
            else if (fishPercent > 5) {
              $(this).find(".fish-count").first().html("<img src='/assets/images/fishrating/threerating.png'>");}
            else if (fishPercent > 1) {
              $(this).find(".fish-count").first().html("<img src='/assets/images/fishrating/tworating.png'>");}
            else {
              $(this).find(".fish-count").first().html("<img src='/assets/images/fishrating/onerating.png'>");}

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
      alert("Location information is unavailable.");
      break;
    case error.TIMEOUT:
      alert("The request to get user location timed out.");
      break;
    case error.UNKNOWN_ERROR:
      alert("An unknown error occurred.");
      break;
  }
}

/*
 * Sorts the fish results in a particular location.
 *
 */

function sortFishResults() {
  $(".location-detail > table > tbody").append(mergeSort($(".fish-data")));
}

/*
 * Recursive merge sort.
 *
 * Parameters:
 *   toSort    The list of jQuery results to sort.
 *
 * Return:
 *   The sorted array.
 *
 */

function mergeSort(toSort) {
  var sorted = [];

  // If the length of toSort is less or equal to 1, then the array is already sorted
  if (toSort.length <= 1) {
    sorted = [toSort.get(0)];
  }
  else {
    // Sort left and right halves
    var left = mergeSort(toSort.slice(0, (toSort.length / 2)));
    var right = mergeSort(toSort.slice((toSort.length / 2), toSort.length));

    var leftArrayContents = "";
    var rightArrayContents = "";

    for (var i = 0; i < left.length; i++) {
      leftArrayContents += left[i] + ", ";
    }
    for (var j = 0; j < right.length; j++) {
      rightArrayContents += right[j] + ", ";
    }

    // While at least one array contains something
    while ((left.length > 0) || (right.length > 0)) {

      // If left is empty, take from right
      if (left.length == 0) {
        sorted.push(right.shift());
      }

      // If right is empty, take from left
      else if (right.length == 0) {
        sorted.push(left.shift());
      }

      // Else take the element with the largest amount of fish
      else {
        var leftValue = parseFloat($(left[0]).find(".fish-count").first().text().replace("%", ""));
        var rightValue = parseFloat($(right[0]).find(".fish-count").first().text().replace("%", ""));

        sorted.push((leftValue > rightValue) ? (left.shift()) : (right.shift()));
      }
    }
  }

  return sorted;
}

/*
 * Retrieve map location in background to be recalled in next page.
 */
function retrieveLoc() {
  var mapzoom = map.getZoom();

  var mapcenter = map.getCenter();
  var maplat = mapcenter.lat();
  var maplng = mapcenter.lng();
  var maptypeid = map.getMapTypeId();

  var mapLoc = maplat + "_" + maplng + "_" + mapzoom + "_" + maptypeid;

  localStorage.setItem("mapLoc", mapLoc);

}

$(document).ready(function () {
  initialize();
});
