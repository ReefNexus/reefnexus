package models;

import java.util.ArrayList;

/**
 * Model for fish data.
 */
public class Fish {

  private long id = 1;
  private String commonName;
  private String genus;
  private String species;
  private String scientific;
  private String family;
  private ArrayList<Location> locations;
  private String image;
  private long numAdded = 0;

  /**
   * Creates an instance of a fish.
   *
   * @param id         The id.
   * @param commonName The common name of the fish.
   * @param genus      The genus of the fish.
   * @param species    The species of the fish.
   * @param family     The family of the fish.
   * @param location   The location of the fish.
   * @param image      The image path of the fish.
   */
  public Fish(long id, String commonName, String genus, String species, String family,
              Location location, String image) {
    this.id = id;
    this.commonName = commonName;
    this.genus = genus;
    this.species = species;
    this.family = family;
    this.locations = new ArrayList<>();
    this.locations.add(location);
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
  public ArrayList<Location> getLocations() {
    return locations;
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
}
