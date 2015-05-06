package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;


/**
 * Model for fish data.
 */
@Entity
public class Fish extends play.db.ebean.Model {

  @Id
  private long id;

  private String commonName;
  private String genus;
  private String species;
  private String scientific;
  private String family;

  @ManyToMany(mappedBy = "fishes")
  private List<Location> locations;

  private String image;
  private long numAdded = 0;

  /**
   * Creates a new empty Fish instance.
   *
   */

  public Fish() {
    this("", "", "", "", null, "");
    this.locations.clear();
  }


  /**
   * Creates an instance of a fish.
   *
   * @param commonName The common name of the fish.
   * @param genus      The genus of the fish.
   * @param species    The species of the fish.
   * @param family     The family of the fish.
   * @param location   The location of the fish.
   * @param image      The image path of the fish.
   */
  public Fish(String commonName, String genus, String species, String family,
              Location location, String image) {
    this.commonName = commonName;
    this.genus = genus;
    this.species = species;
    this.family = family;
    this.locations = new ArrayList<>();

    if (location != null) {
      this.locations.add(location);
    }

    this.image = image;

    this.scientific = genus + " " + species;
  }

  /**
   * Returns the id.
   *
   * @return The id.
   */
  public long getId() {
    return id;
  }

  /**
   * Returns the common name.
   *
   * @return The common name.
   */
  public String getCommonName() {
    return commonName;
  }

  /**
   * Returns the genus.
   *
   * @return The genus.
   */
  public String getGenus() {
    return this.genus;
  }

  /**
   * Returns the species.
   *
   * @return The species
   */
  public String getSpecies() {
    return this.species;
  }

  /**
   * Returns the scientific name.
   *
   * @return The species
   */
  public String getScientific() {
    return this.scientific;
  }

  /**
   * Returns the family.
   *
   * @return The family.
   */
  public String getFamily() {
    return this.family;
  }

  /**
   * Returns the locations of the fish.
   *
   * @return The locations of the fish.
   */
  public List<Location> getLocations() {
    return this.locations;
  }

  /**
   * Returns the path to the fish image.
   *
   * @return The path to the fish image.
   */
  public String getImage() {
    return this.image;
  }

  /**
   * Increments the count of the fish.
   */
  public void addNum() {
    numAdded++;
  }

  /**
   * Indicates how many fish were added.
   *
   * @return A long equal to the number of fish added.
   *
   */

  public long getNumAdded() {
    return this.numAdded;
  }

  /**
   * Sets the common name of this Fish.
   *
   * @param commonName    The String containing the common name to assign to this Fish.
   *
   */

  public void setCommonName(String commonName) {
    this.commonName = commonName;
  }

  /**
   * Sets the genus of this Fish.
   *
   * @param genus    The String containing the genus to assign to this Fish.
   *
   */

  public void setGenus(String genus) {
    this.genus = genus;
  }

  /**
   * Sets the species of this Fish.
   *
   * @param species    The String containing the species to assign to this Fish.
   *
   */

  public void setSpecies(String species) {
    this.species = species;
  }

  /**
   * Sets the scientific name of this Fish.
   *
   * @param scientific    The String containing the scientific name to assign to this Fish.
   *
   */

  public void setScientific(String scientific) {
    this.scientific = scientific;
  }

  /**
   * Sets the family name of this Fish.
   *
   * @param family    The String containing the family name to assign to this Fish.
   *
   */

  public void setFamily(String family) {
    this.family = family;
  }

  /**
   * Sets the locations that this Fish is found in.
   *
   * @param locations    The List<Location> containing the Locations that this Fish can be found in.
   *
   */

  public void setLocations(List<Location> locations) {
    this.locations = locations;
  }

  /**
   * Sets the image for this Fish.
   *
   * @param image    The String containing the path to the image of this Fish.
   *
   */

  public void setImage(String image) {
    this.image = image;
  }

  /**
   * Sets the number of fish added.
   *
   * This has no real use other than satisfying EBean requirements.
   *
   * @param numAdded    The long equal to the number of fish added.
   *
   */

  public void setNumAdded(long numAdded) {
    this.numAdded = numAdded;
  }

  /**
   * Sets the ID of this Fish.
   *
   * @param id    The long equal to the ID to assign to this Fish.
   *
   */

  public void setId(long id) {
    this.id = id;
  }

  /**
   * Adds a Location that this Fish is found in.
   *
   * @param location    The Location to add to this Fish instance.
   *
   */

  public void addLocation(Location location) {
    if (!this.locations.contains(location)) {
      this.locations.add(location);
      location.addFish(this);
    }
  }

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, Fish> find() {
    return new Finder<Long, Fish>(Long.class, Fish.class);
  }

}
