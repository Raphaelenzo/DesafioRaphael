package testeOlx.core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static testeOlx.core.DriverFactory.getNavegador;

public class BasePage {

    /*###ACESSAR###*/
    public static void abrirLink(String link) {
        getNavegador().get(link);
    }

    /*#### TEXTOS ####*/
    public static void escrever(By by, String texto) {
        aguardarElementoVisivel(by, 15);
        getNavegador().findElement(by).clear();
        getNavegador().findElement(by).sendKeys(texto);
    }

    public static String obterTexto(By by) {
        return getNavegador().findElement(by).getText();
    }

    /*#### ELEMENTOS ####*/
    public static WebDriverWait webDriverWait(int timeOutInSeconds) {
        WebDriverWait wait;
        return wait = new WebDriverWait(getNavegador(), timeOutInSeconds);
    }

    public static WebElement aguardarElementoVisivel(By by, int timeOutInSeconds) {
        return webDriverWait(timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement aguardarElementoClicavel(By by, int timeOutInSeconds) {
        return webDriverWait(timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void clicar(By by, int timeOutInSeconds) {
        aguardarElementoVisivel(by, timeOutInSeconds);
        getNavegador().findElement(by).click();
    }

    public static void mouseOver(By by, int timeOutInSeconds) {
        aguardarElementoVisivel(by, timeOutInSeconds);
        WebElement element = getNavegador().findElement(by);
        Actions action = new Actions(getNavegador());
        action.moveToElement(element).perform();
    }

    /*###### ABAS NAVEGADOR #########*/

    public static void alternaAbas(String index, int timeOutInSeconds) {
        List<String> aba = new ArrayList<String>(getNavegador().getWindowHandles());
        getNavegador().switchTo().window(aba.get(Integer.parseInt(index)));
    }

    public static void fecharAba() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_W);
    }

    /*#### screenshot ####*/

    public static void tirarScreenshot(WebDriver navegador, String arquivo) {
        File screenshot = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(arquivo));
        } catch (Exception e) {
            System.out.println("Houveram problemas para copiar o arquivo para pagina: " + e.getMessage());
        }
    }

    public static void pause(int timeOutInMilliSeconds) {
        try {
            Thread.sleep(timeOutInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String horaArquivo() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("HHmmss").format(ts);
    }


}
