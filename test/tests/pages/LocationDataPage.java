package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Testing support for the LocationData view.
 *
 * Created by Branden Ogata on 4/24/2015.
 *
 */

public class LocationDataPage extends FluentPage {
  private String url;
  private String locationName;

  /**
   * Creates a new LocationDataPage.
   *
   * This will fail because no ID number was provided.
   *
   * @param driver    The WebDriver that presumably drives this page.
   * @param port      The int equal to the port number to use.
   *
   */

  public LocationDataPage(WebDriver driver, int port) {
    super(driver);
    this.url = "http://localhost:" + port + "/locationData";
    this.locationName = "";
  }

  /**
   * Creates a new LocationDataPage.
   *
   * @param driver        The WebDriver that presumably drives this page.
   * @param port          The int equal to the port number to use.
   * @param locationName  The int equal to the ID number of the Location to retrieve data for.
   *
   */

  public LocationDataPage(WebDriver driver, int port, String locationName) {
    super(driver);
    this.url = "http://localhost:" + port + "/locationData/" + locationName;
    this.locationName = locationName;
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(pageSource()).contains(locationName);
  }

  /**
   * Tests that the page load was unsuccessful due to an invalid or nonexistent location name.
   *
   */

  public void isNotAt() {
    assertThat(pageSource()).doesNotContain("LocationData");
  }
}
