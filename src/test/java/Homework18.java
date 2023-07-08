import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

// we create a test case, playASongTest() method using @Test annotation
// we create a new configuration xml file for the test case: SongTest.xml file
// we specify the method to be run in the xml file
    @Test
    public void playASongTest() throws InterruptedException {

 // Calling the helper (reusable) methods defined in the BaseTest
        navigateToPage();
        provideEmail("tesfaye.abagaz@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

// calling the test steps methods defined in the Homework18 class
// validate a song is playing by verifying if the sound bar, or the pause button is displayed
        playSong();
        Assert.assertTrue(isSongPlaying());
    }

    public void playSong() throws InterruptedException {
        WebElement playNextButton = driver.findElement(By.xpath("*//*[@id='mainFooter']/div[1]/i[2]"));
        WebElement playButton = driver.findElement(By.xpath("*//*[@id='mainFooter']/div[1]/span/span[2]"));

        playNextButton.click();
        playButton.click();
        Thread.sleep(5000);
    }

    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("*//*[@id='mainFooter']/div[2]/div[2]/div/button[1]/div"));
        return soundBar.isDisplayed();
    }
}
