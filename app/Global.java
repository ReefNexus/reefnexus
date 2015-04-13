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

    // Sets up other Locations
    Location kakaako = new Location("Kaka'ako to Ala Moana", 0, 0, "description", "good for", "image path");
    Location diamondHead = new Location("Diamond Head", 0, 0, "description", "good for", "image path");
    Location kahala = new Location("Kahala", 0, 0, "description", "good for", "image path");
    Location maunaluaBay = new Location("Maunalua Bay", 0, 0, "description", "good for", "image path");
    Location haunamaBay = new Location("Haunama Bay", 0, 0, "description", "good for", "image path");
    Location kokoHead = new Location("Koko Head", 0, 0, "description", "good for", "image path");
    Location sandyToKaloko = new Location("Sandy to Kaloko", 0, 0, "description", "good for", "image path");
    Location makapuu = new Location("Makapu'u", 0, 0, "description", "good for", "image path");
    Location waimanaloBay = new Location("Waimanalo Bay", 0, 0, "description", "good for", "image path");
    Location lanikai = new Location("Lanikai", 0, 0, "description", "good for", "image path");
    Location kailuaBay = new Location("Kailua Bay", 0, 0, "description", "good for", "image path");
    Location mcbh = new Location("MCBH", 0, 0, "description", "good for", "image path");
    Location southKaneoheBay = new Location("South Kaneohe Bay", 0, 0, "description", "good for", "image path");
    Location northKaneoheBay = new Location("North Kaneohe Bay", 0, 0, "description", "good for", "image path");

    // Set up coordinates
    kakaako.setCoordinates(new String[] {"21.27242,-157.85048",
                                         "21.28667,-157.87744",
                                         "21.30733,-157.85931",
                                         "21.29588,-157.83243"});
    waikikiBeach.setCoordinates(new String[] {"21.27242,-157.85048",
                                              "21.25439,-157.82759",
                                              "21.26882,-157.81185",
                                              "21.29588,-157.83243"});
  diamondHead.setCoordinates(new String[] {"21.24642,-157.79096",
                                           "21.25439,-157.82759",
                                           "21.26882,-157.81185",
                                           "21.26177,-157.79286"});
  kahala.setCoordinates(new String[] {"21.24642,-157.79096",
                                      "21.26191,-157.75283",
                                      "21.28334,-157.75988",
                                      "21.26177,-157.79286"});
    maunaluaBay.setCoordinates(new String[] {"21.25402,-157.70281",
                                           "21.26191,-157.75283",
                                           "21.28334,-157.75988",
                                           "21.29272,-157.70162"});
  haunamaBay.setCoordinates(new String[] {"21.25402,-157.70281",
                                          "21.26479,-157.68108",
                                          "21.27934,-157.69096",
                                          "21.29272,-157.70162"});
  kokoHead.setCoordinates(new String[] {"21.27634,-157.66942",
                                        "21.26479,-157.68108",
                                        "21.27934,-157.69096",
                                        "21.28896,-157.68042"});
  sandyToKaloko.setCoordinates(new String[] {"21.27634,-157.66942",
                                             "21.29292,-157.64739",
                                             "21.30205,-157.65626",
                                             "21.28896,-157.68042"});
  makapuu.setCoordinates(new String[] {"21.31121,-157.6326",
                                       "21.29292,-157.64739",
                                       "21.31798,-157.68034",
                                       "21.33973,-157.66248"});
  waimanaloBay.setCoordinates(new String[] {"21.38276,-157.69225",
                                            "21.36008,-157.7346",
                                            "21.31798,-157.68034",
                                            "21.33973,-157.66248"});
  lanikai.setCoordinates(new String[] {"21.38276,-157.69225",
                                       "21.36008,-157.7346",
                                       "21.38577,-157.74299",
                                       "21.40504,-157.69956"});
  kailuaBay.setCoordinates(new String[] {"21.44508,-157.70942",
                                         "21.42338,-157.75313",
                                         "21.38577,-157.74299",
                                         "21.40504,-157.69956"});
  mcbh.setCoordinates(new String[] {"21.44508,-157.70942",
                                    "21.42322,-157.75331",
                                    "21.45105,-157.79424",
                                    "21.48828,-157.71758"});
  southKaneoheBay.setCoordinates(new String[] {"21.39203,-157.78598",
                                               "21.42322,-157.75331",
                                               "21.45105,-157.79424",
                                               "21.43907,-157.83328"});
  northKaneoheBay.setCoordinates(new String[] {"21.52303,-157.87035",
                                               "21.5447,-157.81613",
                                               "21.45105,-157.79424",
                                               "21.43907,-157.83328"});

    // Add the locations to the database
    LocationDB.addLocation(kakaako);
    LocationDB.addLocation(waikikiBeach);
    LocationDB.addLocation(diamondHead);
    LocationDB.addLocation(kahala);
    LocationDB.addLocation(maunaluaBay);
    LocationDB.addLocation(haunamaBay);
    LocationDB.addLocation(kokoHead);
    LocationDB.addLocation(sandyToKaloko);
    LocationDB.addLocation(makapuu);
    LocationDB.addLocation(waimanaloBay);
    LocationDB.addLocation(lanikai);
    LocationDB.addLocation(kailuaBay);
    LocationDB.addLocation(mcbh);
    LocationDB.addLocation(southKaneoheBay);
    LocationDB.addLocation(northKaneoheBay);
  }
}
