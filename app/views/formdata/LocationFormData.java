package views.formdata;

import models.Fish;
import models.Location;
/**
 * Backing class for location form data.
 */
public class LocationFormData {

  /** Stores location name. **/
  public String location;

  /** Stores last name. **/
  public String fish;

  /**
   * Default no-arg constructor.
   */
  public LocationFormData() {
  }

  public LocationFormData(Location location, Fish fish) {
    this.location = location.getName();
    this.fish = fish.getCommonName();

  }
}
