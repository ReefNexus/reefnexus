package models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Internal in-memory repository for Locations.
 *
 * Note that Locations themselves are immutable once created.
 */
public class LocationDB {
  private static Map<Long, Location> locations = new HashMap<>();

  /**
   * Adds a Location to the database.
   *
   * @param location    The Location to add to the database.
   *
   */

  public static void addLocation(Location location) {
    LocationDB.locations.put((long) (LocationDB.locations.size() + 1), location);
  }

  /**
   * Returns the Location with the given ID.
   *
   * @param id    The long equal to the ID of the Location to retrieve.
   *
   * @return The Location with the given ID;
   *         null if no Location exists with the given ID.
   *
   */

  public static Location getLocation(long id) {
    return LocationDB.locations.get(id);
  }

  /**
   * Returns the Location with the given name.
   *
   * @param name    The long equal to the name of the Location to retrieve.
   *
   * @return The Location with the given name;
   *         null if no Location exists with the given name.
   *
   */

  public static Location getLocation(String name) {
    Location location = null;

    for (Location l : LocationDB.locations.values()) {
      if ((l != null) && (l.getName() != null) && (l.getName().equalsIgnoreCase(name.replaceAll("_", " ")))) {
        location = l;
      }
    }

    return location;
  }

  /**
   * Returns a List of all Locations in this LocationDB.
   *
   * @return A Collection<Location> containing all Locations in the LocationDB.
   *
   */

  public static Collection<Location> getLocations() {
    return LocationDB.locations.values();
  }
}
