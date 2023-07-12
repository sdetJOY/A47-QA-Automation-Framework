import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;


    public class Homework21 extends BaseTest {


    // declaring a variable for the new playlist
    // notice it is declared outside of @Test annotation
    String newPlaylistName = "Test Pro Edited Playlist";

    @Test
    public void renamePlaylist() { //throws InterruptedException

        // navigateToPage(); not used; URL is passed as a parameter: see BaseTest class and TestNG.xml

        // reusable methods defined in BaseTest
        provideEmail("tesfaye.abagaz@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        //Test case = test steps to rename a Playlist after double click
        doubleClickPlayList();
        enterNewPlaylistName();

        //Verify and validate the name of the playlist is displayed
        Assert.assertTrue(doesPlaylistExist());
    }

    public void doubleClickPlayList() {
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playListElement).perform();;
    }
    
    public void enterNewPlaylistName() {
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));

        // Clear() does not work, element has an attribute of "required"
        // workaround is ctrl A (to select all) then backspace to clear, then replace with new playlist
        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);
    }
    
    public boolean doesPlaylistExist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+newPlaylistName+"']")));
        return playlistElement.isDisplayed();
        // verify and validate new playlist name is displayed --- this is expected Assertion
    }

}
