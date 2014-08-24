import static org.junit.Assert.*;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Teste1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/Cadastro/Codigo/tela.php";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testE1() throws Exception {
    driver.get(baseUrl + "/Cadastro/Codigo/tela.php");
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Giovane Galvão");
    driver.findElement(By.name("empresa")).clear();
    driver.findElement(By.name("empresa")).sendKeys("UTFPR");
    driver.findElement(By.name("endereco")).clear();
    driver.findElement(By.name("endereco")).sendKeys("END1");
    driver.findElement(By.name("cidade")).clear();
    driver.findElement(By.name("cidade")).sendKeys("PONTA GROSSA");
    driver.findElement(By.name("estado")).clear();
    driver.findElement(By.name("estado")).sendKeys("PR");
    driver.findElement(By.name("fone")).clear();
    driver.findElement(By.name("fone")).sendKeys("TEL1");
    driver.findElement(By.name("descricao")).clear();
    driver.findElement(By.name("descricao")).sendKeys("DOAÇÃO");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
