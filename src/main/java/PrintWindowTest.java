import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class PrintWindowTest {

    /**
     * Run In Debug
     */

    @Test
    public void printWindowTest() {

        open("https://www.google.ru/");

        /**
         * Emulate the opening of the print window of our application by the button (use console in browser)
         * 1. opening new window by command:  window.open('', "_blank", "toolbar=1, scrollbars=1, resizable=1, width=" + 1015 + ", height=" + 800)
         * 2. open the console in a new window and run the command: window.print() (print window should appear in 2 window)
         */
        System.out.println("This is the place to stop in debug \n");

        System.out.println("Open windows visible by web driver now: " + WebDriverRunner.getWebDriver().getWindowHandles().size() + "\n");

        System.out.println("Switch to the last window \n");
        Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);

        System.out.println("execute the command: window.close() \n");
        Selenide.executeJavaScript("window.close()");


        System.out.println("Open windows visible by web driver now: " + WebDriverRunner.getWebDriver().getWindowHandles().size() + "\n");

        System.out.println("Switch to the first window \n");
        Selenide.switchTo().window(0);

        assertEquals(1, WebDriverRunner.getWebDriver().getWindowHandles().size());

        System.out.println("You are wonderful!");
    }

}
