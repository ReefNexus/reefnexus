package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Class to hold users.
 */
@Entity
public class User extends Model {

  /**
   * Finder method.
   */
  public static Finder<String, User> find = new Finder<String, User>(
      String.class, User.class
  );

  /** User credentials. **/
  @Id
  /** User email. **/
  public String email;
  /**
   * User name. **/
  public String name;
  /**
   * User password. **/
  public String password;

  /**
   * Constructor which takes in a user's email, name, and password.
   *
   * @param email    The user's email.
   * @param name     The user's name.
   * @param password The user's password.
   */
  public User(String email, String name, String password) {
    this.email = email;
    this.name = name;
    this.password = password;
  }

  /**
   * Authenticate the user.
   *
   * @param email    The user's email.
   * @param password The user's password.
   * @return Authentication.
   */
  public static User authenticate(String email, String password) {
    return find.where().eq("email", email)
        .eq("password", password).findUnique();
  }
}