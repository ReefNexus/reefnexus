package models;

/**
 * Model for fish data.
 */
public class Fish {

  private String commonName;
  private String genus;
  private String species;
  private String family;
  private String location;
  private String image;
  private long numAdded = 0;

  private long id = 1;

  /**
   * Creates a new Fish.
   *
   * @param commonName    The String containing the name of the new Fish.
   * @param genus         The String containing the genus of the new Fish.
   * @param species       The String containing the species of the new Fish.
   * @param family        The String containing the family of the new Fish.
   * @param location      The String containing the location of the new Fish.
   * @param image         The String containing an image of the new Fish.
   * @param id            The long equal to the ID for the new Fish.
   */

  public Fish(String commonName, String genus, String species, String family, String location, String image, long id) {
    this.commonName = commonName;
    this.genus = genus;
    this.species = species;
    this.family = family;
    this.location = location;
    this.image = image;

    this.id = id;
  }

  /**
   * Returns the genus of this Fish.
   *
   * @return A String containing the genus of this Fish.
   * 
   */

  public String getGenus() {
    return this.genus;
  }

  /**
   * Returns the name of this Fish.
   *
   * @return A String containing the name of this Fish.
   *
   */

  public String getCommonName() {
    return this.commonName;
  }

  /**
   * Returns the species of this Fish.
   *
   * @return A String containing the species of this Fish.
   *
   */

  public String getSpecies() {
    return this.species;
  }

  /**
   * Returns the family of this Fish.
   *
   * @return A String containing the family of this Fish.
   *
   */

  public String getFamily() {
    return this.family;
  }

  /**
   * Returns the location of this Fish.
   *
   * @return A String containing the location of this Fish.
   *
   */

  public String getLocation() {
    return this.location;
  }

  /**
   * Returns the path to the image for this Fish.
   *
   * @return A String containing the path to the image for this Fish.
   *
   */

  public String getImage() {
    return this.image;
  }

  /**
   * Returns the ID number of this Fish.
   *
   * @return A long equal to the ID number of this Fish.
   *
   */

  public long getId() {
    return this.id;
  }
}
