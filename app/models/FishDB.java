package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Internal in-memory repository for Fishes.
 */
public class FishDB {

  /**
   * The Map containing the Fish in this application.
   */
  private static Map<Long, Fish> allFish = new HashMap<>();

  /**
   * The ID to use for the next Fish added.
   */
  private static long nextId = 1;

  /**
   * Adds a Fish to the database.
   *
   * Note that this does not actually check that the Fish is valid at this point.
   *
   * @param toAdd    The Fish to insert into the database.
   *
   * @return A boolean that is true if the operation was successful,
   *                           false otherwise.
   *
   */

  public static boolean addFish(Fish toAdd) {
    // If the ID of the fish is 0, create a new Fish entry
    if (toAdd.getId() == 0) {
      FishDB.allFish.put(nextId, new Fish(toAdd.getCommonName(), toAdd.getGenus(), toAdd.getSpecies(),
                         toAdd.getFamily(), toAdd.getLocation(), toAdd.getImage(), nextId));
      nextId++;
      return true;
    }
    // Else update the fish with the given ID
    else {
      FishDB.allFish.put(toAdd.getId(), toAdd);
      return true;
    }
  }

  /**
   * Gets the Fish with the given ID number.
   *
   * @param id    The long equal to the ID of the Fish to retrieve.
   *
   * @return The Fish with the given ID number if it exists;
   *         null if no fish with the given ID could be found.
   *
   */

  public static Fish getFish(long id) {
    return FishDB.allFish.get(id);
  }

  /**
   * Gets the Fish with the given name.
   *
   * @param toFind    The String containing the name of the Fish to retrieve.
   *
   * @return The Fish with the given name if it exists;
   *         null if no fish with the given name could be found.
   *
   */

  public static Fish getFish(String toFind) {
    Fish found = null;

    for (Fish f : FishDB.allFish.values()) {
      if ((f.getCommonName() != null) && (f.getCommonName().equals(toFind))) {
        found = f;
      }
    }

    return found;
  }
}
