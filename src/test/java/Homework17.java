
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


// Applying Inheritance, homework17 (child) class extends or absorbs properties of BaseTest (parent) class
    public class Homework17 extends BaseTest {

/* TestNG uses Java annotations to declare tests and their life cycle (i.e. what happens before and after each test)
   The annotation @Test is used to designate the test methods
   The annotations @Before Suites and @BeforeMethod specify the test setup
   The annotation @AfterMethod is provided for the teardown  */
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotificationText = "Added 1 song into";

// Calling the helper (reusable) methods defined in the BaseTest
        navigateToPage();
        provideEmail("tesfaye.abagaz@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

// Adding the Test Steps/Methods
//        searchSong(  "Pluto");
        Thread.sleep(3000);
        searchSong(  "Dark Days"); // may be needed to fix browser reference for first time user
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));
    }

// WebDriver Methods, WebElement Methods and Location Strategies
// We specify the basic locators using the class By in the Selenium WebDriver API
// We use CSS selectors and XPath to find web elements and interact with them
    public void searchSong (String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.clear();
        searchField.sendKeys(songTitleKeyword); // displays song Pluto in the search field
        searchField.clear();
        Thread.sleep(5000);
    }

    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
        viewAllSearchResult.click(); // not able to click on the "View All" button; and to find element as expected: TEST FAILS
        Thread.sleep(5000); // selectors are copied directly from the Chrome dev tools
    }

    public void selectFirstSongResult() throws InterruptedException {
//        WebElement firstSongResult = driver.findElement(By.cssSelector("#songsResultsWrapper > div > div > div.item.container > table > tr"));
        WebElement firstSongResult = driver.findElement(By.cssSelector("#songResultsWrapper tr:nth-child(1) td.title"));//nth-child(1) locates the first song result in the list
        firstSongResult.click(); // selectors are copied directly from Chrome dev tools
        Thread.sleep(5000);
    }

    public void clickAddToBtn() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to"));
        addToBtn.click(); // selectors are copied directly from Chrome dev tools
        Thread.sleep(5000);
    }

    public void choosePlaylist() throws InterruptedException {
        // we created a playlist named 'Test Pro Playlist'
//        WebElement playlistElement = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/u1/li[80]"));
        WebElement playlistElement = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//li[contains(text(),'Galaxy')]"));
        //used the xpath contains() function and used the text/playlist name to select it


        playlistElement.click(); // selectors are copied directly from Chrome dev tools, and modified for input type: playlist name
        Thread.sleep(5000);
    }

    public String getNotificationText() {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText(); // selectors are copied from the "Slides HW Solution"; unable to locate the element on the web page
    }

}
