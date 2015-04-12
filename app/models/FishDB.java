package models;

import views.formdata.FishFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Internal in-memory repository for Fishes.
 */
public class FishDB {
  private static Map<Long, Fish> fishes = new HashMap<>();
  private static long currentId = 1;

  /**
   * Creates an instance of a fish using the data from the form and adds it to the DB.
   * If the id is 0, create a new id for the fish.  Or else we update an existing contact.
   *
   * @param formData The form data.
   */
  public static void addFish(FishFormData formData) {
    long idValue = formData.id;
    if (idValue == 0 && !fishes.containsKey(idValue)) {
      idValue = ++currentId;
    }
    else if (fishes.containsKey(idValue)) {
      ArrayList<Location> fishLocations = fishes.get(idValue).getLocations();
      if (!fishLocations.contains(formData.location)) {
        fishLocations.add(formData.location);
      }
      fishes.get(idValue).addNum();
    }
    else {
      Fish fish = new Fish(idValue, formData.commonName, formData.genus, formData.species, formData.family,
          formData.location, formData.image);
      fishes.put(idValue, fish);
    }
  }

  /**
   * Returns the fish with the given id or throws a RuntimeException if not found.
   *
   * @param id The id.
   * @return The fish.
   */
  public static Fish getFish(long id) {
    Fish fish = fishes.get(id);
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
    return new ArrayList<>(fishes.values());
  }
}
