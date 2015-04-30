package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Testing support for the FishProfile view.
 *
 * Created by Branden Ogata on 4/24/2015.
 *
 */

public class FishProfilePage extends FluentPage {
  private String url;

  /**
   * Creates a new FishProfilePage.
   *
   * @param driver    The WebDriver that presumably drives this page.
   * @param port      The int equal to the port number to use.
   *
   */

  public FishProfilePage(WebDriver driver, int port) {
    super(driver);
    this.url = "http://localhost:" + port + "/fishProfile";
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).contains("Fish Profile");
  }
}
