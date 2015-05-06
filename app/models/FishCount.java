package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Contains the number of fish of a given species in a particular Location.
 *
 * During the in-memory phase of this project, this was handled as a Map<Long, Long> in the Location model where the
 * keys were Fish IDs and the values were the number of fish of that type in the Location.  However, Postgres does not
 * handle Maps as far as this developer can tell.  The easiest solution would have been to add a column to the table
 * joining the Location and Fish tables, but since the Play framework abstracts everything so heavily this developer
 * has no idea how to actually accomplish that.  (This also marks the first time in recorded history that this
 * developer has actually wanted to work with raw SQL.)  Consequently, this class is sort of a custom-made join table
 * that uses a ManyToOne annotation to refer to the Location while only storing the ID number of the corresponding Fish;
 * trying to handle ManyToOne relationships to both tables was proving troublesome, thus the use of an ID number rather
 * than the actual Fish instance.
 *
 * Created by Branden Ogata on 5/6/2015.
 *
 */

@Entity
public class FishCount extends Model {
  @Id
  private long id;

  @ManyToOne
  private Location location;

  private long fishId;
  private long count;

  /**
   * Creates a new FishCount.
   *
   */

  public FishCount() {
    this(null, -1, -1);
  }

  /**
   * Creates a new FishCount.
   *
   * @param location    The Location that the fish are located in.
   * @param fishId      The long equal to the ID of the Fish being tracked in the new FishCount.
   * @param count       The long equal to the number of fish in the location.
   *
   */

  public FishCount(Location location, long fishId, long count) {
    this.location = location;
    this.fishId = fishId;
    this.count = count;
  }

  /**
   * Returns the ID of this FishCount.
   *
   * @return A long equal to the ID of this FishCount.
   *
   */

  public long getId() {
    return this.id;
  }

  /**
   * Sets the ID of this FishCount.
   *
   * @param id    The long equal to the ID to assign to this FishCount.
   *
   */

  public void setId(long id) {
    this.id = id;
  }

  /**
   * Returns the Location of this FishCount.
   *
   * @return The Location of this FishCount.
   */

  public Location getLocation() {
    return this.location;
  }

  /**
   * Sets the Location of this FishCount.
   *
   * @param location    The Location to assign to this FishCount.
   *
   */

  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   * Returns the fish ID of this FishCount.
   *
   * @return A long equal to the ID of the Fish for this FishCount.
   *
   */

  public long getFishId() {
    return this.fishId;
  }

  /**
   * Sets the fish ID of this FishCount.
   *
   * @param fishId    The long equal to ths fish ID to assign to this FishCount.
   *
   */

  public void setFishId(long fishId) {
    this.fishId = fishId;
  }

  /**
   * Returns the number of fish in the Location of the type stored in this FishCount.
   *
   * @return A long equal to the number of fish in the Location for this FishCount of the species of this FishCount.
   *
   */

  public long getCount() {
    return this.count;
  }

  /**
   * Sets the number of fish in the Location for this FishCount.
   *
   * @param count    The long equal to the number of fish to assign to this FishCount.
   *
   */

  public void setCount(long count) {
    this.count = count;
  }

  /**
   * Adds the given number of fish to this FishCount.
   *
   * @param toAdd    The long equal to the number of fish to add to this FishCount
   *
   */

  public void addCount(long toAdd) {
    this.count += toAdd;
  }

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, FishCount> find() {
    return new Finder<Long, FishCount>(Long.class, FishCount.class);
  }
}
