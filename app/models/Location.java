package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Model for location data.
 */
public class Location {

  private String name;
  private long longitude;
  private long latitude;
  private String description;
  private String goodFor;
  private String image;

  private Map<Long, Long> fishCounts;

  /**
   * Creates a new Location.
   *
   * @param name          The String containing the name of the new Location.
   * @param longitude    The long equal to the x-coordinate of the new Location;
   *                        change to a list of coordinate pairs.
   * @param latitude The long equal to the y-coordinate of the new Location;
   *                     change to a list of coordinate pairs.
   * @param description  The String containing the description of the new Location.
   * @param goodFor        https://www.youtube.com/watch?v=01-2pNCZiNk
   * @param image           The String containing the path to an image of this Location.
   *
   */

  public Location(String name, long longitude, long latitude, String description, String goodFor, String image) {
    this.name = name;
    this.longitude = longitude;
    this.latitude = latitude;
    this.description = description;
    this.goodFor = goodFor;
    this.image = image;

    this.fishCounts = new HashMap<>();
  }


  /**
   * Returns the name of this Location.
   *
   * @return A String containing the name of this Location.
   *
   */

  public String getName() {
    return this.name;
  }

  /**
   * Returns the x-coordinate of this Location.
   *
   * @return A long equal to the x-coordinate of this Location.
   *
   */

  @Deprecated
  public long getXCoordinates() {
    return this.longitude;
  }

  /**
   * Returns the y-coordinate of this Location.
   *
   * @return A long equal to the y-coordinate of this Location.
   *
   */

  public long getYCoordinates() {
    return this.latitude;
  }

  /**
   * Returns the description of this Location.
   *
   * @return A String containing the description of this Location.
   *
   */

  public String getDescription() {
    return this.description;
  }

  /**
   * Return information about what this Location is good for.
   *
   * @return A String containing the description of what this Location is used for.
   *
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
   *
   */

  public Map<Long, Long> getFishCounts() {
    return this.fishCounts;
  }

  /**
   * Returns the number of Fish of the given type that are present in this Location.
   *
   * @param typeOfFish    The Fish to count.
   *
   * @return A long equal to the number of Fish of the given type in this Location.
   *
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
   * @param typeOfFish      The Fish to count.
   * @param numberOfFish    The long equal to the number of fish to add to the location.
   *
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
}
