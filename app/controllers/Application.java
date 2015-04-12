package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.AddFish;
import views.html.Database;
import views.html.Index;
import views.html.Location;
import views.html.Login;
import views.html.Profile;

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
    return ok(Location.render("Location"));
  }

  /**
   * Returns the page on which to log in.
   *
   * @return The Login.
   */
  public static Result login() {
    return ok(Login.render(Form.form(LoginCred.class)));
  }

  /**
   * Returns the page on which to display user information.
   *
   * @return The Profile.
   */
  public static Result profile() {
    return ok(Profile.render("Profile"));
  }

  public static Result authenticate() {
    Form<LoginCred> loginForm = Form.form(LoginCred.class).bindFromRequest();
    if (loginForm.hasErrors()) {
      return badRequest(Login.render(loginForm));
    } else {
      session().clear();
      session("email", loginForm.get().email);
      return redirect(
          controllers.routes.Application.index()
      );
    }
  }

  public static class LoginCred {

    public String email;
    public String password;

    public String validate() {
      if (User.authenticate(email, password) == null) {
        return "Invalid user or password";
      }
      return null;
    }

  }
}
