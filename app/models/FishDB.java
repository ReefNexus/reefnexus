package models;

import views.formdata.FishFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Handles Fish database operations.
 */
public class FishDB {
/*
  private static Map<Long, Fish> fishes = new HashMap<>();
  private static long currentId = 1;
*/

  /**
   * Creates an instance of a fish using the data from the form and adds it to the DB.
   * If the id is 0, create a new id for the fish.  Or else we update an existing contact.
   *
   * @param formData The form data.
   */
  public static void addFish(FishFormData formData) {
    Fish fish = new Fish(formData.commonName, formData.genus, formData.species, formData.family,
                         formData.location, formData.image);
    fish.save();
  }

  /**
   * Gets the Fish with the given name.
   *
   * @param toFind The String containing the name of the Fish to retrieve.
   * @return The Fish with the given name if it exists;
   * null if no fish with the given name could be found.
   */

  public static Fish getFish(String toFind) {
    Fish found = null;

    for (Fish f : Fish.find().all()) {
      if (((f.getCommonName() != null)
          && (f.getCommonName().equalsIgnoreCase(toFind)))
          || ((f.getScientific() != null)
          && (f.getScientific().equalsIgnoreCase(toFind)))) {
        found = f;
      }
    }

    return found;
  }

  /**
   * Returns the fish with the given id or throws a RuntimeException if not found.
   *
   * @param id The id.
   * @return The fish.
   */
  public static Fish getFish(long id) {
    Fish fish = Fish.find().byId(id);

    if (fish == null) {
      throw new RuntimeException("Can't find fish with the given id.");
    }
    return fish;
  }

  /**
   * Returns the list of the fishes from the DB.
   *
   * @return The fish list.
   */
  public static List<Fish> getFishes() {
    return Fish.find().all();
  }
}
