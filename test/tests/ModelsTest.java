package tests;

import models.Account;
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
    new Account("bob@gmail.com", "Bob", "secret").save();
    Account bob = Account.find.where().eq("email", "bob@gmail.com").findUnique();
    assertNotNull(bob);
    assertEquals("Bob", bob.name);
  }

  /**
   * Authenticate a user.
   */
//  @Test
  public void tryAuthenticateUser() {
    new Account("bob@gmail.com", "Bob", "secret").save();

    assertNotNull(Account.authenticate("bob@gmail.com", "secret"));
    assertNull(Account.authenticate("bob@gmail.com", "badpassword"));
    assertNull(Account.authenticate("tom@gmail.com", "secret"));
  }
}