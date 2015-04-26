package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Testing support for the Database view.
 *
 * Created by Branden Ogata on 4/24/2015.
 *
 */

public class DatabasePage extends FluentPage {
  private String url;

  /**
   * Creates a new DatabasePage.
   *
   * @param driver    The WebDriver that presumably drives this page.
   * @param port      The int equal to the port number to use.
   *
   */

  public DatabasePage(WebDriver driver, int port) {
    super(driver);
    this.url = "http://localhost:" + port + "/database";
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).contains("Database");
  }
}
