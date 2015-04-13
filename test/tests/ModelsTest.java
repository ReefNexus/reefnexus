package tests;

import models.User;
import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ModelsTest extends WithApplication {

  @Before
  public void setUp() {
    //start(fakeApplication(inMemoryDatabase()));
  }

  @Test
  public void createAndRetrieveUser() {
    new User("bob@gmail.com", "Bob", "secret").save();
    User bob = User.find.where().eq("email", "bob@gmail.com").findUnique();
    assertNotNull(bob);
    assertEquals("Bob", bob.name);
  }

  @Test
  public void tryAuthenticateUser() {
    new User("bob@gmail.com", "Bob", "secret").save();

    assertNotNull(User.authenticate("bob@gmail.com", "secret"));
    assertNull(User.authenticate("bob@gmail.com", "badpassword"));
    assertNull(User.authenticate("tom@gmail.com", "secret"));
  }
}