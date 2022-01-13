package Page;

import Keywords.KeyTest;
import org.openqa.selenium.WebDriver;

public class Buscador extends KeyTest {

    String busca = "name:q";
    String boton = "name:btnK";

    public Buscador(WebDriver driver) {
        super(driver);
    }


    public void Buscador(){

        type("INPUTBUSCADOR",busca,"CP1");
        screenShot();
        click(boton);



    }
}
