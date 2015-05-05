package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Testing support for the Profile view.
 *
 * Created by Branden Ogata on 4/24/2015.
 *
 */

public class ProfilePage extends FluentPage {
  private String url;

  /**
   * Creates a new ProfilePage.
   *
   * @param driver    The WebDriver that presumably drives this page.
   * @param port      The int equal to the port number to use.
   *
   */

  public ProfilePage(WebDriver driver, int port) {
    super(driver);
    this.url = "http://localhost:" + port + "/profile";
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).contains("Profile");
  }
}
