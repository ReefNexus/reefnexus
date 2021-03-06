package views.formdata;

import models.Fish;
import models.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for form data.
 */
public class FishFormData {

  /**
   * Id number.
   */
  public long id;
  /**
   * Fish's common name.
   */
  public String commonName = "";
  /**
   * Genus.
   */
  public String genus = "";
  /**
   * Species.
   */
  public String species = "";
  /**
   * Family.
   */
  public String family = "";
  /**
   * Location of the fish.
   */
  public Location location;
  /**
   * Locations of the fish.
   */
  public List<Location> locationList;
  /**
   * Image path.
   */
  public String image = "";

  /**
   * No-arg constructor.
   */
  public FishFormData() {
    //no arg constructor
  }

  /**
   * Constructs a FishFormData from a fish instance.
   *
   * @param fish The fish.
   */
  public FishFormData(Fish fish) {
    this.id = fish.getId();
    this.commonName = fish.getCommonName();
    this.genus = fish.getGenus();
    this.species = fish.getSpecies();
    this.family = fish.getFamily();
    this.location = (fish.getLocations().isEmpty()) ? (null) : (fish.getLocations().get(0));
    this.locationList = fish.getLocations();
    this.image = fish.getImage();
  }

  /**
   * Creates fish when seeding the database.
   *
   * This is more convenient for internal use and testing, but the constructor that takes a Fish parameter is more
   * likely to be used in actual production.
   *
   * @param commonName The common name of the fish.
   * @param genus      The genus of the fish.
   * @param species    The species of the fish.
   * @param family     The family of the fish.
   * @param location   The location of the fish.
   * @param image      The species type.
   */
  public FishFormData(String commonName, String genus, String species, String family,
                      Location location, String image) {
    this.id = 0;
    this.commonName = commonName;
    this.genus = genus;
    this.species = species;
    this.family = family;
    this.location = location;
    this.locationList = new ArrayList<>();

    if (this.location != null) {
      this.locationList.add(this.location);
    }

    this.image = image;
  }
}
