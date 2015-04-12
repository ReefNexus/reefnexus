package models;

/**
 * Model for location data.
 */
public class Location {

  private String name;
  private long xCoordinates;
  private long yCoordinates;
  private String description;
  private String goodFor;
  private String image;

  public Location(String name, long xCoordinates, long yCoordinates, String description, String goodFor, String image) {
    this.name = name;
    this.xCoordinates = xCoordinates;
    this.yCoordinates = yCoordinates;
    this.description = description;
    this.goodFor = goodFor;
    this.image = image;
  }

  public String getName() {
    return name;
  }

  public long getXCoordinates() {
    return xCoordinates;
  }

  public long getYCoordinates() {
    return yCoordinates;
  }

  public String getDescription() {
    return description;
  }

  public String getGoodFor() {
    return goodFor;
  }

  public String getImage() {
    return image;
  }
}
