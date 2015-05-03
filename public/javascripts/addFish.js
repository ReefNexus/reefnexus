/**
 * JavaScript code for the AddFish view.
 *
 * Created by Branden Ogata on 5/2/2015.
 */

function getURLParameter(name) {
  return decodeURIComponent(( new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [, ""] )[1].replace(/\+/g, '%20')) || null
}

$(document).ready(function () {
  document.getElementById("current-location").value = getURLParameter('Location');

  $.ajax({type: "GET", url: "/fishInLocation", data: "locationName=" + getURLParameter('Location'),
          success: function (data) {
    var wrapper = $("<div></div>").html(data);
    $("#select-by-image").append($(wrapper).find("#fish-selection"));
  },
  error: function() {
    $(".fish-input-type-header").hide();
  }});
});
