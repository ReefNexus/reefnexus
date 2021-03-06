package views.formdata;

import models.Fish;
import models.FishDB;
import models.Location;
import models.LocationDB;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for location form data.
 */
public class LocationFormData {

  /**
   * Stores location name. *
   */
  public String location;

  /**
   * Stores last name. *
   */
  public String fish;

  /**
   * Default no-arg constructor.
   */
  public LocationFormData() {
  }

  /**
   * Set location and fish name from form.
   * @param location The location where fish was observed.
   * @param fish The fish that was observed.
   */
  public LocationFormData(Location location, Fish fish) {
    this.location = location.getName();
    this.fish = fish.getCommonName();

  }

  /**
   * Return error if location or fish is not a valid entry.
   * @return Validation error.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();

    if ((LocationDB.getLocation(this.location)) == null || (this.location.length() == 0)) {
      errors.add(new ValidationError("location", "Please enter an available location."));
    }
    if ((FishDB.getFish(this.fish) == null) || (this.fish.length() == 0)) {
      errors.add(new ValidationError("fish", "Please enter an available fish."));
    }

    return errors.isEmpty() ? null : errors;
  }
}
