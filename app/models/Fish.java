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

  public Fish(String commonName, String genus, String species, String family, String location, String image) {
    this.commonName = commonName;
    this.genus = genus;
    this.species = species;
    this.family = family;
    this.location = location;
    this.image = image;
  }

  public String getCommonName() {
    return commonName;
  }

  public String getGenus() {
    return genus;
  }

  public String getSpecies() {
    return species;
  }

  public String getFamily() {
    return family;
  }

  public String getLocation() {
    return location;
  }

  public String getImage() {
    return image;
  }
}
