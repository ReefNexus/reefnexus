package tests;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.AddFishPage;
import tests.pages.IndexPage;

import static org.fest.assertions.Assertions.assertThat;
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

      }
    });
  }
}
