package models;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Model for location data.
 */
public class Location {

  private String name;
  private double longitude;
  private double latitude;
  private String description;
  private String goodFor;
  private String image;

  private Map<Long, Long> fishCounts;

  private List<String> coordinates;

  /**
   * Creates a new Location.
   *
   * @param name        The String containing the name of the new Location.
   * @param longitude   The long equal to the x-coordinate of the new Location;
   *                    change to a list of coordinate pairs.
   * @param latitude    The long equal to the y-coordinate of the new Location;
   *                    change to a list of coordinate pairs.
   * @param description The String containing the description of the new Location.
   * @param goodFor     The String containing a list of activities humans can engage in at the new location.
   * @param image       The String containing the path to an image of this Location.
   */

  public Location(String name, double longitude, double latitude, String description, String goodFor, String image) {
    this.name = name;
    this.longitude = longitude;
    this.latitude = latitude;
    this.description = description;
    this.goodFor = goodFor;
    this.image = image;

    this.fishCounts = new HashMap<>();
    this.coordinates = new LinkedList<>();
  }


  /**
   * Returns the name of this Location.
   *
   * @return A String containing the name of this Location.
   */

  public String getName() {
    return this.name;
  }

  /**
   * Returns the x-coordinate of this Location.
   *
   * @return A long equal to the x-coordinate of this Location.
   */

  @Deprecated
  public double getXCoordinates() {
    return this.getLongitude();
  }

  /**
   * Returns the y-coordinate of this Location.
   *
   * @return A long equal to the y-coordinate of this Location.
   */

  @Deprecated
  public double getYCoordinates() {
    return this.getLatitude();
  }

  /**
   * Returns the latitude of this Location.
   *
   * @return A long equal to the latitude of this Location.
   */

  public double getLatitude() {
    return this.latitude;
  }

  /**
   * Returns the longitude of this Location.
   *
   * @return A long equal to the longitude of this Location.
   */

  public double getLongitude() {
    return this.longitude;
  }

  /**
   * Returns the description of this Location.
   *
   * @return A String containing the description of this Location.
   */

  public String getDescription() {
    return this.description;
  }

  /**
   * Return information about what this Location is good for.
   *
   * @return A String containing the description of what this Location is used for.
   */
  public String getGoodFor() {
    return this.goodFor;
  }

  /**
   * Returns the image path of the location.
   *
   * @return The image path.
   */
  public String getImage() {
    return this.image;
  }

  /**
   * Returns the Map of fish counts.
   *
   * @return The Map containing the number of fish in this Location.
   */

  public Map<Long, Long> getFishCounts() {
    return this.fishCounts;
  }

  /**
   * Returns the number of Fish of the given type that are present in this Location.
   *
   * @param typeOfFish The Fish to count.
   * @return A long equal to the number of Fish of the given type in this Location.
   */

  public long getNumberOfFish(Fish typeOfFish) {
    long count = 0;

    if (this.fishCounts.keySet().contains(typeOfFish.getId())) {
      count = this.fishCounts.get(typeOfFish.getId());
    }

    return count;
  }

  /**
   * Updates the number of Fish of the given type that are present in this Location.
   *
   * @param typeOfFish   The Fish to count.
   * @param numberOfFish The long equal to the number of fish to add to the location.
   */

  public void addNumberOfFish(Fish typeOfFish, long numberOfFish) {
    // If the fish is already in the map, update the value
    if (this.fishCounts.keySet().contains(typeOfFish.getId())) {
      this.fishCounts.put(typeOfFish.getId(),
          this.fishCounts.get(typeOfFish.getId()) + numberOfFish);
    }

    // Else add a new entry
    else {
      this.fishCounts.put(typeOfFish.getId(), numberOfFish);
    }
  }

  /**
   * Returns the total number of fish in this Location.
   *
   * @return A long equal to the sum of all fish counts in this Location.
   */

  public long totalFishCount() {
    long sum = 0;

    for (long numberOfFish : this.fishCounts.values()) {
      sum += numberOfFish;
    }

    return sum;
  }

  /**
   * Returns the List of coordinates that form the bounds of this Location.
   *
   * For convenience, these coordinates are represented as Strings rather than floating point values.
   *
   * @return A List<String> containing the coordinates of this Location.
   */

  public List<String> getCoordinates() {
    return this.coordinates;
  }

  /**
   * Sets the coordinates of this Location.
   *
   * For convenience, these coordinates are represented as Strings rather than floating point values.
   *
   * @param toAdd    The array of Strings that will form the bounds of this Location.
   *                 A List of Strings would be semantically more appropriate,
   *                 but this is more convenient for the time being.
   */

  public void setCoordinates(String[] toAdd) {
    this.coordinates.clear();

    Collections.addAll(this.coordinates, toAdd);
  }
}
