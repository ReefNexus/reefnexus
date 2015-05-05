package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Class to hold users.
 *
 * Note that this is called "Account" rather than "User" due to a naming conflict; "User" is a reserved keyword.
 */
@Entity
public class Account extends Model {

  /**
   * Finder method.
   */
  public static Finder<String, Account> find = new Finder<String, Account>(
      String.class, Account.class
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
   * Creates a new empty Account instance.
   *
   */

  public Account() {
    this("", "", "");
  }

  /**
   * Constructor which takes in a user's email, name, and password.
   *
   * @param email    The user's email.
   * @param name     The user's name.
   * @param password The user's password.
   */
  public Account(String email, String name, String password) {
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
  public static Account authenticate(String email, String password) {
    return find.where().eq("email", email)
        .eq("password", password).findUnique();
  }
}