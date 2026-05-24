package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        // Configuración básica del navegador
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // 1. Captura la pantalla como un array de bytes
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // 2. Adjunta la captura al reporte de Allure
            Allure.addAttachment("Evidencia del Error", new ByteArrayInputStream(screenshot));

            // 3. Opcional: Adjuntar la URL donde falló
            Allure.addAttachment("URL del fallo", driver.getCurrentUrl());
        }

        // Cerramos el navegador siempre al finalizar
        if (driver != null) {
            driver.quit();
        }
    }

}
