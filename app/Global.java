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
      Location waikikiBeach = new Location("Waikiki", 0, 0, "Waikiki Beach, "
          + "Queen's Surf Beach, Kuhio Beach Park, Kaimana Beach", "", "images/location/waikiki.jpg");
      Location kakaako = new Location("Kaka'ako to Ala Moana", 0, 0, "Ala Moana Beach, "
          + "Kewalo Basin, Kaka'ako Waterfront", "", "images/location/kakaako.jpg");
      Location diamondHead = new Location("Diamond Head", 0, 0, "Makalei Beach, "
          + "Le'ahi Beach, Diamond Head Beach, Black Point", "", "images/location/diamond.jpg");
      Location kahala = new Location("Kahala", 0, 0, "Waialae Beach, "
          + "Wailupe Beach", "", "images/location/kahala.jpg");
      Location maunaluaBay = new Location("Maunalua Bay", 0, 0, "Kawaiku'i Beach, "
          + "Paiko Beach, Kuliouou Beach, Maunalua Bay Beach, Portlock", "", "images/location/maunalua.jpg");
      Location haunamaBay = new Location("Hanauma Bay", 0, 0, "Hanauma Bay", "", "images/location/hanauma.jpg");
      Location kokoHead = new Location("Koko Head", 0, 0, "Kahauloa Cove, "
          + "Bamboo Ridge, Halona Beach", "", "images/location/koko.jpg");
      Location sandyToKaloko = new Location("Sandy to Kaloko", 0, 0, "Sandy Beach, "
          + "Wawamalu Beach, Kaloko Beach", "", "images/location/wawamalu.jpg");
      Location makapuu = new Location("Makapu'u", 0, 0, "Makapu'u Point, "
          + "Makapu'u Tidepools, Makapu'u Beach, Kaupo Cove", "", "images/location/makapuu.jpg");
      Location waimanaloBay = new Location("Waimanalo Bay", 0, 0, "Kaiona Beach,  "
          + "Waimanalo Beach, Bellows Beach", "", "images/location/waimanalo.jpg");
      Location lanikai = new Location("Lanikai", 0, 0, "Lanikai Beach, The Mokes", "", "images/location/lanikai.jpg");
      Location kailuaBay = new Location("Kailua Bay", 0, 0, "Kailua Beach, "
          + "Kalama Beach", "", "images/location/kailua.jpg.");
      Location mcbh = new Location("MCBH", 0, 0, "Marine Corps Base Hawaii", "", "images/location/mcbh.jpg");
      Location southKaneoheBay = new Location("South Kaneohe Bay", 0, 0, "Kaneohe Beach, "
          + "Fish Ponds, Coconut Island", "", "images/location/skaneohe.jpg");
      Location northKaneoheBay = new Location("North Kaneohe Bay", 0, 0, "Waiahole Beach, "
          + "Kualoa Beach", "", "images/location/nkaneohe.jpg");
      Location kaaawa = new Location("Ka'a'awa", 0, 0, "Kahana Bay Beach, Swanzy Beach, "
          + "Ka'a'awa Beach, Kalae'o'io Beach", "", "images/location/kaaawa.jpg");
      Location punaluu = new Location("Punalu'u", 0, 0, "Punalu'u Beach, "
          + "Kaluanui Beach", "", "images/location/punaluu.jpg");
      Location hauula = new Location("Hau'ula", 0, 0, "Hau'ula Beach", "", "images/location/hauula.jpg");
      Location laie = new Location("La'ie", 0, 0, "Kokololio Beach, "
          + "Pounders Beach, La'ie Point, Hukilau Beach", "", "images/location/laie.jpg");
      Location kahuku = new Location("Kahuku", 0, 0, "Kahuku Beach", "", "images/location/kahuku.jpg");
      Location kahukuPoint = new Location("Kahuku Point", 0, 0, "Kaihalulu Beach",
          "", "images/location/kahukupoint.png");
      Location kawelaBay = new Location("Kawela Bay", 0, 0, "Bayview Beach, "
          + "Turtle Bay, Kawela Bay, Waiale'e Beach", "", "images/location/kawela.jpg");
      Location sunsetPoint = new Location("Sunset Point", 0, 0, "Sunset Beach", "", "images/location/sunset.jpg");
      Location pupukea = new Location("Pupukea", 0, 0, "Ehukai Beach, "
          + "Banzai Pipeline, Shark's Cove, Pupukea Beach", "", "images/location/pupukea.jpg");
      Location waimeaBay = new Location("Waimea Bay", 0, 0, "Three "
          + "Tables, Waimea Bay, Uppers Beach", "", "images/location/waimea.jpg");
      Location haleiwa = new Location("Haleiwa", 0, 0, "Papa'iloa "
          + "Beach, Police Beach, Pua'ena Point Beach, Hale'iwa Beach, "
          + "Hale'iwa Ali'i Beach", "", "images/location/haleiwa.jpg");
      Location waialua = new Location("Waialua", 0, 0, "Kaiaka Bay", "", "images/location/waialua.jpg");
      Location mokuleia = new Location("Mokule'ia", 0, 0, "Makaleha Beach, "
          + "Mokule'ia Beach", "", "images/location/mokuleia.jpg");
      Location kaena = new Location("Kaena Point", 0, 0, "Kaena Point, Yokohama Bay", "", "images/location/kaena.jpg");
      Location makua = new Location("Makua", 0, 0, "Makua Beach", "", "images/location/makua.jpg");
      Location makaha = new Location("Makaha", 0, 0, "Makaha Beach, "
          + "Turtle Beach Makaha Mauna Lahilahi Beach", "", "images/location/makaha.jpg");
      Location waianae = new Location("Waianae", 0, 0, "Lualualei Beach", "", "images/location/waianae.jpg");
      Location maili = new Location("Maili", 0, 0, "Maili Beach", "", "images/location/maili.jpg");
      Location nanakuli = new Location("Nanakuli", 0, 0, "Ulehawa Beach, "
          + "Nanakuli Beach", "", "images/location/nanakuli.jpg");
      Location koolina = new Location("Ko Olina", 0, 0, "Ko Olina Beach", "", "images/location/koolina.jpg");
      Location barbersPoint = new Location("Barbers Point", 0, 0, "Barbers Point Beach",
          "", "images/location/barber.jpg");
      Location ewa = new Location("Ewa", 0, 0, "Ewa Beach", "", "images/location/ewa.jpg");
      Location sandIsland = new Location("Sand Island", 0, 0, "Sand Island Beach, "
          + "Ke'ehi Lagoon Beach", "", "images/location/sand.jpg");

      // Add the locations to the database.
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
      LocationDB.addLocation(kaaawa);
      LocationDB.addLocation(punaluu);
      LocationDB.addLocation(hauula);
      LocationDB.addLocation(laie);
      LocationDB.addLocation(kahuku);
      LocationDB.addLocation(kahukuPoint);
      LocationDB.addLocation(kawelaBay);
      LocationDB.addLocation(sunsetPoint);
      LocationDB.addLocation(pupukea);
      LocationDB.addLocation(waimeaBay);
      LocationDB.addLocation(haleiwa);
      LocationDB.addLocation(waialua);
      LocationDB.addLocation(mokuleia);
      LocationDB.addLocation(makua);
      LocationDB.addLocation(makaha);
      LocationDB.addLocation(waianae);
      LocationDB.addLocation(maili);
      LocationDB.addLocation(nanakuli);
      LocationDB.addLocation(koolina);
      LocationDB.addLocation(barbersPoint);
      LocationDB.addLocation(ewa);
      LocationDB.addLocation(sandIsland);


      // Assign Coordinates to Locations
      waikikiBeach.setCoordinates(new String[]{"21.27625,-157.82926"});
      kakaako.setCoordinates(new String[]{"21.29026,-157.85735"});
      diamondHead.setCoordinates(new String[]{"21.2553,-157.80744"});
      kahala.setCoordinates(new String[]{"21.26879,-157.77703"});
      maunaluaBay.setCoordinates(new String[]{"21.2805,-157.72907"});
      haunamaBay.setCoordinates(new String[]{"21.27057,-157.69501"});
      kokoHead.setCoordinates(new String[]{"21.27823,-157.68039"});
      sandyToKaloko.setCoordinates(new String[]{"21.29066,-157.66307"});
      makapuu.setCoordinates(new String[]{"21.31079,-157.64961"});
      waimanaloBay.setCoordinates(new String[]{"21.33784,-157.69671"});
      lanikai.setCoordinates(new String[]{"21.38546,-157.71037"});
      kailuaBay.setCoordinates(new String[]{"21.40449,-157.73792"});
      mcbh.setCoordinates(new String[]{"21.45377,-157.74676"});
      southKaneoheBay.setCoordinates(new String[]{"21.42516,-157.79046"});
      northKaneoheBay.setCoordinates(new String[]{"21.48353,-157.84136"});
      kaaawa.setCoordinates(new String[]{"21.55854,-157.85299"});
      punaluu.setCoordinates(new String[]{"21.592224,-157.889390"});
      hauula.setCoordinates(new String[]{"21.611370,-157.910022"});
      laie.setCoordinates(new String[]{"21.649109,-157.921846"});
      kahuku.setCoordinates(new String[]{"21.684878,-157.944663"});
      kahukuPoint.setCoordinates(new String[]{"21.712711,-157.984489"});
      kawelaBay.setCoordinates(new String[]{"21.700508,-158.007670"});
      sunsetPoint.setCoordinates(new String[]{"21.680935,-158.037932"});
      pupukea.setCoordinates(new String[]{"21.655760,-158.061746"});
      waimeaBay.setCoordinates(new String[]{"21.641082,-158.065308"});
      haleiwa.setCoordinates(new String[]{"21.596412,-158.104014"});
      waialua.setCoordinates(new String[]{"21.582653,-158.130804"});
      mokuleia.setCoordinates(new String[]{"21.580247,-158.157380"});
      makua.setCoordinates(new String[]{"21.533620,-158.230250"});
      makaha.setCoordinates(new String[]{"21.532995,-158.230131"});
      waianae.setCoordinates(new String[]{"21.434533,-158.185622"});
      maili.setCoordinates(new String[]{"21.418746,-158.178475"});
      nanakuli.setCoordinates(new String[]{"21.388323,-158.154157"});
      koolina.setCoordinates(new String[]{"21.325093,-158.121842"});
      barbersPoint.setCoordinates(new String[]{"21.295797,-158.104479"});
      ewa.setCoordinates(new String[]{"21.309911,-158.007885"});
      sandIsland.setCoordinates(new String[]{"21.300875,-157.877929"});


      // Set up Fish
      FishDB.addFish(new FishFormData("Hawaiian Sergeant", "Abudefduf", "abdominalis",
          "Pomacentridae", null, "images/fish/damsel.jpg"));
      FishDB.addFish(new FishFormData("Christmas Wrasse", "Thalassoma", "trilobatum",
          "Labridae", null, "images/fish/wrasse2.jpg"));
      FishDB.addFish(new FishFormData("Ember Parrotfish", "Scarus", "rubroviolaceus",
          "Scaridae", null, "images/fish/parrot2.jpg"));
      FishDB.addFish(new FishFormData("Yellowstripe Goatfish", "Parupeneus", "chrysopleuron",
          "Mullidae", null, "images/fish/goat.jpg"));
      FishDB.addFish(new FishFormData("Brown Tang", "Zebrasoma", "scopas",
          "Acanthuridae", null, "images/fish/surgeon.jpg"));
      FishDB.addFish(new FishFormData("Bluestripe Snapper", "Lutjanus", "kasmira",
          "Lutjanidae", null, "images/fish/snapper.jpg"));
      FishDB.addFish(new FishFormData("Reef Triggerfish", "Rhinecanthus", "rectangulus",
          "Balistidae", null, "images/fish/trigger.jpg"));
      FishDB.addFish(new FishFormData("Spotted Coral Blenny", "Exallias", "brevis",
          "Blennidae", null, "images/fish/blenny.jpg"));
      FishDB.addFish(new FishFormData("Great Barracuda", "Sphyraena", "barracuda",
          "Sphyraenidae", null, "images/fish/barracuda.jpg"));
      FishDB.addFish(new FishFormData("Bluefin Trevally", "Caranx", "melampygus",
          "Carangidae", null, "images/fish/jack.jpg"));
      FishDB.addFish(new FishFormData("Moorish Idol", "Zanclus", "cornutus",
          "Zanclidae", null, "images/fish/moorish.jpg"));
      FishDB.addFish(new FishFormData("Hawaiian Yellow Anthias", "Odontanthias", "fuscipinnis",
          "Serranidae", null, "images/fish/anthias.jpg"));
      FishDB.addFish(new FishFormData("Great White Shark", "Carcharadon", "carcharias",
          "Lamnidae", null, "images/fish/shark.jpg"));
      FishDB.addFish(new FishFormData("Brick Soldierfish", "Myripristis", "amaena",
          "Holocentridae", null, "images/fish/soldier.jpg"));
      FishDB.addFish(new FishFormData("Viper Moray", "Enchelynassa", "canina",
          "Muraenidae", null, "images/fish/eel.jpg"));
      FishDB.addFish(new FishFormData("Hawaiian Freckled Frogfish", "Antennarius", "drombus",
          "Antennariidae", null, "images/fish/frogfish.jpg"));
      FishDB.addFish(new FishFormData("Longnose Hawkfish", "Oxycirrhites", "typus",
          "Cirrhitidae", null, "images/fish/hawkfish.jpg"));
      FishDB.addFish(new FishFormData("Fisher's Seahorse", "Hippocampus", "fisheri",
          "Syngnathidae", null, "images/fish/seahorse.jpg"));
      FishDB.addFish(new FishFormData("Oval Butterflyfish", "Chaetodon", "lunulatus",
          "Chaetodontidae", null, "images/fish/butterfly.jpg"));
      FishDB.addFish(new FishFormData("Hawaiian Flagtail", "Kuhlia", "xenura",
          "Kuhliidae", null, "images/fish/flagtail.jpg"));
      FishDB.addFish(new FishFormData("Panther Flounder", "Bothus", "pantherinus",
          "Bothidae", null, "images/fish/flounder.jpg"));
      FishDB.addFish(new FishFormData("Giant Grouper", "Epinephelus", "lanceolatus",
          "Serranidae", null, "images/fish/grouper.jpg"));
      FishDB.addFish(new FishFormData("Hawaiian Whitespotted Toby", "Canthigaster", "jactator",
          "Tetraodontidae", null, "images/fish/toby.jpg"));


      // Fishes from Wikipedia
      FishDB.addFish(new FishFormData("Agile Chromis", "Chromis", "agilis",
          "Pomacentridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Needlefish", "Strongylura", "gigantea",
          "Belonidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Crocodile Needlefish", "Ablennes", "hians",
          "Belonidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Flatsided Needlefish", "Tylosurus", "crocodilus",
          "Belonidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Keeltail Needlefish", "Platybelone", "argalus",
          "Belonidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Albacore Tuna", "Thunnus", "alalunga",
          "Scombridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Yellowfin Tuna", "Thunnus", "albacares",
          "Scombridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Skipjack Tuna", "Katsuwonus", "pelamis",
          "Scombridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Bigeye Scad", "Selar", "crumenophthalmus",
          "Carangidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Squirrelfish", "Flammeo", "scythrops",
          "Holocentridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Bluestripe Squirrelfish", "Sargocentron", "tiere",
          "Holocentridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Crown Squirrelfish", "Sargocentron", "diadema",
          "Holocentridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Dwarf Squirrelfish", "Sargocentron", "iota",
          "Holocentridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Hawaiian Squirrelfish", "Sargocentron", "xantherythrum",
          "Holocentridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Longjaw Squirrelfish", "Sargocentron", "spiniferum",
          "Holocentridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Peppered Squirrelfish", "Sargocentron", "punctatissimum",
          "Holocentridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Spotfin Squirrelfish", "Neoniphon", "sammara",
          "Holocentridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Ambon Toby", "Canthigaster", "amboinensis",
          "Tetraodontidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Sailfin Tang", "Zebrasoma", "veliferum",
          "Acanthuridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Whitespotted Surgeonfish", "Acanthurus", "guttatus",
          "Acanthuridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Arc-eye Hawkfish", "Paracirrhites", "arcatus",
          "Cirrhitidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Moana Kali", "Parupeneus", "cyclostomus",
          "Priacanthidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Ladyfish", "Elops", "hawaiensis",
          "Elopidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Milkfish", "Chanos", "chanos",
          "Chanidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Hogfish", "Bodianus", "bilunulatus",
          "Labridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Hawaiian Hogfish", "Bodianus", "albotaeniatus",
          "Labridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Atlantic Blue Marlin", "Makaira", "nigricans",
          "Istiophoridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Sailfish", "Istiophorus", "platypterus",
          "Istiophoridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Black Marlin", "Makaira", "indica",
          "Istiophoridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Swordfish", "Xiphins", "gladius",
          "Xiphiidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Ball's Pipefish", "Cosmocampus", "balli",
          "Syngnathidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Bandit Angelfish", "Apolemichthys", "arcuatus",
          "Pentacerotidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Barred Conger", "Ariosoma", "fasciatus",
          "Congridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Barred Knifejaw", "Oplegnathus", "fasciatus",
          "Oplegnathidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Barred Tidepool Goby", "Kelloggella", "oligolepis",
          "Gobiidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Belted Wrasse", "Stethojulis", "balteata",
          "Labridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Bicolor Anthias", "Pseudanthias", "bicolor",
          "Serranidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Black Coral Goby", "Bryaninops", "tigris",
          "Gobiidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Black Surgeonfish", "Acanthurus", "hawaiiensis",
          "Acanthuridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Blackchin Tilapia", "Sarotherodon", "melanotheron",
          "Cirrhitidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Blackfin Barracuda", "Sphyraena", "qenie",
          "Sphyraenidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Blackfin Chromis", "Chromis", "vanderbilti",
          "Pomacentridae", null, "images/fish/"));
        FishDB.addFish(new FishFormData("Blacklip Butterflyfish", "Chaetodon", "kleinii",
          "Chaetodontidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Blue-eye Damselfish", "Plectroglyphidodon", "johnstonianus",
          "Pomacentridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Blueline Triggerfish", "Xanthichthys", "caeruleolineatus",
          "Balistidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Bluestripe Pipefish", "Doryhamphus", "excisus",
          "Syngnathidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Boreham's Sole", "Aseraggodes", "borehami",
          "Soleidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Bright-eye Damselfish", "Plectroglyphidodon", "imparipennis",
          "Pomacentridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("White Trevally", "Pseudocaranx", "dentex",
          "Carangidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Chevron Butterflyfish", "Chaetodon", "trifascialis",
          "Chaetodontidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Chocolate Dip Chromis", "Chromis", "hanui",
          "Pomacentridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Cloudy Goby", "Opua", "nephodes",
          "Gobiidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Commerson's Frogfish", "Antennarius", "commerson",
          "Antennariidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Cookiecutter Shark", "Isistius", "brasilliensis",
          "Dalatiidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Coral Scorpionfish", "Scorpaenodes", "corallinus",
          "Scorpaenidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Gilded Triggerfish", "Xanthichthys", "mento",
          "Balistidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Curious Wormfish", "Gunnellichthys", "curiosis",
          "Microdesmidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Cushion Star Pearlfish", "Carapus", "mourlani",
          "Carapidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Beardfish", "Polymixia", "berndti",
          "Polymixiidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Striated Wrasse", "Pseudocheilinus", "evanidus",
          "Labridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Divine Pygmy Goby", "Eviota", "epiphanes",
          "Gobiidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Dwarf Scorpionfish", "Scorpaenodes", "fowleri",
          "Scorpaenidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Earle's Splitfin Anthias", "Luzonicthys", "earlei",
          "Serranidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Edmondson's Pipefish", "Halicampus", "edmonsoni",
          "Syngnathidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Squirrelfish Snapper", "Etelis", "carbunculus",
          "Lutjanidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Eight-lined Wrasse", "Pseudocheilinus", "octotaenia",
          "Labridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Elegant Anthias", "Caprodon", "unicolor",
          "Serranidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Elegant Coris", "Coris", "venusta",
          "Labridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Ewa Fang Blenny", "Plagiotremus", "ewaensis",
          "Blenniidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Exclamation Point Dragonet", "Synchiropus", "corallinus",
          "Callionymidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Eyebar Goby", "Gnatholepis", "anjerensis",
          "Gobiidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Finescale Triggerfish", "Balistes", "polylepis",
          "Balistidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Fire Dartfish", "Nemateleotris", "magnifica",
          "Ptereleotridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Fisher's Angelfish", "Centropyge", "fisheri",
          "Pomacanthidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Fivestripe Wrasse", "Thalassoma", "quinquevittatum",
          "Labridae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Flagtail Tilefish", "Malacanthus", "brevirostris",
          "Malacanthidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Flame Angelfish", "Centropyge", "loriculus",
          "Pomacanthidae", null, "images/fish/"));
      FishDB.addFish(new FishFormData("Flame Wrasse", "Cirrhilabrus", "jordani",
          "Labridae", null, "images/fish/"));



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

      kaaawa.addNumberOfFish(FishDB.getFish("Oval Butterflyfish"), 20);
      kaaawa.addNumberOfFish(FishDB.getFish("Brick Soldierfish"), 19);
      kaaawa.addNumberOfFish(FishDB.getFish("Great Barracuda"), 15);
      kaaawa.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 14);
      kaaawa.addNumberOfFish(FishDB.getFish("Great White Shark"), 13);
      kaaawa.addNumberOfFish(FishDB.getFish("Longnose Hawkfish"), 5);
      kaaawa.addNumberOfFish(FishDB.getFish("Fisher's Seahorse"), 4);
      kaaawa.addNumberOfFish(FishDB.getFish("Moorish Idol"), 3);
      kaaawa.addNumberOfFish(FishDB.getFish("Hawaiian Freckled Frogfish"), 2);
      kaaawa.addNumberOfFish(FishDB.getFish("Hawaiian Yellow Anthias"), 1);

      punaluu.addNumberOfFish(FishDB.getFish("Great Barracuda"), 141);
      punaluu.addNumberOfFish(FishDB.getFish("Moorish Idol"), 5435);
      punaluu.addNumberOfFish(FishDB.getFish("Fisher's Seahorse"), 3535);
      punaluu.addNumberOfFish(FishDB.getFish("Hawaiian Flagtail"), 13);
      punaluu.addNumberOfFish(FishDB.getFish("Brown Tang"), 14);
      punaluu.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 41414);
      punaluu.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 323);
      punaluu.addNumberOfFish(FishDB.getFish("Viper Moray"), 453);
      punaluu.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 543);
      punaluu.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 353);

      hauula.addNumberOfFish(FishDB.getFish("Great Barracuda"), 200);
      hauula.addNumberOfFish(FishDB.getFish("Moorish Idol"), 130);
      hauula.addNumberOfFish(FishDB.getFish("Fisher's Seahorse"), 122);
      hauula.addNumberOfFish(FishDB.getFish("Ember Parrotfish"), 55);
      hauula.addNumberOfFish(FishDB.getFish("Brown Tang"), 33);
      hauula.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 30);
      hauula.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 14);
      hauula.addNumberOfFish(FishDB.getFish("Viper Moray"), 13);
      hauula.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 12);
      hauula.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 11);

      laie.addNumberOfFish(FishDB.getFish("Great Barracuda"), 1000);
      laie.addNumberOfFish(FishDB.getFish("Brown Tang"), 5);

      kahuku.addNumberOfFish(FishDB.getFish("Hawaiian Sergeant"), 99);
      kahuku.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 300);
      kahuku.addNumberOfFish(FishDB.getFish("Hawaiian Flagtail"), 30);
      kahuku.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 22);
      kahuku.addNumberOfFish(FishDB.getFish("Brown Tang"), 12);
      kahuku.addNumberOfFish(FishDB.getFish("Bluestripe Snapper"), 13);
      kahuku.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 1000);
      kahuku.addNumberOfFish(FishDB.getFish("Viper Moray"), 3);
      kahuku.addNumberOfFish(FishDB.getFish("Hawaiian Yellow Anthias"), 2);
      kahuku.addNumberOfFish(FishDB.getFish("Longnose Hawkfish"), 1);

      kahukuPoint.addNumberOfFish(FishDB.getFish("Great White Shark"), 1235);
      kahukuPoint.addNumberOfFish(FishDB.getFish("Great Barracuda"), 678);
      kahukuPoint.addNumberOfFish(FishDB.getFish("Viper Moray"), 99);
      kahukuPoint.addNumberOfFish(FishDB.getFish("Giant Grouper"), 300);

      kawelaBay.addNumberOfFish(FishDB.getFish("Giant Grouper"), 11);
      kawelaBay.addNumberOfFish(FishDB.getFish("Bluestripe Snapper"), 13);
      kawelaBay.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 15);
      kawelaBay.addNumberOfFish(FishDB.getFish("Viper Moray"), 3);
      kawelaBay.addNumberOfFish(FishDB.getFish("Hawaiian Yellow Anthias"), 2);
      kawelaBay.addNumberOfFish(FishDB.getFish("Longnose Hawkfish"), 4);
      kawelaBay.addNumberOfFish(FishDB.getFish("Brown Tang"), 55);
      kawelaBay.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 21);
      kawelaBay.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 65);
      kawelaBay.addNumberOfFish(FishDB.getFish("Viper Moray"), 3);

      sunsetPoint.addNumberOfFish(FishDB.getFish("Hawaiian Flagtail"), 764);
      sunsetPoint.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 636);
      sunsetPoint.addNumberOfFish(FishDB.getFish("Viper Moray"), 222);
      sunsetPoint.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 434);
      sunsetPoint.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 221);

      pupukea.addNumberOfFish(FishDB.getFish("Oval Butterflyfish"), 242);
      pupukea.addNumberOfFish(FishDB.getFish("Brick Soldierfish"), 141);
      pupukea.addNumberOfFish(FishDB.getFish("Great Barracuda"), 525);
      pupukea.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 656);
      pupukea.addNumberOfFish(FishDB.getFish("Great White Shark"), 4242);

      waimeaBay.addNumberOfFish(FishDB.getFish("Bluestripe Snapper"), 1);
      waimeaBay.addNumberOfFish(FishDB.getFish("Great Barracuda"), 2);
      waimeaBay.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 3);
      waimeaBay.addNumberOfFish(FishDB.getFish("Great White Shark"), 4);
      waimeaBay.addNumberOfFish(FishDB.getFish("Panther Flounder"), 5);

      haleiwa.addNumberOfFish(FishDB.getFish("Bluestripe Snapper"), 6);
      haleiwa.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 7);
      haleiwa.addNumberOfFish(FishDB.getFish("Viper Moray"), 8);
      haleiwa.addNumberOfFish(FishDB.getFish("Hawaiian Yellow Anthias"), 9);
      haleiwa.addNumberOfFish(FishDB.getFish("Longnose Hawkfish"), 50);

      waialua.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 20001);

      mokuleia.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 9869);
      mokuleia.addNumberOfFish(FishDB.getFish("Viper Moray"), 747);
      mokuleia.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 52);
      mokuleia.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 5252);
      mokuleia.addNumberOfFish(FishDB.getFish("Great Barracuda"), 141);
      mokuleia.addNumberOfFish(FishDB.getFish("Brown Tang"), 414);

      makua.addNumberOfFish(FishDB.getFish("Oval Butterflyfish"), 431);
      makua.addNumberOfFish(FishDB.getFish("Brick Soldierfish"), 43);
      makaha.addNumberOfFish(FishDB.getFish("Great Barracuda"), 24);
      makaha.addNumberOfFish(FishDB.getFish("Panther Flounder"), 14);
      makaha.addNumberOfFish(FishDB.getFish("Great White Shark"), 13);

      waianae.addNumberOfFish(FishDB.getFish("Great Barracuda"), 141);
      waianae.addNumberOfFish(FishDB.getFish("Moorish Idol"), 5435);
      waianae.addNumberOfFish(FishDB.getFish("Fisher's Seahorse"), 3535);
      waianae.addNumberOfFish(FishDB.getFish("Hawaiian Flagtail"), 13);
      waianae.addNumberOfFish(FishDB.getFish("Brown Tang"), 14);
      waianae.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 41414);
      waianae.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 323);
      waianae.addNumberOfFish(FishDB.getFish("Viper Moray"), 453);
      waianae.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 543);
      waianae.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 353);

      maili.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 9869);
      maili.addNumberOfFish(FishDB.getFish("Viper Moray"), 747);

      nanakuli.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 52);
      nanakuli.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 5252);
      nanakuli.addNumberOfFish(FishDB.getFish("Great Barracuda"), 141);
      nanakuli.addNumberOfFish(FishDB.getFish("Brown Tang"), 414);
      nanakuli.addNumberOfFish(FishDB.getFish("Oval Butterflyfish"), 431);

      koolina.addNumberOfFish(FishDB.getFish("Brick Soldierfish"), 43);
      koolina.addNumberOfFish(FishDB.getFish("Great Barracuda"), 24);
      koolina.addNumberOfFish(FishDB.getFish("Great White Shark"), 13);

      barbersPoint.addNumberOfFish(FishDB.getFish("Great Barracuda"), 200);
      barbersPoint.addNumberOfFish(FishDB.getFish("Moorish Idol"), 130);
      barbersPoint.addNumberOfFish(FishDB.getFish("Fisher's Seahorse"), 122);
      ewa.addNumberOfFish(FishDB.getFish("Ember Parrotfish"), 55);
      ewa.addNumberOfFish(FishDB.getFish("Brown Tang"), 33);
      ewa.addNumberOfFish(FishDB.getFish("Reef Triggerfish"), 30);
      ewa.addNumberOfFish(FishDB.getFish("Yellowstripe Goatfish"), 14);
      ewa.addNumberOfFish(FishDB.getFish("Viper Moray"), 13);
      ewa.addNumberOfFish(FishDB.getFish("Bluefin Trevally"), 12);
      ewa.addNumberOfFish(FishDB.getFish("Christmas Wrasse"), 11);

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
