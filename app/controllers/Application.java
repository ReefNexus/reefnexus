package controllers;

import models.LocationDB;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.Database;
import views.html.AddFish;
import views.html.LocationData;
import views.html.Login;
import views.html.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render("Home"));
  }

  /**
   * Returns the page on which to add fish.
   *
   * @return The AddPage.
   */
  public static Result addFish() {
    return ok(AddFish.render("Add Fish"));
  }

  /**
   * Returns the page on which to display all fish.
   *
   * @return The Database.
   */
  public static Result database() {
    return ok(Database.render("Database"));
  }

  /**
   * Returns the page on which to display fish locations.
   *
   * @return The Location.
   */
  public static Result location() {
    return ok(views.html.Location.render("Location"));
  }

  /**
   * Returns the page on which to log in.
   *
   * @return The Login.
   */
  public static Result login() {
    return ok(Login.render("Login"));
  }

  /**
   * Returns the page on which to display user information.
   *
   * @return The User.
   */
  public static Result user() {
    return ok(User.render("User"));
  }

  /**
   * Returns the page on which to display location information.
   *
   * @param name    The String equal to the name of the Location data to get and display.
   *
   * @return The User.
   */
  public static Result locationData(String name) {
    models.Location toShow = LocationDB.getLocation(name.replaceAll("_", " "));

    // If invalid, display error
    if (toShow == null) {
      return badRequest(LocationData.render("Invalid request for " + name.replaceAll("_", " "),
                                            name.replaceAll("_", " ") + " not found", new HashMap<Long, Long>()));
    }
    // Else return the LocationData page
    else {
      Map<Long, Long> fishCounts = toShow.getFishCounts();
      return ok(LocationData.render("Location Data", name.replaceAll("_", " "), fishCounts));
    }
  }
}
