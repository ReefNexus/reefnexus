package tests;

import models.User;
import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Testing class to test user authentication.
 */
public class ModelsTest extends WithApplication {

  /**
   * Set up in memory database.
   */
//  @Before
  public void setUp() {
    //start(fakeApplication(inMemoryDatabase()));
  }

  /**
   * Create and retrieve a user.
   */
//  @Test
  public void createAndRetrieveUser() {
    new User("bob@gmail.com", "Bob", "secret").save();
    User bob = User.find.where().eq("email", "bob@gmail.com").findUnique();
    assertNotNull(bob);
    assertEquals("Bob", bob.name);
  }

  /**
   * Authenticate a user.
   */
//  @Test
  public void tryAuthenticateUser() {
    new User("bob@gmail.com", "Bob", "secret").save();

    assertNotNull(User.authenticate("bob@gmail.com", "secret"));
    assertNull(User.authenticate("bob@gmail.com", "badpassword"));
    assertNull(User.authenticate("tom@gmail.com", "secret"));
  }
}