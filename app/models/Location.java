package models;

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

  /**
   * Creates an instance of a location.
   *
   * @param name The name.
   * @param longitude The longitude.
   * @param latitude The latitude.
   * @param description The description.
   * @param goodFor What the location is good for.
   * @param image The image.
   */
  public Location(String name, long longitude, long latitude, String description, String goodFor, String image) {
    this.name = name;
    this.longitude = longitude;
    this.latitude = latitude;
    this.description = description;
    this.goodFor = goodFor;
    this.image = image;
  }

  /**
   * Returns the location name.
   *
   * @return The location name.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the location's longitude.
   *
   * @return The longitude.
   */
  public long getLongitude() {
    return longitude;
  }

  /**
   * Returns the location's latitude.
   *
   * @return The latitude.
   */
  public long getLatitude() {
    return latitude;
  }

  /**
   * Returns the description.
   *
   * @return The description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns what the location is good for.
   *
   * @return What the location is good for.
   */
  public String getGoodFor() {
    return goodFor;
  }

  /**
   * Returns the image path of the location.
   *
   * @return The image path.
   */
  public String getImage() {
    return image;
  }
}
