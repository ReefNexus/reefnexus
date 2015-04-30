package controllers;

import models.LocationDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.LocationFormData;
import views.html.AddFish;
import views.html.Database;
import views.html.FishProfile;
import views.html.Index;
import views.html.LocationData;
import views.html.Login;
import views.html.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   *
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
    Form<LocationFormData> formData = Form.form(LocationFormData.class);
    return ok(AddFish.render(formData));
  }

  /**
   * Returns the page on fish profile.
   *
   * @return The AddPage.
   */
  public static Result fishProfile() {
    return ok(FishProfile.render("Fish Profile"));
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
   * @param id The long equal to the ID number of the location to display.
   * @return The Location.
   */
  public static Result location(long id) {
    return ok(views.html.Location.render("Location", id));
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
   * @return The Profile.
   */
  public static Result profile() {
    return ok(Profile.render("Profile"));
  }

  /**
   * Authenticates the user login.
   *
   * @return The page to go to if successful;
   * else a badRequest.
   */

  public static Result addFishToLoc() {
    Form<LocationFormData> formData = Form.form(LocationFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      System.out.println("Error occurred!");
      return badRequest(AddFish.render(formData));
    }
    else {
      LocationFormData data = formData.get();
      LocationDB.addFish(data);
      System.out.format("Received %s %s \n", data.location, data.fish);
      return ok(views.html.Location.render("Location", LocationDB.getId(data.location)));
    }
  }

  /**
   * Returns the page on which to display location information.
   *
   * @param name The String equal to the name of the Location data to get and display.
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
