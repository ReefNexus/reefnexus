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
    // Only add if data is not already present
    if ((Location.find().all().size() == 0) && (Fish.find().all().size() == 0)) {
      // Set up Locations
      Location waikikiBeach = new Location("Waikiki", 0, 0, "Waikiki Beach, Queen's Surf Beach, Kuhio Beach Park, Kaimana Beach", "", "images/waikiki.jpg");
      Location kakaako = new Location("Kaka'ako to Ala Moana", 0, 0, "Ala Moana Beach, Kewalo Basin, Kaka'ako Waterfront", "", "images/kakaako.jpg");
      Location diamondHead = new Location("Diamond Head", 0, 0, "Makalei Beach, Le'ahi Beach, Diamond Head Beach, Black Point", "", "images/diamond.jpg");
      Location kahala = new Location("Kahala", 0, 0, "Waialae Beach, Wailupe Beach", "", "images/kahala.jpg");
      Location maunaluaBay = new Location("Maunalua Bay", 0, 0, "Kawaiku'i Beach, Paiko Beach, Kuliouou Beach, Maunalua Bay Beach, Portlock", "", "images/maunalua.jpg");
      Location haunamaBay = new Location("Hanauma Bay", 0, 0, "Hanauma Bay", "", "images/hanauma.jpg");
      Location kokoHead = new Location("Koko Head", 0, 0, "Kahauloa Cove, Bamboo Ridge, Halona Beach", "", "images/koko.jpg");
      Location sandyToKaloko = new Location("Sandy to Kaloko", 0, 0, "Sandy Beach, Wawamalu Beach, Kaloko Beach", "", "images/wawamalu.jpg");
      Location makapuu = new Location("Makapu'u", 0, 0, "Makapu'u Point, Makapu'u Tidepools, Makapu'u Beach, Kaupo Cove", "", "images/makapuu.jpg");
      Location waimanaloBay = new Location("Waimanalo Bay", 0, 0, "Kaiona Beach,  Waimanalo Beach, Bellows Beach", "", "images/waimanalo.jpg");
      Location lanikai = new Location("Lanikai", 0, 0, "Lanikai Beach, The Mokes", "", "images/lanikai.jpg");
      Location kailuaBay = new Location("Kailua Bay", 0, 0, "Kailua Beach, Kalama Beach", "", "images/kailua.jpg.");
      Location mcbh = new Location("MCBH", 0, 0, "Marine Corps Base Hawaii", "", "images/mcbh.jpg");
      Location southKaneoheBay = new Location("South Kaneohe Bay", 0, 0, "Kaneohe Beach, Fish Ponds, Coconut Island", "", "images/skaneohe.jpg");
      Location northKaneoheBay = new Location("North Kaneohe Bay", 0, 0, "Waiahole Beach, Kualoa Beach", "", "images/nkaneohe.jpg");



      // Set up Fish
      FishDB.addFish(new FishFormData("Hawaiian Sergeant", "Abudefduf", "abdominalis",
          "Pomacentridae", null, "images/damsel.jpg"));
      FishDB.addFish(new FishFormData("Christmas Wrasse", "Thalassoma", "trilobatum",
          "Labridae", null, "images/wrasse2.jpg"));
      FishDB.addFish(new FishFormData("Ember Parrotfish", "Scarus", "rubroviolaceus",
          "Scaridae", null, "images/parrot2.jpg"));
      FishDB.addFish(new FishFormData("Yellowstripe Goatfish", "Parupeneus", "chrysopleuron",
          "Mullidae", null, "images/goat.jpg"));
      FishDB.addFish(new FishFormData("Brown Tang", "Zebrasoma", "scopas",
          "Acanthuridae", null, "images/surgeon.jpg"));
      FishDB.addFish(new FishFormData("Bluestripe Snapper", "Lutjanus", "kasmira",
          "Lutjanidae", null, "images/snapper.jpg"));
      FishDB.addFish(new FishFormData("Reef Triggerfish", "Rhinecanthus", "rectangulus",
          "Balistidae", null, "images/trigger.jpg"));
      FishDB.addFish(new FishFormData("Spotted Coral Blenny", "Exallias", "brevis",
          "Blennidae", null, "images/blenny.jpg"));
      FishDB.addFish(new FishFormData("Great Barracuda", "Sphyraena", "barracuda",
          "Sphyraenidae", null, "images/barracuda.jpg"));
      FishDB.addFish(new FishFormData("Bluefin Trevally", "Caranx", "melampygus",
          "Carangidae", null, "images/jack.jpg"));
      FishDB.addFish(new FishFormData("Moorish Idol", "Zanclus", "cornutus",
          "Zanclidae", null, "images/moorish.jpg"));
      FishDB.addFish(new FishFormData("Hawaiian Yellow Anthias", "Odontanthias", "fuscipinnis",
          "Serranidae", null, "images/anthias.jpg"));
      FishDB.addFish(new FishFormData("Great White Shark", "Carcharadon", "carcharias",
          "Lamnidae", null, "images/shark.jpg"));
      FishDB.addFish(new FishFormData("Brick Soldierfish", "Myripristis", "amaena",
          "Holocentridae", null, "images/soldier.jpg"));
      FishDB.addFish(new FishFormData("Viper Moray", "Enchelynassa", "canina",
          "Muraenidae", null, "images/eel.jpg"));
      FishDB.addFish(new FishFormData("Hawaiian Freckled Frogfish", "Antennarius", "drombus",
          "Antennariidae", null, "images/frogfish.jpg"));
      FishDB.addFish(new FishFormData("Longnose Hawkfish", "Oxycirrhites", "typus",
          "Cirrhitidae", null, "images/hawkfish.jpg"));
      FishDB.addFish(new FishFormData("Fisher's Seahorse", "Hippocampus", "fisheri",
          "Syngnathidae", null, "images/seahorse.jpg"));
      FishDB.addFish(new FishFormData("Oval Butterflyfish", "Chaetodon", "lunulatus",
          "Chaetodontidae", null, "images/butterfly.jpg"));
      FishDB.addFish(new FishFormData("Hawaiian Flagtail", "Kuhlia", "xenura",
          "Kuhliidae", null, "images/flagtail.jpg"));
      FishDB.addFish(new FishFormData("Panther Flounder", "Bothus", "pantherinus",
          "Bothidae", null, "images/flounder.jpg"));
      FishDB.addFish(new FishFormData("Giant Grouper", "Epinephelus", "lanceolatus",
          "Serranidae", null, "images/grouper.jpg"));
      FishDB.addFish(new FishFormData("Hawaiian Whitespotted Toby", "Canthigaster", "jactator",
          "Tetraodontidae", null, "images/toby.jpg"));

      // Initial add
      waikikiBeach.addNumberOfFish(FishDB.getFish("Hawaiian Sergeant"), 150);
      waikikiBeach.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 130);
      waikikiBeach.addNumberOfFish(FishDB.getFish("Ember Parrotfish"), 100);
      waikikiBeach.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 90);
      waikikiBeach.addNumberOfFish(FishDB.getFish("Brown Tang"), 70);
      waikikiBeach.addNumberOfFish(FishDB.getFish("Bluestripe Snapper"), 40);
      waikikiBeach.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 20);
      waikikiBeach.addNumberOfFish(FishDB.getFish("Viper Moray"), 15);
      waikikiBeach.addNumberOfFish(FishDB.getFish("Hawaiian Yellow Anthias"), 10);
      waikikiBeach.addNumberOfFish(FishDB.getFish("Longnose Hawkfish"), 5);
      waikikiBeach.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 5);
      waikikiBeach.addNumberOfFish(FishDB.getFish("Ember Parrotfish"), 3);
      waikikiBeach.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 6);
      waikikiBeach.addNumberOfFish(FishDB.getFish("Bluestripe Snapper"), 2);


      // Add more fish to other areas
      kakaako.addNumberOfFish(FishDB.getFish("Oval Butterflyfish"), 20);
      kakaako.addNumberOfFish(FishDB.getFish("Brick Soldierfish"), 19);
      kakaako.addNumberOfFish(FishDB.getFish("Great Barracuda"), 15);
      kakaako.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 14);
      kakaako.addNumberOfFish(FishDB.getFish("Great White Shark"), 13);
      kakaako.addNumberOfFish(FishDB.getFish("Longnose Hawkfish"), 5);
      kakaako.addNumberOfFish(FishDB.getFish("Fisher's Seahorse"), 4);
      kakaako.addNumberOfFish(FishDB.getFish("Moorish Idol"), 3);
      kakaako.addNumberOfFish(FishDB.getFish("Hawaiian Freckled Frogfish"), 2);
      kakaako.addNumberOfFish(FishDB.getFish("Hawaiian Yellow Anthias"), 1);

      diamondHead.addNumberOfFish(FishDB.getFish("Great Barracuda"), 200);
      diamondHead.addNumberOfFish(FishDB.getFish("Moorish Idol"), 130);
      diamondHead.addNumberOfFish(FishDB.getFish("Fisher's Seahorse"), 122);
      diamondHead.addNumberOfFish(FishDB.getFish("Ember Parrotfish"), 55);
      diamondHead.addNumberOfFish(FishDB.getFish("Brown Tang"), 33);
      diamondHead.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 30);
      diamondHead.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 14);
      diamondHead.addNumberOfFish(FishDB.getFish("Viper Moray"), 13);
      diamondHead.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 12);
      diamondHead.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 11);

      kahala.addNumberOfFish(FishDB.getFish("Great Barracuda"), 1000);
      kahala.addNumberOfFish(FishDB.getFish("Brown Tang"), 5);

      maunaluaBay.addNumberOfFish(FishDB.getFish("Hawaiian Sergeant"), 99);
      maunaluaBay.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 300);
      maunaluaBay.addNumberOfFish(FishDB.getFish("Hawaiian Flagtail"), 30);
      maunaluaBay.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 22);
      maunaluaBay.addNumberOfFish(FishDB.getFish("Brown Tang"), 12);
      maunaluaBay.addNumberOfFish(FishDB.getFish("Bluestripe Snapper"), 13);
      maunaluaBay.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 1000);
      maunaluaBay.addNumberOfFish(FishDB.getFish("Viper Moray"), 3);
      maunaluaBay.addNumberOfFish(FishDB.getFish("Hawaiian Yellow Anthias"), 2);
      maunaluaBay.addNumberOfFish(FishDB.getFish("Longnose Hawkfish"), 1);

      haunamaBay.addNumberOfFish(FishDB.getFish("Great White Shark"), 1235);
      haunamaBay.addNumberOfFish(FishDB.getFish("Great Barracuda"), 678);
      haunamaBay.addNumberOfFish(FishDB.getFish("Viper Moray"), 99);
      haunamaBay.addNumberOfFish(FishDB.getFish("Giant Grouper"), 300);

      kokoHead.addNumberOfFish(FishDB.getFish("Giant Grouper"), 11);
      kokoHead.addNumberOfFish(FishDB.getFish("Bluestripe Snapper"), 13);
      kokoHead.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 15);
      kokoHead.addNumberOfFish(FishDB.getFish("Viper Moray"), 3);
      kokoHead.addNumberOfFish(FishDB.getFish("Hawaiian Yellow Anthias"), 2);
      kokoHead.addNumberOfFish(FishDB.getFish("Longnose Hawkfish"), 4);
      kokoHead.addNumberOfFish(FishDB.getFish("Brown Tang"), 55);
      kokoHead.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 21);
      kokoHead.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 65);
      kokoHead.addNumberOfFish(FishDB.getFish("Viper Moray"), 3);

      sandyToKaloko.addNumberOfFish(FishDB.getFish("Hawaiian Flagtail"), 764);
      sandyToKaloko.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 636);
      sandyToKaloko.addNumberOfFish(FishDB.getFish("Viper Moray"), 222);
      sandyToKaloko.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 434);
      sandyToKaloko.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 221);
      sandyToKaloko.addNumberOfFish(FishDB.getFish("Oval Butterflyfish"), 242);
      sandyToKaloko.addNumberOfFish(FishDB.getFish("Brick Soldierfish"), 141);
      sandyToKaloko.addNumberOfFish(FishDB.getFish("Great Barracuda"), 525);
      sandyToKaloko.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 656);
      sandyToKaloko.addNumberOfFish(FishDB.getFish("Great White Shark"), 4242);

      makapuu.addNumberOfFish(FishDB.getFish("Bluestripe Snapper"), 1);
      makapuu.addNumberOfFish(FishDB.getFish("Great Barracuda"), 2);
      makapuu.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 3);
      makapuu.addNumberOfFish(FishDB.getFish("Great White Shark"), 4);
      makapuu.addNumberOfFish(FishDB.getFish("Panther Flounder"), 5);
      makapuu.addNumberOfFish(FishDB.getFish("Bluestripe Snapper"), 6);
      makapuu.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 7);
      makapuu.addNumberOfFish(FishDB.getFish("Viper Moray"), 8);
      makapuu.addNumberOfFish(FishDB.getFish("Hawaiian Yellow Anthias"), 9);
      makapuu.addNumberOfFish(FishDB.getFish("Longnose Hawkfish"), 50);

      waimanaloBay.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 20001);

      lanikai.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 9869);
      lanikai.addNumberOfFish(FishDB.getFish("Viper Moray"), 747);
      lanikai.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 52);
      lanikai.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 5252);
      lanikai.addNumberOfFish(FishDB.getFish("Great Barracuda"), 141);
      lanikai.addNumberOfFish(FishDB.getFish("Brown Tang"), 414);
      lanikai.addNumberOfFish(FishDB.getFish("Oval Butterflyfish"), 431);
      lanikai.addNumberOfFish(FishDB.getFish("Brick Soldierfish"), 43);
      lanikai.addNumberOfFish(FishDB.getFish("Great Barracuda"), 24);
      lanikai.addNumberOfFish(FishDB.getFish("Panther Flounder"), 14);
      lanikai.addNumberOfFish(FishDB.getFish("Great White Shark"), 13);

      kailuaBay.addNumberOfFish(FishDB.getFish("Great Barracuda"), 141);
      kailuaBay.addNumberOfFish(FishDB.getFish("Moorish Idol"), 5435);
      kailuaBay.addNumberOfFish(FishDB.getFish("Fisher's Seahorse"), 3535);
      kailuaBay.addNumberOfFish(FishDB.getFish("Hawaiian Flagtail"), 13);
      kailuaBay.addNumberOfFish(FishDB.getFish("Brown Tang"), 14);
      kailuaBay.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 41414);
      kailuaBay.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 323);
      kailuaBay.addNumberOfFish(FishDB.getFish("Viper Moray"), 453);
      kailuaBay.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 543);
      kailuaBay.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 353);

      southKaneoheBay.addNumberOfFish(FishDB.getFish("Longnose Hawkfish"), 3213);
      southKaneoheBay.addNumberOfFish(FishDB.getFish("Fisher's Seahorse"), 1334331);
      southKaneoheBay.addNumberOfFish(FishDB.getFish("Moorish Idol"), 4324324);
      southKaneoheBay.addNumberOfFish(FishDB.getFish("Hawaiian Freckled Frogfish"), 158682);
      southKaneoheBay.addNumberOfFish(FishDB.getFish("Hawaiian Yellow Anthias"), 324);
      southKaneoheBay.addNumberOfFish(FishDB.getFish("Great Barracuda"), 3453);
      southKaneoheBay.addNumberOfFish(FishDB.getFish("Moorish Idol"), 1431);
      southKaneoheBay.addNumberOfFish(FishDB.getFish("Fisher's Seahorse"), 1341);
      southKaneoheBay.addNumberOfFish(FishDB.getFish("Ember Parrotfish"), 234);
      southKaneoheBay.addNumberOfFish(FishDB.getFish("Brown Tang"), 31313);
      southKaneoheBay.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 4333);
      southKaneoheBay.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 88);

      // Assign Coordinates to Locations
      kakaako.setCoordinates(new String[]{"21.27242,-157.85048",
          "21.28667,-157.87744",
          "21.30733,-157.85931",
          "21.29588,-157.83243"});
      waikikiBeach.setCoordinates(new String[]{"21.27242,-157.85048",
          "21.25439,-157.82759",
          "21.26882,-157.81185",
          "21.29588,-157.83243"});
      diamondHead.setCoordinates(new String[]{"21.24642,-157.79096",
          "21.25439,-157.82759",
          "21.26882,-157.81185",
          "21.26177,-157.79286"});
      kahala.setCoordinates(new String[]{"21.24642,-157.79096",
          "21.26191,-157.75283",
          "21.28334,-157.75988",
          "21.26177,-157.79286"});
      maunaluaBay.setCoordinates(new String[]{"21.25402,-157.70281",
          "21.26191,-157.75283",
          "21.28334,-157.75988",
          "21.29272,-157.70162"});
      haunamaBay.setCoordinates(new String[]{"21.25402,-157.70281",
          "21.26479,-157.68108",
          "21.27934,-157.69096",
          "21.29272,-157.70162"});
      kokoHead.setCoordinates(new String[]{"21.27634,-157.66942",
          "21.26479,-157.68108",
          "21.27934,-157.69096",
          "21.28896,-157.68042"});
      sandyToKaloko.setCoordinates(new String[]{"21.27634,-157.66942",
          "21.29292,-157.64739",
          "21.30205,-157.65626",
          "21.28896,-157.68042"});
      makapuu.setCoordinates(new String[]{"21.31121,-157.6326",
          "21.29292,-157.64739",
          "21.31798,-157.68034",
          "21.33973,-157.66248"});
      waimanaloBay.setCoordinates(new String[]{"21.38276,-157.69225",
          "21.36008,-157.7346",
          "21.31798,-157.68034",
          "21.33973,-157.66248"});
      lanikai.setCoordinates(new String[]{"21.38276,-157.69225",
          "21.36008,-157.7346",
          "21.38577,-157.74299",
          "21.40504,-157.69956"});
      kailuaBay.setCoordinates(new String[]{"21.44508,-157.70942",
          "21.42338,-157.75313",
          "21.38577,-157.74299",
          "21.40504,-157.69956"});
      mcbh.setCoordinates(new String[]{"21.44508,-157.70942",
          "21.42322,-157.75331",
          "21.45105,-157.79424",
          "21.48828,-157.71758"});
      southKaneoheBay.setCoordinates(new String[]{"21.39203,-157.78598",
          "21.42322,-157.75331",
          "21.45105,-157.79424",
          "21.43907,-157.83328"});
      northKaneoheBay.setCoordinates(new String[]{"21.52303,-157.87035",
          "21.5447,-157.81613",
          "21.45105,-157.79424",
          "21.43907,-157.83328"});

      // Add the locations to the database
      LocationDB.addLocation(waikikiBeach);
      LocationDB.addLocation(kakaako);
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
    else {
      for (Location l : LocationDB.getLocations()) {
        System.out.println("Location: " + l.getName());

        for (Fish f : l.getFishes()) {
          System.out.println("\tFish: " + f.getCommonName());
        }
      }

    }
  }
}
