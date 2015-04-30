package tests;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.AddFishPage;
import tests.pages.DatabasePage;
import tests.pages.FishProfilePage;
import tests.pages.IndexPage;
import tests.pages.LocationPage;
import tests.pages.LoginPage;
import tests.pages.ProfilePage;

import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Runs a server with a fake in-memory database to test the system.
 */
public class IntegrationTest {
  private static final int PORT = 3333;

  /**
   * Test that all pages can be retrieved properly.
   *
   */

  @Test
  public void testPageRender() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();

        // Index page
        IndexPage index = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(index);
        index.isAt();

        // AddFish page
        AddFishPage addFish = new AddFishPage(browser.getDriver(), PORT);
        browser.goTo(addFish);
        addFish.isAt();

        // Database page
        DatabasePage database = new DatabasePage(browser.getDriver(), PORT);
        browser.goTo(database);
        database.isAt();

        // FishProfile page
        FishProfilePage fishProfile = new FishProfilePage(browser.getDriver(), PORT);
        browser.goTo(fishProfile);
        fishProfile.isAt();

        // Location page
        LocationPage location = new LocationPage(browser.getDriver(), PORT);
        browser.goTo(location);
        location.isAt();

        // Login page
        LoginPage login = new LoginPage(browser.getDriver(), PORT);
        browser.goTo(login);
        login.isAt();

        // Need to examine how to test LocationData; if no ID provided, then the request is bad,
        //                                           if ID provided, need to ensure that the ID is valid in test DB

        // Profile page
        ProfilePage profile = new ProfilePage(browser.getDriver(), PORT);
        browser.goTo(profile);
        profile.isAt();

      }
    });
  }
}
