package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Testing support for the Location view.
 *
 * Created by Branden Ogata on 4/24/2015.
 *
 */

public class LocationPage extends FluentPage {
  private String url;

  /**
   * Creates a new LocationPage.
   *
   * @param driver    The WebDriver that presumably drives this page.
   * @param port      The int equal to the port number to use.
   *
   */

  public LocationPage(WebDriver driver, int port) {
    super(driver);
    this.url = "http://localhost:" + port + "/location";
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).contains("Location");
  }
}
