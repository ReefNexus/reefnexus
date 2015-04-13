import models.Fish;
import models.FishDB;
import models.Location;
import models.LocationDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.FishFormData;

/**
 * Seeds the database with fake data.
 * <p>
 * Created by Branden Ogata on 4/11/2015.
 */

public class Global extends GlobalSettings {
  /**
   * Populates FishDB and LocationDB.
   *
   * @param app The Application to start.
   */

  @Override
  public void onStart(Application app) {
    Location waikikiBeach = new Location("Waikiki", 0, 0, "description", "good for", "image path");

    FishDB.addFish(new FishFormData(new Fish(0, "Hawaiian Sergeant", "genus", "species",
        "family", waikikiBeach, "image")));
    FishDB.addFish(new FishFormData(new Fish(0, "Christmas Wrasse", "genus", "species",
        "family", waikikiBeach, "image")));
    FishDB.addFish(new FishFormData(new Fish(0, "Ember Parrotfish", "genus", "species",
        "family", waikikiBeach, "image")));
    FishDB.addFish(new FishFormData(new Fish(0, "Yellowstripe Goatfish", "genus", "species",
        "family", waikikiBeach, "image")));
    FishDB.addFish(new FishFormData(new Fish(0, "Brown Tang", "genus", "species",
        "family", waikikiBeach, "image")));
    FishDB.addFish(new FishFormData(new Fish(0, "Bluestripe Snapper", "genus", "species",
        "family", waikikiBeach, "image")));
    FishDB.addFish(new FishFormData(new Fish(0, "Reef Triggerfish", "genus", "species",
        "family", waikikiBeach, "image")));
    FishDB.addFish(new FishFormData(new Fish(0, "Indo-Pacific Sergeant", "genus", "species",
        "family", waikikiBeach, "image")));

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

    // Add the locations to the database
    LocationDB.addLocation(new Location("Kaka'ako to Ala Moana", 0, 0, "description", "good for", "image path"));
    LocationDB.addLocation(new Location("Diamond Head", 0, 0, "description", "good for", "image path"));
    LocationDB.addLocation(new Location("Kahala", 0, 0, "description", "good for", "image path"));
    LocationDB.addLocation(new Location("Maunalua Bay", 0, 0, "description", "good for", "image path"));
    LocationDB.addLocation(new Location("Haunama Bay", 0, 0, "description", "good for", "image path"));
    LocationDB.addLocation(new Location("Koko Head", 0, 0, "description", "good for", "image path"));
    LocationDB.addLocation(new Location("Sandy to Kaloko", 0, 0, "description", "good for", "image path"));
    LocationDB.addLocation(new Location("Makapu'u", 0, 0, "description", "good for", "image path"));
    LocationDB.addLocation(new Location("Waimanalo Bay", 0, 0, "description", "good for", "image path"));
    LocationDB.addLocation(new Location("Lanikai", 0, 0, "description", "good for", "image path"));
    LocationDB.addLocation(new Location("Kailua Bay", 0, 0, "description", "good for", "image path"));
    LocationDB.addLocation(new Location("MCBH", 0, 0, "description", "good for", "image path"));
    LocationDB.addLocation(new Location("South Kaneohe Bay", 0, 0, "description", "good for", "image path"));
    LocationDB.addLocation(new Location("North Kaneohe Bay", 0, 0, "description", "good for", "image path"));
  }
}
