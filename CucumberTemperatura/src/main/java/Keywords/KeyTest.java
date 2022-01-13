package Keywords;

import Datos.ExcelClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;


public class KeyTest {

    private WebDriver driver;
    static ExcelClass excelClass;

    public KeyTest(WebDriver driver) {

        this.driver = driver;
        excelClass = new ExcelClass("Data/dataTest.xlsx");

    }

    public WebElement findElement(String varLocator){
        return driver.findElement(locator(varLocator));
    }

    public void waitLoaderVisible(String varLocator, int segundos)
    {
        WebDriverWait wait = new WebDriverWait(driver, segundos);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator(varLocator)));
    }

    public void waitLoaderClickable(String varLocator, int segundos)
    {
        WebDriverWait wait = new WebDriverWait(driver, segundos);
        wait.until(ExpectedConditions.elementToBeClickable(locator(varLocator)));
    }

    public String type(String nameInput, String stringlocator, String CP) {

        String inputText = excelClass.searchCampo("Hoja1", nameInput, CP);
        driver.findElement(locator(stringlocator)).sendKeys(inputText);


        return inputText;
    }
    public String findElement_getText(String varLocator)
    {
        String getText="";

        getText = driver.findElement(locator(varLocator)).getText();


        return getText;
    }
    public void sendKeys(String input, String varLocator)
    {

        driver.findElement(locator(varLocator)).sendKeys(input);

    }



    public void click(String varLocator)
    {

            driver.findElement(locator(varLocator)).click();

    }


    public void clear(String varLocator){

        driver.findElement(locator(varLocator)).clear();
    }

    public By locator(String varLocator)
    {
        By byLocator;
        String[] part = varLocator.split(":",2);
        String valor = part[0];
        int tipo = (valor.equals("id"))?1:(valor.equals("name"))?2:(valor.equals("className"))?3:(valor.equals("tagName"))?4:(valor.equals("linkText"))?5:(valor.equals("partialLinkText"))?6:(valor.equals("cssSelector"))?7:(valor.equals("xpath"))?8:0;

        switch (tipo)
        {
            case 1: byLocator=By.id(part[1]);break;
            case 2: byLocator=By.name(part[1]);break;
            case 3: byLocator=By.className(part[1]);break;
            case 4: byLocator=By.tagName(part[1]);break;
            case 5: byLocator=By.linkText(part[1]);break;
            case 6: byLocator=By.partialLinkText(part[1]);break;
            case 7: byLocator=By.cssSelector(part[1]);break;
            case 8: byLocator=By.xpath(part[1]);break;
            default: byLocator=By.id(part[1]);break;
        }

        return byLocator;
    }
    public static void takeSnapShot(WebDriver webdriver, String fileWithPath){

        try {
            //Convert web driver object to TakeScreenshot
            TakesScreenshot scrShot =((TakesScreenshot)webdriver);
            //Call getScreenshotAs method to create image file
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            //Move image file to new destination
            File DestFile=new File(fileWithPath);
            //Copy file at destination
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void screenShot()
    {
        String NameCarpeta = "C:\\Users\\bruno.giraldo\\IdeaProjects\\CucumberTemperatura\\ScreamShot\\";
        String fileWithPath = NameCarpeta+"imagen_"+(Math.random()*2000+1)+".jpg";
        takeSnapShot(driver, fileWithPath);

    }



}
