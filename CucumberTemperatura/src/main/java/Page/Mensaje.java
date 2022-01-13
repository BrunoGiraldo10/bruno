package Page;

import Keywords.KeyTest;
import org.openqa.selenium.WebDriver;

public class Mensaje  extends KeyTest {

    String tempe = "id:wob_tm";

    public Mensaje(WebDriver driver) {
        super(driver);
    }


    public void mensaje (){

        screenShot();
        String men = findElement_getText(tempe);
        System.out.println("TEMPERATURA: " + men);
    }
}

