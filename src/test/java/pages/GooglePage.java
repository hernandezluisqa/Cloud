package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GooglePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Selector: El cuadro de búsqueda de Google
    private By searchBox = By.name("q");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navegarAGoogle() {
        driver.get("https://www.google.com");
    }

    public void escribirBusqueda(String texto) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        element.sendKeys(texto);
        element.submit();
    }
}