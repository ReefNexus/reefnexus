/**
 * Created by Weng on 5/5/2015.
 */

function initialize() {

  var loadedstring = localStorage.getItem("mapLoc")
  var splitstr = loadedstring.split("_");

  this.map = new google.maps.Map(document.getElementById("map"),
      {
        zoom: parseFloat(splitstr[2]),
        center: new google.maps.LatLng(parseFloat(splitstr[0]), parseFloat(splitstr[1])),
        disableDefaultUI: true,
        panControl: false
      });
}

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
