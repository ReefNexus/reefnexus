package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * A latitude-longitude coordinate pair.
 *
 * Created by Branden Ogata on 5/5/2015.
 *
 */

@Entity
public class Coordinate extends play.db.ebean.Model {
  private double latitude;
  private double longitude;

  @Id
  private long id = 0;

  @ManyToMany(mappedBy="coordinates")
  private List<Location> locations;

  /**
   * Creates a new Coordinate.
   *
   */

  public Coordinate() {
    this(0.0, 0.0);
  }

  /**
   * Creates a new Coordinate.
   *
   * @param latitude     The double equal to the latitude of the new Coordinate.
   * @param longitude    The double equal to the longitude of the new Coordinate.
   *
   */

  public Coordinate(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.locations = new ArrayList<>();
  }

  /**
   * Returns the latitude of this Coordinate.
   *
   * @return A double equal to the latitude of this Coordinate.
   *
   */

  public double getLatitude() {
    return this.latitude;
  }

  /**
   * Sets the latitude of this Coordinate.
   *
   * @param latitude    The double equal to the latitude to assign to this Coordinate.
   *
   */

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  /**
   * Returns the longitude of this Coordinate.
   *
   * @return A double equal to the longitude of this Coordinate.
   *
   */

  public double getLongitude() {
    return this.longitude;
  }

  /**
   * Sets the longitude of this Coordinate.
   *
   * @param longitude    The double equal to the longitude to assign to this Coordinate.
   *
   */

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  /**
   * Returns the ID of this Coordinate.
   *
   * @return A long equal to the ID number of this Coordinate.
   *
   */

  public long getId() {
    return this.id;
  }

  /**
   * Sets the ID of this Coordinate.
   *
   * @param id    The long equal to the ID number to assign to this Coordinate.
   *
   */

  public void setId(long id) {
    this.id = id;
  }

  /**
   * Returns the list of Locations that this Coordinate applies to.
   *
   * @return A List<Location> containing the Locations this Coordinate is used for.
   *
   */

  public List<Location> getLocations() {
    return locations;
  }

  /**
   * Sets the list of Locations that this Coordinate applies to.
   *
   * @param locations    The List<Location> of Locations that this Coordinate is used for.
   *
   */

  public void setLocations(List<Location> locations) {
    this.locations = locations;
  }


  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, Coordinate> find() {
    return new Finder<Long, Coordinate>(Long.class, Coordinate.class);
  }

  /**
   * Returns the latitude and longitude in String format.
   *
   * @return A String in the format "{latitude},{longitude}".
   *
   */

  @Override
  public String toString() {
    return String.format("%f,%f", this.latitude, this.longitude);
  }

  /**
   * Adds a Location to the list of locations using this Coordinate.
   *
   * @param location    The Location to add to this Coordinate.
   *
   */

  public void addLocation(Location location) {
    if (location != null) {
      this.locations.add(location);
    }
  }
}
