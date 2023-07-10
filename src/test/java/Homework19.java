import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {


    @Test
    public void deletePlaylist() throws InterruptedException {
        String deletedPlaylistMsg = "Deleted playlist";

       // navigateToPage(); not used; URL is passed as a parameter: see BaseTest class and TestNG.xml

        // reusable methods
        provideEmail("tesfaye.abagaz@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        // Handler methods....test steps
        openPlaylist();
        clickDeletePlaylistBtn();

        //confirmDelete(); // clicks on "button OK", not used

        // validate and verify : "Deleted Playlist" is Displayed
        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));

    }


    public void openPlaylist() {   //throws InterruptedException
        //WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        emptyPlaylist.click(); // the first playlist listed is empty i.e. has no songs
        //Thread.sleep(2000);
    }

    public void clickDeletePlaylistBtn() {  //throws InterruptedException
        //WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click(); // deletes the playlist
        //Thread.sleep(2000);
    }

    public void confirmDelete() { //throws InterruptedException
        //WebElement confirmBtn = driver.findElement(By.cssSelector("button.ok"));
        WebElement confirmBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ok")));
        confirmBtn.click(); // clicks on "OK" to confirm
        //Thread.sleep(2000);
    }

    public String getDeletedPlaylistMsg() {
        //WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText(); // displays "Deleted Playlist: InterStellar"
    }

}
