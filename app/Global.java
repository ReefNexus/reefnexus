import models.Fish;
import models.FishDB;
import models.Location;
import models.LocationDB;
import play.Application;
import play.GlobalSettings;

/**
 * Seeds the database with fake data.
 *
 * Created by Branden Ogata on 4/11/2015.
 *
 */

public class Global extends GlobalSettings {
  /**
   * Populates FishDB and LocationDB.
   *
   * @param app    The Application to start.
   *
   */

  @Override
  public void onStart(Application app) {
    Location waikikiBeach = new Location("Waikiki Beach", 0, 0, "description", "good for", "image path");

    FishDB.addFish(new Fish("Hawaiian Sergeant", "genus", "species", "family", "location", "image", 0));
    FishDB.addFish(new Fish("Christmas Wrasse", "genus", "species", "family", "location", "image", 0));
    FishDB.addFish(new Fish("Ember Parrotfish", "genus", "species", "family", "location", "image", 0));
    FishDB.addFish(new Fish("Yellowstripe Goatfish", "genus", "species", "family", "location", "image", 0));
    FishDB.addFish(new Fish("Brown Tang", "genus", "species", "family", "location", "image", 0));
    FishDB.addFish(new Fish("Bluestripe Snapper", "genus", "species", "family", "location", "image", 0));
    FishDB.addFish(new Fish("Reef Triggerfish", "genus", "species", "family", "location", "image", 0));
    FishDB.addFish(new Fish("Indo-Pacific Sergeant", "genus", "species", "family", "location", "image", 0));

    // Initial add
    waikikiBeach.addNumberOfFish(FishDB.getFish("Hawaiian Sergeant"), 150);
    waikikiBeach.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 130);
    waikikiBeach.addNumberOfFish(FishDB.getFish("Ember Parrotfish"), 100);
    waikikiBeach.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 90);
    waikikiBeach.addNumberOfFish(FishDB.getFish("Brown Tang"), 70);
    waikikiBeach.addNumberOfFish(FishDB.getFish("Bluestripe Snapper"), 40);
    waikikiBeach.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 20);
    waikikiBeach.addNumberOfFish(FishDB.getFish("Indo-Pacific Sergeant"), 10);

    // Simulated addition of fish later on
    waikikiBeach.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 5);
    waikikiBeach.addNumberOfFish(FishDB.getFish("Ember Parrotfish"), 3);
    waikikiBeach.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 6);
    waikikiBeach.addNumberOfFish(FishDB.getFish("Bluestripe Snapper"), 2);

    // Add the location to the database
    LocationDB.addLocation(waikikiBeach);
  }
}
