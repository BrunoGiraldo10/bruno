package StepsDefinitions;

import Page.Buscador;
import Page.Mensaje;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.SeparatorUI;
import java.util.concurrent.TimeUnit;

public class Steps {

public static WebDriver driver;
Buscador buscador;
Mensaje mensaje;



    @Before
    public void Start(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        buscador = new Buscador(driver);
        mensaje = new Mensaje(driver);

    }

    @Given("^que me encuentro en el buscador$")
    public void que_me_encuentro_en_el_buscador() {

        driver.get("https://www.google.com.pe/");

    }

    @When("^busco la temperatura de lima$")
    public void busco_la_temperatura_de_lima() {

        buscador.Buscador();

    }

    @Then("^me muestra los grados actuales$")
    public void me_muestra_los_grados_actuales() {

        mensaje.mensaje();

    }

}
