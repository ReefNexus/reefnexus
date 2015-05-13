package controllers;

import models.LocationDB;
import play.mvc.Security;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.AccountFormData;
import views.formdata.LocationFormData;
import views.html.AddFish;
import views.html.Database;
import views.html.FishInLocation;
import views.html.Index;
import views.html.LocationData;
import views.html.Login;
import views.html.Profile;

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
   * @param id The long equal to the ID number of the fish to display.
   * @return The AddPage.
   */
  public static Result fishProfile(long id) {
    return ok(views.html.FishProfile.render("Fish Profile", id));
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
    Form<AccountFormData> formData = Form.form(AccountFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
  }

  /**
   * Processes a login form submission from an unauthenticated user.
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data.
   * If errors not found, render the page with the good data.
   * @return The index page with the results of validation.
   */
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<AccountFormData> formData = Form.form(AccountFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.profile());
    }
  }

  /**
   * Logs out (only for authenticated users) and returns them to the Index page.
   * @return A redirect to the Index page.
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }

  /**
   * Provides the Profile page (only to authenticated users).
   * @return The Profile page.
   */
  @Security.Authenticated(Secured.class)
  public static Result profile() {
    return ok(Profile.render("Profile", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }

  /**
   * Returns the page on which to display fish images and labels.
   *
   * @param locationName    The String containing the name of the Location to retrieve images for.
   *
   * @return The FishInLocation.
   *
   */

  public static Result fishInLocation(String locationName) {
    models.Location toShow = LocationDB.getLocation(locationName.replaceAll("_", " "));

    // If invalid, display error
    if (toShow == null) {
      return badRequest(FishInLocation.render("Invalid request for " + locationName.replaceAll("_", " "),
                                              locationName.replaceAll("_", " ") + " not found"));
    }
    // Else return the LocationData page
    else {
      return ok(FishInLocation.render("Fish In Location", locationName.replaceAll("_", " ")));
    }
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
          name.replaceAll("_", " ") + " not found"));
    }
    // Else return the LocationData page
    else {
      return ok(LocationData.render("Location Data", name.replaceAll("_", " ")));
    }
  }
}
