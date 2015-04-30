/**
 * JavaScript code for the Location view.
 *
 * Created by Branden Ogata on 4/29/2015.
 */

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
        var leftValue = parseFloat($(left[0]).find(".fish-count").first().text().replace(" %", "").replace("(", "").replace(")", ""));
        var rightValue = parseFloat($(right[0]).find(".fish-count").first().text().replace(" %", "").replace("(", "").replace(")", ""));

        sorted.push((leftValue > rightValue) ? (left.shift()) : (right.shift()));
      }
    }
  }

  return sorted;
}

$(document).ready(function() {
  $("table#fish-data > tbody").append(mergeSort($(".fish-data")));
});

